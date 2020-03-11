package com.example.first.jsonobjects;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class BookListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_list);
        String jsonString = getIntent().getStringExtra("books");
        JsonArray jsonArray = JsonParser.parseString(jsonString).getAsJsonArray();
        ArrayList<Book> bookArrayList;
        Type bookListType = new TypeToken<ArrayList<Book>>(){}.getType();
        bookArrayList = new Gson().fromJson(jsonArray, bookListType);
        for (Book book: bookArrayList) {
            TextView tv = findViewById(R.id.textView);
            tv.setText(book.name);

        }

    }
}
