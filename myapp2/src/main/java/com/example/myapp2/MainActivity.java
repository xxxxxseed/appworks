package com.example.myapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btn_vis_true;
    Button btn_vis_false;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_vis_true = findViewById(R.id.btn_vis_true);
        btn_vis_false = findViewById(R.id.btn_vis_false);
        textView = findViewById(R.id.textView);

        //보이기 버튼 클릭
        btn_vis_true.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setVisibility(View.VISIBLE);
            }
        });

        btn_vis_false.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setVisibility(View.INVISIBLE);
            }
        });
    }
}