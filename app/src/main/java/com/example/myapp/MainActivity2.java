package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        list = findViewById(R.id.list);
        List<String> data = new ArrayList<>();

        //연결 기능 adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data);

        //listView에 data list를 설정
        list.setAdapter(adapter);
        data.add("강아지");
        data.add("고양이");
        data.add("송아지");
        data.add("망아지");

        adapter.notifyDataSetChanged();     //data 저장 완료
    }
}