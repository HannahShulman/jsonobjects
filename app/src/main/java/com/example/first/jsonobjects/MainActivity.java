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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    Button showBooks;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final JSONArray jsonArray = new JSONArray();
        Button addBook = findViewById(R.id.addBook);
        showBooks = findViewById(R.id.showBook);
        addBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText name,auther,date,id,description;
                name = findViewById(R.id.name);
                auther = findViewById(R.id.auther);
                date = findViewById(R.id.date);
                id = findViewById(R.id.id);
                description = findViewById(R.id.description);
                Book book = new Book(name.getText().toString(),auther.getText().toString(),date.getText().toString(),description.getText().toString(),Integer.parseInt(id.getText().toString()));
                jsonArray.put(book);

                if(jsonArray.length()>2){
                    showBooks.setClickable(true);
                }
            }
        });
               showBooks.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       Intent intent = new Intent(getBaseContext(), BookListActivity.class);
                       intent.putExtra("books", jsonArray.toString());
                       startActivity(intent);
                   }
               });

        /*JSONObject object = new JSONObject();
        try {
            object.put("title", "randomTitle");
            object.put("numPages", 32);
            object.put("id", 123);
            object.put("fgdg", 5465);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        Gson gson = new Gson();
        Book b = gson.fromJson(object.toString(), Book.class);

        Toast.makeText(this, ""+b.title, Toast.LENGTH_SHORT).show();
*/

    }
}
