package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;


public class EditEx extends AppCompatActivity {

    private Button btn;
    private ImageView img1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_ex);

        //객체 생성
        btn = findViewById(R.id.btn);
        img1 = findViewById(R.id.img1);

        //버튼 이벤트
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(EditEx.this, "버튼이 눌러졌습니다.", Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        //이미지 이벤트
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(EditEx.this, "이미지가 눌러졌습니다.", Toast.LENGTH_LONG);
                toast.show();
            }
        });


    }
}