package com.example.a21111064248_saiminhhieu_lab7;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ProducDBHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "ProductDB";

    private static final int DB_VERSION=1;

    public ProducDBHelper(Context context){
        super(context,DB_NAME,null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String creat_table_sql="CREATE TABLE tableProduct(\n" +
                                "\tmaSP interger PRIMARY KEY,\n" +
                                "\ttenSP text,\n" +
                                "\tsoSP interger ,\n" +
                                "\tgiaSP double\n" +
                                ")";

        sqLiteDatabase.execSQL(creat_table_sql);

        String insert_table_sql  = "INSERT INTO tableProduct VALUES(1,'ten 1',12,13),(2,'ten 2',22,23)";

        sqLiteDatabase.execSQL(insert_table_sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        if (oldVersion != newVersion){
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS tableProduct");
            onCreate(sqLiteDatabase);
        }
    }
}
