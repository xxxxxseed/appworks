package com.example.hidatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.example.hidatabase.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding =
                ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.addBtn.setOnClickListener(view -> {
            //화면의 입력 데이터 가져오기
            String title = binding.addTitle.getText().toString();
            String content = binding.addContent.getText().toString();

            //DB 생성 및 객체 얻기
            DBHelper helper = new DBHelper(this);
            SQLiteDatabase db = helper.getWritableDatabase();

            //DB에 저장(삽입)
            db.execSQL("insert into tb_memo(title, content) values (?, ?)",
                    new String[]{title, content});
            db.close();

            //화면 이동 - 인텐트(Intent)
            Intent intent =
                    new Intent(MainActivity.this, ReadDBActivity.class);
            startActivity(intent);

        });

    }
}