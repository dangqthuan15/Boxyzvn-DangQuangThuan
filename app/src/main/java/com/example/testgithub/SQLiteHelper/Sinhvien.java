package com.example.testgithub.SQLiteHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Sinhvien extends SQLiteOpenHelper {
    public static final String DB_NAME = "CRUD";
    public static final int DB_VERSION = 1;

    public Sinhvien(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql_crud = "CREATE TABLE tb_lop(id_lop INTEGER NOT NULL, ten_lop TEXT NOT NULL,nganh TEXT,PRIMARY KEY(id_lop AUTOINCREMENT))";
        sqLiteDatabase.execSQL(sql_crud);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
