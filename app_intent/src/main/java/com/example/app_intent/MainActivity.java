package com.example.app_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText txt1;
    private Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.btn1);
        txt1 = findViewById(R.id.txt1);

        //버튼 클릭 이벤트
        btn1.setOnClickListener(view -> {
            String str = txt1.getText().toString();
            Intent intent = new Intent(MainActivity.this, SubActivity.class);

            //데이터 보내는 함수: putExtra()
            intent.putExtra("str", str);
            startActivity(intent);
        });
    }
}