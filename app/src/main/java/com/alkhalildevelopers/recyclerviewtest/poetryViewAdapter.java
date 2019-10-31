package com.alkhalildevelopers.recyclerviewtest;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class poetryViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private OnPoetryClickListener mOnPoetryClickListener;
    Context context;
    private ArrayList <String> poetryList;
    poetryViewAdapter(Context context, ArrayList<String> poetryList, OnPoetryClickListener mOnPoetryClickListener){
        this.context = context;
        this.poetryList = poetryList;
        this.mOnPoetryClickListener= mOnPoetryClickListener;

    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.poetry_list_layout,parent,false);
        poetryList poetryList = new poetryList(view,mOnPoetryClickListener);
        return poetryList;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((poetryList)holder).poetryListTitle.setText(poetryList.get(position));

    }

    @Override
    public int getItemCount() {
        return poetryList.size();
    }




    public  class poetryList extends RecyclerView.ViewHolder implements View.OnClickListener {
        OnPoetryClickListener onPoetryClickListener;
        TextView poetryListTitle;
        public poetryList(@NonNull View itemView, final OnPoetryClickListener onPoetryClickListener) {
            super(itemView);
            poetryListTitle = itemView.findViewById(R.id.poetryListTitleText);
            this.onPoetryClickListener = onPoetryClickListener;
            poetryListTitle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onPoetryClickListener != null){
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION){
                            onPoetryClickListener.poetyCategoryClick(position);
                        }
                    }
                }
            });

        }


        @Override
        public void onClick(View v) {


        }
    }
    public interface OnPoetryClickListener{
         void poetyCategoryClick (int position);
    }

}
