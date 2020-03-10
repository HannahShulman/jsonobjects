package com.example.first.jsonobjects;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText name = findViewById(R.id.myBookName);
        final EditText author = findViewById(R.id.myAuthorName);
        final EditText dateB = findViewById(R.id.myDate);
        final EditText idB = findViewById(R.id.myId);
        final EditText desc = findViewById(R.id.myDescription);



        Button addcont = findViewById(R.id.addBookBtn);
        addcont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                JSONObject object = new JSONObject();
                try {
                    object.put("name",name);
                    object.put("author", author);
                    object.put("id", dateB);
                    object.put("date", idB);
                    object.put("description",desc);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Gson gson = new Gson();
                Book b = gson.fromJson(object.toString(), Book.class);
                DataManager.addBook(b);
            }
        });

        Button showB = findViewById(R.id.showBookBtn);
        showB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LibraryActivity.class);
                startActivity(intent);
            }
        });

        //DataManager.getBookList();
        //Toast.makeText(this, ""+b.title, Toast.LENGTH_SHORT).show();
    }
}
