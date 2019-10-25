package com.alkhalildevelopers.recyclerviewtest;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.TextView;
import android.widget.Toast;

import com.alkhalildevelopers.recyclerviewtest.poetryPagePack.poetryPageViewAdapter;

import java.util.ArrayList;
import java.util.Objects;

public class poetryPage extends AppCompatActivity {
    TextView selectedTxt;
    RecyclerView poetryPageRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poetry_page);
        ArrayList<String> poetryData = new ArrayList<>();

        if (getIntent().hasExtra("title")){
            String selected = getIntent().getExtras().getString("title");


            // this is for-Loop Method
//            for (int i = 0;i <=20; ++i){
//                poetryData.add("( "+ i +" )"+"   Tere ishq ki intaha chahta hoon  meri sadagi to dekh main kya chahta hoon");
//            }


            // this is While-Loop Method
//            int i = 1;
//            while (i<=20){
//                poetryData.add("( "+ i +" )"+"   Tere ishq ki intaha chahta hoon  meri sadagi to dekh main kya chahta hoon");
//                    i++;
//            }

            // this is do-while-Loop Method
            int i=1;
            do {
                poetryData.add("( "+ i +" )"+"   Tere ishq ki intaha chahta hoon  meri sadagi to dekh main kya chahta hoon");
                ++i;
            }while (i<=20);


            // setting the title and icon
            ActionBar actionBar = getSupportActionBar();
            actionBar.setTitle(selected);
            actionBar.setIcon(R.mipmap.ic_launcher);
            actionBar.setDisplayShowHomeEnabled(true);




        }

        //now we are setting our RecyclerView Adater
        poetryPageRecycler = findViewById(R.id.poetryPageRecyclerViewID);
        poetryPageRecycler.setLayoutManager(new LinearLayoutManager(this));
        poetryPageRecycler.setAdapter(new poetryPageViewAdapter(getApplicationContext(),poetryData));

    }

}
