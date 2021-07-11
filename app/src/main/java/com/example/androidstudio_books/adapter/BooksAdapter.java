package com.example.androidstudio_books.adapter;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

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


    //constructor
    public BooksAdapter (List<BooksClass>books, Context context){
        this.books = books;
        this.context = context;
    }


    //methods
    //method for return view hold
    @NonNull
    @Override
    public BookHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.item_book, parent, false);

        BookHolder bookHolder = new BookHolder(view);

        return bookHolder; //return for the method onBindViewHolder
    }
    //android make this form, and don't use declared FOR iteration in this situation.
    @Override
    public void onBindViewHolder(@NonNull BookHolder holder, int position) {
        BooksClass book = books.get(position);

        holder.txtTitle.setText(book.getTitle());
        holder.txtAuthor.setText(book.getAuthor());
        holder.txtCompany.setText(book.getCompany());



    }

    //method for size of list
    @Override
    public int getItemCount() {
        return books.size();
    }




    //class that get information for cards
    public class BookHolder extends RecyclerView.ViewHolder{
        public TextView txtTitle;
        public TextView txtAuthor;
        public TextView txtCompany;
        public ImageView ic_book;


        public BookHolder (View view){
            super(view);

            txtTitle = view.findViewById(R.id.txtTitle);
            txtAuthor = view.findViewById(R.id.txtAuthor);
            txtCompany = view.findViewById(R.id.txtCompany);
            ic_book = view.findViewById(R.id.ic_book);

        }

    }


}
