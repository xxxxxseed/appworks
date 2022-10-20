package com.example.app_permission;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import com.example.app_permission.databinding.ActivityNotiExBinding;

public class NotiEx extends AppCompatActivity implements View.OnClickListener{

    ActivityNotiExBinding binding;
    NotificationManager manager;            //알림 전용 클래스
    NotificationCompat.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNotiExBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //이벤트 등록
        binding.btnBigPicture.setOnClickListener(this);
        binding.btnProgress.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            //채널 생성
            String channelId = "one-channel";
            String channelName = "My Channel One";
            String channelDescription = "My Channel One Description";
            NotificationChannel channel =
                    new NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription(channelDescription);

            //각종 채널에 대한 설정
            channel.enableLights(true);
            channel.setLightColor(Color.RED);
            channel.enableVibration(true);
            channel.setVibrationPattern(new long[]{100, 200, 300});
            manager.createNotificationChannel(channel);

            //채널이 등록된 builder
            builder = new NotificationCompat.Builder(this, channelId);
        }else{
            builder = new NotificationCompat.Builder(this);
        }

        //컨텐츠
        builder.setSmallIcon(android.R.drawable.ic_notification_overlay);
        builder.setWhen(System.currentTimeMillis());
        builder.setContentTitle("메시지 도착");
        builder.setContentText("안녕하세요");
        builder.setAutoCancel(true);
        Bitmap largeIcon =
                BitmapFactory.decodeResource(getResources(), R.drawable.noti_large);
        builder.setLargeIcon(largeIcon);

        //BigPictureStyle 알림
        if(view == binding.btnBigPicture){
            Bitmap bigPicture =
                    BitmapFactory.decodeResource(getResources(), R.drawable.noti_big);
            NotificationCompat.BigPictureStyle bigStyle =
                    new NotificationCompat.BigPictureStyle(builder);
            bigStyle.bigPicture(bigPicture);
            builder.setStyle(bigStyle);
        }
        manager.notify(222, builder.build());
    }
}