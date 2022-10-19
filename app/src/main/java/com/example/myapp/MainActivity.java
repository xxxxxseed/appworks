package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //객체 선언
    TextView text1;
    Button btn;
    static boolean run = false;    //상태 변수

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //객체 생성
        text1 = findViewById(R.id.text1);
        btn = findViewById(R.id.btn);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //text1.setText("안녕하세요");
                if(view==btn){
                    text1.setText("안녕하세요");
                    //run = true;
                }
                if(view==btn){
                    text1.setText("Hello");
                    //run = false;
                }
            }
        };

        btn.setOnClickListener(listener);

        //버튼 클릭 이벤트
        /*btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //text1.setText("안녕하세요");


                if(run==false){

                    text1.setText("안녕하세요");
                    run = true;
                }
                if(run==true){

                    text1.setText("Hello");
                    run = false;
                }
            }
        });*/
    }
}