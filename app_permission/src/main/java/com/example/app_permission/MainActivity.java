package com.example.app_permission;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.os.VibratorManager;

import com.example.app_permission.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    Vibrator vibrator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        //진동 클릭 이벤트
        binding.btnVib.setOnClickListener(view -> {
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.S){
                VibratorManager manager =
                        (VibratorManager) getSystemService(VIBRATOR_MANAGER_SERVICE);
                vibrator = manager.getDefaultVibrator();
            }else{
                vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
            }

            //진동 울림
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
                vibrator.vibrate(VibrationEffect.createOneShot(1000,
                        VibrationEffect.DEFAULT_AMPLITUDE));
            }else{
                vibrator.vibrate(1000);
            }
        });

        //시스템 효과음
        binding.btnBeep.setOnClickListener(view -> {
            Uri notification =
                    RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            Ringtone ringtone =
                    RingtoneManager.getRingtone(getApplicationContext(), notification);
            ringtone.play();
        });
    }
}