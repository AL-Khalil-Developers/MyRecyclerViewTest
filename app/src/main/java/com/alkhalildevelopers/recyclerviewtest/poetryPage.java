package com.alkhalildevelopers.recyclerviewtest;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.TextView;
import android.widget.Toast;

import com.alkhalildevelopers.recyclerviewtest.favourite_list_sql.fvtsqlHelper;
import com.alkhalildevelopers.recyclerviewtest.model.PoetryData;
import com.alkhalildevelopers.recyclerviewtest.poetryPagePack.poetryPageViewAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class poetryPage extends AppCompatActivity implements poetryPageViewAdapter.OnPoetryListClickListener {
    RecyclerView poetryPageRecycler;
    List<PoetryData> poetryData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poetry_page);
        poetryData = new ArrayList<>();

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

//            // this is do-while-Loop Method
//            int i=1;
//            do {
//                poetryData.add(new PoetryData("("+i+")"+"Welcome to Al-Khalil Developers"));
//                poetryData.add(new PoetryData("Welcome to Pakistan"));
//                poetryData.add(new PoetryData("میرانام خلیل ہے۔"));
//                ++i;
//            }while (i<=2000);
            poetryData.add(new PoetryData("Welcome to Pakistan"));
            poetryData.add(new PoetryData("میرانام خلیل ہے۔"));




            // setting the title and icon
            ActionBar actionBar = getSupportActionBar();
            actionBar.setTitle(selected);
            actionBar.setIcon(R.mipmap.ic_launcher);
            actionBar.setDisplayShowHomeEnabled(true);




        }

        //now we are setting our RecyclerView Adater
        poetryPageRecycler = findViewById(R.id.poetryPageRecyclerViewID);
        poetryPageRecycler.setLayoutManager(new LinearLayoutManager(this));
        poetryPageRecycler.setAdapter(new poetryPageViewAdapter(this,poetryData,this));




    }

    @Override
    public void onShareBtnClick(int position) {
        Intent sharePoetry = new Intent(Intent.ACTION_SEND);
        sharePoetry.setType("plain/text");
        String PoetryLine = poetryData.get(position).getPoetryLineText();
        sharePoetry.putExtra(Intent.EXTRA_TEXT,PoetryLine);
        startActivity(sharePoetry);
    }

    @Override
    public void onCopyBtnClick(int position) {
        ClipboardManager Clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clipData = ClipData.newPlainText("poetryTextLabel",poetryData.get(position).getPoetryLineText());
        Clipboard.setPrimaryClip(clipData);
        clipData.getDescription();
        Toast.makeText(this, "Poetry Lines Copied" , Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onWhatsappBtnClick(int position) {
        try {
            Intent whatsappIntent = new Intent(Intent.ACTION_SEND);
            whatsappIntent.setType("text/plain");
            whatsappIntent.putExtra(Intent.EXTRA_TEXT,poetryData.get(position).getPoetryLineText());
            whatsappIntent.setPackage("com.whatsapp");
            //
            startActivity(whatsappIntent);
        }catch (Exception e){
            Toast.makeText(this, "Whatsapp not Installed on your Phone " + e, Toast.LENGTH_SHORT).show();
        }


    }

    fvtsqlHelper fvtDBHelper = new fvtsqlHelper(this);

    @Override
    public void onAddFvtBtnClick(int position) {
        String selectedFvtPoetryText = poetryData.get(position).getPoetryLineText();
        fvtDBHelper.addFavorite(selectedFvtPoetryText);
        Toast.makeText(this, selectedFvtPoetryText, Toast.LENGTH_SHORT).show();
        ActionBar mActionBar = getSupportActionBar();
        mActionBar.setTitle(selectedFvtPoetryText);
        mActionBar.setSubtitle("Khalil");
    }

}
