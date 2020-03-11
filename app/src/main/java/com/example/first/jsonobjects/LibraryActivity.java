package com.example.first.jsonobjects;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

class LibraryActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.library_layout);

            RecyclerView bookList = findViewById(R.id.library);

            bookList.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));

            ArrayList<Book> list = new ArrayList<>();
            final LibraryAdapter adapter = new LibraryAdapter();

            //attach adapter to recyclerview
            bookList.setAdapter(adapter);




    }
}
