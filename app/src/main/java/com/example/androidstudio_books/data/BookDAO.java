package com.example.androidstudio_books.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.androidstudio_books.dominio.BooksClass;

import java.util.ArrayList;
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
        //array for columns
        String[] columns = {
                BookContract.Columns._ID,
                BookContract.Columns.title,
                BookContract.Columns.author,
                BookContract.Columns.company,
                BookContract.Columns.read
        };

        //create a list of books
        List<BooksClass> booksArrayList = new ArrayList<>();


        //query | create a *cursor to be able to scroll through the data
        try(

        Cursor cursorData = db.query(BookContract.TABLE_NAME,
                columns,
                null,
                null,
                null,
                null,
                BookContract.Columns.title)
        ){
            if(cursorData.moveToFirst()){

                do{
                    BooksClass bookObj = BookDAO.fromCursor(cursorData);
                    booksArrayList.add(bookObj);


                }while (cursorData.moveToNext());
            }

        }
        return booksArrayList;
    }

    private static BooksClass fromCursor(Cursor cursorData){
        Long id = cursorData.getLong(cursorData.getColumnIndex(BookContract.Columns._ID));
        String title = cursorData.getString(cursorData.getColumnIndex(BookContract.Columns.title));
        String author = cursorData.getString(cursorData.getColumnIndex(BookContract.Columns.author));
        String company = cursorData.getString(cursorData.getColumnIndex(BookContract.Columns.company));
        int read = cursorData.getInt(cursorData.getColumnIndex(BookContract.Columns.read));

        return  new BooksClass(id, title, author, company, read);
    }

    //method create and insert in DB | id
    public void save(BooksClass booksClass){

        ContentValues values = new ContentValues();
        values.put(BookContract.Columns.title,booksClass.getTitle());
        values.put(BookContract.Columns.author,booksClass.getAuthor());
        values.put(BookContract.Columns.company,booksClass.getCompany());
        values.put(BookContract.Columns.read,booksClass.getToRead());


        Long id = db.insert(BookContract.TABLE_NAME,null,values);
        booksClass.setId(id);

    }

    //method update
    public void update(BooksClass booksClass){
        ContentValues values = new ContentValues();

        values.put(BookContract.Columns.title,booksClass.getTitle());
        values.put(BookContract.Columns.author,booksClass.getAuthor());
        values.put(BookContract.Columns.company,booksClass.getCompany());
        values.put(BookContract.Columns.read,booksClass.getToRead());

        db.update(BookContract.TABLE_NAME,
                values,
                BookContract.Columns._ID+"=?",
                new String[]{String.valueOf(booksClass.getId())}

        );

    }
    //method delete
    public void delete(BooksClass booksClass){
        db.delete(BookContract.TABLE_NAME,
                BookContract.Columns._ID+"=?",
                new String[]{String.valueOf(booksClass.getId())}
        );
    }

}
