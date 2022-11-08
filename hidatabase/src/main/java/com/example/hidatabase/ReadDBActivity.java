package com.example.hidatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.example.hidatabase.databinding.ActivityReadDbactivityBinding;

public class ReadDBActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityReadDbactivityBinding binding =
                ActivityReadDbactivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //db 객체 얻기
        DBHelper helper = new DBHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();

        //SELECT - rawQuery() 함수 사용
        Cursor cursor = db.rawQuery("select title, content from tb_memo order by id desc",
                null);
        while(cursor.moveToNext()){ //데이터가 있는 동안
            binding.readTitle.setText(cursor.getString(0));
            binding.readContent.setText(cursor.getString(1));
        }
        db.close();
    }
}