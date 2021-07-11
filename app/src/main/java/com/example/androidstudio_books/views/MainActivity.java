package com.example.androidstudio_books.views;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.androidstudio_books.R;
import com.example.androidstudio_books.adapter.BooksAdapter;
import com.example.androidstudio_books.dominio.BooksClass;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //access to recyclerview and set to R. Create a variable for recyclerView.
        RecyclerView recyclerView = findViewById(R.id.recyclerview);

        //set layout
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //data and layout of list
        List<BooksClass> booksClassList = new ArrayList<>();

        BooksClass b1 = new BooksClass(1L, "Quem tem medo do feminismo negro?","Djamila Ribeiro","Companhia das Letras", true);
        BooksClass b2 = new BooksClass(2L, "Insubmissas Lágrimas de Mulheres","Conceição Evaristo","Malê", false);
        BooksClass b3 = new BooksClass(3L, "(Como eu Ensino) Escravidão no Brasil","Joel Rufino Dos Santos","Melhoramentos", false);
        BooksClass b4 = new BooksClass(4L, "Heroínas negras basileiras em 15 cordéis","Jarid Arraes","Pólen", true);
        BooksClass b5 = new BooksClass(5L, "Rastros de resistência: Histórias de luta e liberdade do povo negro","Ale Santos","Panda Books", false);
        BooksClass b6 = new BooksClass(6L, "O perigo de uma história única","Chimamanda Ngozi Adichie","Companhia das Letras", true);
        BooksClass b7 = new BooksClass(7L, "Meio Sol Amarelo","Chimamanda Ngozi Adichie","Companhia das Letras", true);
        BooksClass b8 = new BooksClass(8L, "Eu sou Malala - A história da garota que defendeu o direito à educação e foi baleada pelo Talibã","Malala Yousafzai, Christina Lamb","Companhia das Letras", false);


        booksClassList.add(b1);
        booksClassList.add(b2);
        booksClassList.add(b3);
        booksClassList.add(b4);
        booksClassList.add(b5);
        booksClassList.add(b6);
        booksClassList.add(b7);
        booksClassList.add(b8);

        BooksAdapter booksAdapter = new BooksAdapter(booksClassList, this);
        recyclerView.setAdapter(booksAdapter);

    }
}