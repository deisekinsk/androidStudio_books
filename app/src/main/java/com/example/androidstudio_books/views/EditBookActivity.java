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

    private BooksClass booksClass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_book);

        edt_title = findViewById(R.id.edt_title);
        edt_author = findViewById(R.id.edt_author);
        edt_company = findViewById(R.id.edt_company);
        chk_read = findViewById(R.id.check_read);

        bookDAO = BookDAO.getInstance(this);

        booksClass = (BooksClass) getIntent().getSerializableExtra("book");

        //condition
        if(booksClass != null){
            edt_title.setText(booksClass.getTitle());
            edt_author.setText(booksClass.getAuthor());
            edt_company.setText(booksClass.getCompany());
            chk_read.setChecked((booksClass.getToRead()==1) ? true : false);
        }

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

        String msg;

        if(booksClass == null) {
            BooksClass bookObj = new BooksClass(title, author, company, read);
            bookDAO.save(bookObj);
            msg = "ADD with Success! ID="+bookObj.getId();
        }else{

            booksClass.setTitle(title);
            booksClass.setAuthor(author);
            booksClass.setCompany(company);
            booksClass.setToRead(read);

            bookDAO.update(booksClass);

            msg = "Refresh with Success! ID="+booksClass.getId();
        }

        
        setResult(RESULT_OK);
        finish();
    }
}