package com.example.first.jsonobjects;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.Gson;
import com.google.gson.JsonElement;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class LibraryAdapter extends RecyclerView.Adapter<LibraryAdapter.BookViewHolder> {

    ArrayList<Book> bookList = DataManager.getBookList();
    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.book_layout,parent,false);
        return new BookViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {

    holder.idTv.setText(bookList.get(position).id);
    holder.authorTv.setText(bookList.get(position).author);

    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }

    class BookViewHolder extends RecyclerView.ViewHolder {

        TextView authorTv, idTv;

        public BookViewHolder(@NonNull View itemView) {
            super(itemView);
            authorTv = itemView.findViewById(R.id.authorName);
            idTv = itemView.findViewById(R.id.bookId);

        }
    }

}
