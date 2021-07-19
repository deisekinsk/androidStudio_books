package com.example.androidstudio_books.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.androidstudio_books.dominio.BooksClass;

import java.util.List;

public class BookDAO {

    //variables
    private SQLiteDatabase db;
    private static  BookDAO instance;

    private BookDAO (Context context){
        DBHelper dbHelper = DBHelper.getInstance(context);
        //access for DB
        db = dbHelper.getWritableDatabase();
    }

    //method for return instance of DAO
    public static  BookDAO getInstance(Context context){
        if(instance == null) {
            instance = new BookDAO(context.getApplicationContext());
        }
        return instance;
    }

    //method for return a list of db
    public List<BooksClass> list(){
        

    }


}
