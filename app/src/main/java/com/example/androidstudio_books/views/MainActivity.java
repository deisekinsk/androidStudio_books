package com.example.androidstudio_books.views;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.androidstudio_books.R;
import com.example.androidstudio_books.adapter.BooksAdapter;
import com.example.androidstudio_books.data.BookDAO;
import com.example.androidstudio_books.dominio.BooksClass;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MainActivity extends AppCompatActivity implements BooksAdapter.OnBookListener{
    //attribute
    private BookDAO bookDAO;
    BooksAdapter booksAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //access to recyclerview and set to R. Create a variable for recyclerView.
        RecyclerView recyclerView = findViewById(R.id.recyclerview);

        //set layout
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //data and layout of list


      //  BooksClass b1 = new BooksClass(*1L, "Quem tem medo ... ","Djamila Ribeiro","Companhia das Letras", 0);
      //  BooksClass b2 = new BooksClass(*2L, "Insubmissas Lágrimas de Mulheres","Conceição Evaristo","Malê", 0);
      //  BooksClass b3 = new BooksClass(*3L, "(Como eu Ensino) Escravidão no Brasil","Joel Rufino Dos Santos","Melhoramentos", 0);
      //  BooksClass b4 = new BooksClass(*4L, "Heroínas negras ...","Jarid Arraes","Pólen", 1);
      //  BooksClass b5 = new BooksClass(*5L, "Rastros de resistência: Histórias de luta e liberdade do povo negro","Ale Santos","Panda Books", 0);
      //  BooksClass b6 = new BooksClass(*6L, "O perigo de uma história única","Chimamanda Ngozi Adichie","Companhia das Letras", 1);
      //  BooksClass b7 = new BooksClass(*7L, "Meio Sol Amarelo","Chimamanda Ngozi Adichie","Companhia das Letras", 1);
      //  BooksClass b8 = new BooksClass(8L, "Eu sou Malala - A história da garota que defendeu o direito à educação e foi baleada pelo Talibã","Malala Yousafzai, Christina Lamb","Companhia das Letras", 0);



        //DAO | Object of DAO
        bookDAO = BookDAO.getInstance(this);

        List<BooksClass> booksClassList = bookDAO.list();

        booksAdapter = new BooksAdapter(booksClassList, this);

        recyclerView.setAdapter(booksAdapter);

    }
    //method Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.actions,menu);

        return super.onCreateOptionsMenu(menu);

    }
    //select
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        switch (item.getItemId()){
            case R.id.action_add:
                Intent intent = new Intent(getApplicationContext(),EditBookActivity.class);
                startActivityForResult(intent, 100);
                return true;
            case R.id.action_logout:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onActivityResult (int requestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 100 && resultCode == RESULT_OK){
            refreshListBooks();

        }

    }

    public  void refreshListBooks(){
        List<BooksClass> books = bookDAO.list();
        booksAdapter.setItems(books);
        booksAdapter.notifyDataSetChanged();

    }
}