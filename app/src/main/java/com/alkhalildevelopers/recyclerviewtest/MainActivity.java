package com.alkhalildevelopers.recyclerviewtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements poetryViewAdapter.OnPoetryClickListener {
    RecyclerView poetryRecycle;
    ArrayList<String> myPoetryList= new ArrayList<>();
    Button GotoFvtBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GotoFvtBtn = findViewById(R.id.goToFavouriteBtn);
        myPoetryList.add("sad poetry");
        myPoetryList.add("میرانام خلیل ہے۔");
        poetryRecycle = findViewById(R.id.RecyclerViewID);
        poetryRecycle.setLayoutManager(new LinearLayoutManager(this));
        poetryRecycle.setAdapter(new poetryViewAdapter(this,myPoetryList,this));

        GotoFvtBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,FvtActivity.class));
                Toast.makeText(MainActivity.this, "Clicked on " + GotoFvtBtn.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public void poetyCategoryClick (int position) {
        Toast.makeText(this, "your clicked on : "+myPoetryList.get(position), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,poetryPage.class);
        intent.putExtra("title",myPoetryList.get(position));
        startActivity(intent);

    }


}
