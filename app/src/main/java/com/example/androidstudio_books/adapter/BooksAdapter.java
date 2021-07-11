package com.example.androidstudio_books.adapter;

import android.media.Image;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.androidstudio_books.R;

public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.BookHolder> {
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
