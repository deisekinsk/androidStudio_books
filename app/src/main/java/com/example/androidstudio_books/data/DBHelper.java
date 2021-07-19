package com.example.androidstudio_books.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "booksDB";
    public static final int DB_VERSION = 1;

    //attribute
    private static DBHelper instance;
        //receive commands sql
    private static String SQL_CREATE = String.format(
                //_idCamp
            "CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT,"+
            "%s TEXT NOT NULL, %s TEXT NOT NULL, %s TEXT NOT NULL, %s INTEGER NOT NULL)",
        );



    //constructor
    public DBHelper(Context context){
        //parameter
        super(context, DB_NAME, null, DB_VERSION);
    }

    //methods
    public static  DBHelper getInstance(Context context){
        if (instance == null){
            instance = new DBHelper(context);
        }

        return instance;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
