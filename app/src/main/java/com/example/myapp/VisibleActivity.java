package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class VisibleActivity extends AppCompatActivity
implements View.OnClickListener{

    Button btn_vis_true;
    Button btn_vis_false;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visible);

        btn_vis_true = findViewById(R.id.btn_vis_true);
        btn_vis_false = findViewById(R.id.btn_vis_false);
        textView = findViewById(R.id.textView);

        //이벤트 등록
        btn_vis_true.setOnClickListener(this);
        btn_vis_false.setOnClickListener(this);
    }

    //버튼 이벤트 콜백 함수
    @Override
    public void onClick(View view) {
        if(view == btn_vis_true){
            textView.setVisibility(View.VISIBLE);
        }else if(view == btn_vis_false){
            textView.setVisibility(View.INVISIBLE);
        }
    }
}