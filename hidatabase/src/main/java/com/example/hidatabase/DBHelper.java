package com.example.hidatabase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;

    public DBHelper(Context context){
        //DB 생성
        super(context, "memodb", null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //테이블 생성: execSQL() 함수 실행
        String memoSQL = "create table tb_memo(id integer primary key autoincrement, " +
                "title, " +
                "content)";
        db.execSQL(memoSQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //테이블 삭제
        if (newVersion == DATABASE_VERSION){
            db.execSQL("drop table tb_memo");
            onCreate(db);
        }
    }
}
