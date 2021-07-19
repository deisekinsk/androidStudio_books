package com.example.androidstudio_books.adapter;

import android.content.Context;
import android.graphics.Color;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidstudio_books.R;
import com.example.androidstudio_books.dominio.BooksClass;

import java.util.List;

//iteration book list with layout for each line
public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.BookHolder> {
    //attributes
    private List<BooksClass> books;
    private Context context;

    private  OnBookListener onBookListener;


    //constructor
    public BooksAdapter (List<BooksClass>books, Context context, OnBookListener onBookListener){
        this.books = books;
        this.context = context;
        this.onBookListener = onBookListener;
    }


    //methods
    //method for return view hold
    @NonNull
    @Override
    public BookHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.item_book, parent, false);

        BookHolder bookHolder = new BookHolder(view, onBookListener);

        return bookHolder; //return for the method onBindViewHolder
    }
    //android make this form, and don't use declared FOR iteration in this situation.
    @Override
    public void onBindViewHolder(@NonNull BookHolder holder, int position) {
        BooksClass book = books.get(position);

        holder.txtTitle.setText(book.getTitle());
        holder.txtAuthor.setText(book.getAuthor());
        holder.txtCompany.setText(book.getCompany());

        //change color for the boolean case | put star
        if (book.getToRead() == 1){
            holder.ic_book.setColorFilter(0xFF165E25);
            holder.ic_star.setVisibility(View.VISIBLE);
        }else{
            holder.ic_book.setColorFilter(Color.parseColor("#734226"));
            holder.ic_star.setVisibility(View.INVISIBLE);
        }


    }

    //method for size of list
    @Override
    public int getItemCount() {
        return books.size();
    }

    public void setItems(List<BooksClass> books){
        this.books =books;

    }

    //method Adapter
    public BooksClass getItem(int position){
        return books.get(position);
    }




    //class that get information for cards + implements for long click
    public class BookHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener, View.OnLongClickListener {
        //attributes
        public TextView txtTitle;
        public TextView txtAuthor;
        public TextView txtCompany;
        public ImageView ic_book;
        public ImageView ic_star;

        public OnBookListener onBookListener;


        //constructor
        public BookHolder (View view, OnBookListener onBookListener){
            super(view);
            //constructor
            txtTitle = view.findViewById(R.id.txtTitle);
            txtAuthor = view.findViewById(R.id.txtAuthor);
            txtCompany = view.findViewById(R.id.txtCompany);
            ic_book = view.findViewById(R.id.ic_book);
            ic_star = view.findViewById(R.id.ic_star);

            this.onBookListener = onBookListener;

            //create long click on object book
            view.setOnClickListener(this);
            view.setOnLongClickListener(this);

        }

        //methods of implements
        @Override
        public void onClick(View view) {
            onBookListener.onBookClick(getAdapterPosition());

        }

        @Override
        public boolean onLongClick(View view) {
           onBookListener.onBookLongClick(getAdapterPosition());

            return true;
        }
    }
    //INTERFACE
    public interface OnBookListener{
        void onBookClick(int position);
        void onBookLongClick(int position);

    }

}
