package com.example.app_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SubActivity extends AppCompatActivity {

    private TextView txt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        txt2 = findViewById(R.id.txt2);

        Intent intent = getIntent();    //보내진 intent를 받음
        //데이터 받기
        String name = intent.getStringExtra("str");
        txt2.setText(name);
    }
}