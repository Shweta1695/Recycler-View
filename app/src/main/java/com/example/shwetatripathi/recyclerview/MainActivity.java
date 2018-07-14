package com.example.shwetatripathi.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.shwetatripathi.recyclerview.Adapter.RecyclerViewAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";

    private ArrayList<String> Title = new ArrayList<>();
    private ArrayList<String> imageURL = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initImageBitmap();
    }

    private void initImageBitmap(){
        imageURL.add("https://res.cloudinary.com/demo/image/upload/Sample.jpg");
        Title.add("FLOWER");
        imageURL.add("https://res.cloudinary.com/demo/image/upload/Sample.jpg");
        Title.add("FLOWER B");
        imageURL.add("https://res.cloudinary.com/demo/image/upload/Sample.jpg");
        Title.add("FLOWER C");
        imageURL.add("https://res.cloudinary.com/demo/image/upload/Sample.jpg");
        Title.add("FLOWER D");
        imageURL.add("https://res.cloudinary.com/demo/image/upload/Sample.jpg");
        Title.add("FLOWER E");
        imageURL.add("https://res.cloudinary.com/demo/image/upload/Sample.jpg");
        Title.add("FLOWER F");
        imageURL.add("https://res.cloudinary.com/demo/image/upload/Sample.jpg");
        Title.add("FLOWER G");

        RecyclerView();
    }

    private void RecyclerView(){
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, Title, imageURL);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}