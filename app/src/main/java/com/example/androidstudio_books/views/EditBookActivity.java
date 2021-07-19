package com.example.androidstudio_books.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.androidstudio_books.R;
import com.example.androidstudio_books.data.BookDAO;
import com.example.androidstudio_books.dominio.BooksClass;

public class EditBookActivity extends AppCompatActivity {

    //attributes
    private EditText edt_title;
    private EditText edt_author;
    private EditText edt_company;
    private CheckBox chk_read;

    private BookDAO bookDAO;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_book);

        edt_title = findViewById(R.id.edt_title);
        edt_author = findViewById(R.id.edt_author);
        edt_company = findViewById(R.id.edt_company);
        chk_read = findViewById(R.id.check_read);

        bookDAO = BookDAO.getInstance(this);

    }

    public void cancel(View view) {
        setResult((RESULT_CANCELED));
        finish();
    }

    public void process(View view) {
        String title = edt_title.getText().toString();
        String author = edt_author.getText().toString();
        String company = edt_company.getText().toString();
        int read = (chk_read.isChecked()) ? 1 : 0;

        BooksClass bookObj = new BooksClass(title, author, company,read);

        bookDAO.save(bookObj);

        String msg = "Success! ID="+bookObj.getId();
        setResult(RESULT_OK);
        finish();
    }
}