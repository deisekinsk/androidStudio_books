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

        booksClassList.add(b1);



        BooksAdapter booksAdapter = new BooksAdapter(booksClassList, this);
        recyclerView.setAdapter(booksAdapter);

    }
}