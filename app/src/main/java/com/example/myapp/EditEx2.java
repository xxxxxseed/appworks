package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class EditEx2 extends AppCompatActivity {

    private EditText editText;
    private Button btnSubmit;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_ex2);

        //객체 생성
        editText = findViewById(R.id.editText);
        btnSubmit = findViewById(R.id.btnSubmit);
        textView = findViewById(R.id.textView);

        //전송 버튼 이벤트
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //입력된 글자 가져오기
                String str = editText.getText().toString();
                textView.setText(str);
            }
        });
    }
}