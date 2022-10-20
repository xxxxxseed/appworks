package com.example.myapp4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class SubActivity extends AppCompatActivity {

    Button btnMove2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        btnMove2 = findViewById(R.id.btnMove2);

        btnMove2.setOnClickListener(view -> {
            Intent intent = new Intent(SubActivity.this, MainActivity.class);
            startActivity(intent);
        });
    }
}