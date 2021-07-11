package com.example.androidstudio_books.adapter;

import android.content.Context;
import android.media.Image;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidstudio_books.R;
import com.example.androidstudio_books.dominio.BooksClass;

import java.util.List;

public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.BookHolder> {
    //attributes
    private List<BooksClass> books;
    private Context context;


    //constructor
    public BooksAdapter (List<BooksClass>books, Context context){
        this.books = books;
        this.context = context;
    }


    //methods
    @NonNull
    @Override
    public BookHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull BooksAdapter.BookHolder holder, int position) {

    }

    //method for size of list
    @Override
    public int getItemCount() {
        return 0;
    }
    //iteration book list with layout for wich line



    public class BookHolder extends RecyclerView.ViewHolder{
        public TextView txtTitle;
        public TextView txtAuthor;
        public TextView txtEmploy;
        public ImageView ic_book;

    //class that get information for cards
        public BookHolder (View view){
            super(view);

            txtTitle = view.findViewById(R.id.txtTitle);
            txtAuthor = view.findViewById(R.id.txtAuthor);
            txtEmploy = view.findViewById(R.id.txtEmploy);
            ic_book = view.findViewById(R.id.ic_book);

        }

    }


}
