package com.example.androidstudio_books.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.androidstudio_books.dominio.BooksClass;

public class DeleteDialog extends DialogFragment implements DialogInterface.OnClickListener {

    private BooksClass booksClass;

    private OnDeleteListener listener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if(!(context instanceof  OnDeleteListener)){

            throw new RuntimeException("It's not a OnDeleteListener");

        }
        this.listener = (OnDeleteListener) context;
    }

    @NonNull
    @Override

    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState){

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("Are you confirm exclude book "+booksClass.getTitle());
        builder.setPositiveButton("YES", this);
        builder.setNegativeButton("NO",this);

        return builder.create();

    }

    public void setBooksClass(BooksClass booksClass){
        this.booksClass = booksClass;
    }


    @Override
    public void onClick(DialogInterface dialogInterface, int i) {
        if(i == DialogInterface.BUTTON_POSITIVE){
            listener.onDelete(booksClass);
        }

    }

    public interface OnDeleteListener{
        void onDelete(BooksClass booksClass);
    }
}
