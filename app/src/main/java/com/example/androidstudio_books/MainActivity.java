package com.example.androidstudio_books;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

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
        //recyclerView.setAdapter();

    }
}