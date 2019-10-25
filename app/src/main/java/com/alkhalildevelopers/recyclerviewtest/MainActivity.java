package com.alkhalildevelopers.recyclerviewtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements poetryViewAdapter.OnPoetryClickListener {
    RecyclerView poetryRecycle;
    ArrayList<String> myPoetryList= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myPoetryList.add("sad poetry");
        myPoetryList.add("love Poetry");
        myPoetryList.add("urdu poetry");
        poetryRecycle = findViewById(R.id.RecyclerViewID);
        poetryRecycle.setLayoutManager(new LinearLayoutManager(this));
        poetryRecycle.setAdapter(new poetryViewAdapter(this,myPoetryList,this));
    }

    @Override
    public void onPoetryClick(int position) {
        Toast.makeText(this, "your clicked on : "+myPoetryList.get(position), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,poetryPage.class);
        intent.putExtra("title",myPoetryList.get(position));
        startActivity(intent);

    }
}
