package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class ToggleButtonEx extends AppCompatActivity {

    TextView txt1;
    ToggleButton btn_on_off;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toggle_button_ex);

        //객체 생성
        txt1 = findViewById(R.id.txt1);
        btn_on_off = findViewById(R.id.btn_on_off);

        btn_on_off.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                String toastMsg;
                if(b){
                    txt1.setText("전등 꺼짐");
                    toastMsg = "전원을 껐습니다.";
                }else{
                    txt1.setText("전등 켜짐");
                    toastMsg = "전원을 켰습니다.";
                }
                Toast.makeText(ToggleButtonEx.this, toastMsg, Toast.LENGTH_SHORT).show();
            }
        });


    }
}