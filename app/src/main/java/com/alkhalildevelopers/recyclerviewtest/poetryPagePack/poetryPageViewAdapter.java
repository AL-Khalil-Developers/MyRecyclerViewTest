package com.alkhalildevelopers.recyclerviewtest.poetryPagePack;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alkhalildevelopers.recyclerviewtest.R;

import java.util.ArrayList;

public class poetryPageViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public OnPoetryListClickListener mOnPoetryClickListener;
    ArrayList<String> poetryP = new ArrayList<>();
    Context contextP;

    public poetryPageViewAdapter(@NonNull Context contextP,ArrayList<String> poetryP,OnPoetryListClickListener mOnPoetryClickListener) {
        this.contextP = contextP;
        this.poetryP = poetryP;
        this.mOnPoetryClickListener = mOnPoetryClickListener;

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(contextP);
        View view = layoutInflater.inflate(R.layout.poetry_page_list_layout,parent,false);
        poetryPP poetryPP = new poetryPP(view,mOnPoetryClickListener);

        return poetryPP;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        //applying animation
        ((poetryPP)holder).container.setAnimation(AnimationUtils.loadAnimation(contextP,R.anim.main_anim));


        ((poetryPP)holder).poetryLinesTxt.setText(poetryP.get(position));
        ((poetryPP)holder).copyBtn.setId(Integer.parseInt("1"));
        ((poetryPP)holder).shareBtn.setId(Integer.parseInt("2"));
        ((poetryPP)holder).whatsappBtn.setId(Integer.parseInt("3"));


    }

    @Override
    public int getItemCount() {
        return poetryP.size();
    }

    // we creating our View Holder
    public class poetryPP extends RecyclerView.ViewHolder implements View.OnClickListener {
        private OnPoetryListClickListener mOnPoetryClickListener;
        TextView poetryLinesTxt;
        ImageButton shareBtn,copyBtn,whatsappBtn;
        LinearLayout container;

        public poetryPP(@NonNull View itemView, final OnPoetryListClickListener mOnPoetryClickListener) {
            super(itemView);
            this.mOnPoetryClickListener = mOnPoetryClickListener;

            container = itemView.findViewById(R.id.container_ID);
            poetryLinesTxt = itemView.findViewById(R.id.poetryLinesTxtID);
            shareBtn = itemView.findViewById(R.id.shareBtn);
            whatsappBtn = itemView.findViewById(R.id.whatsappBtn);
            copyBtn = itemView.findViewById(R.id.copyBtn);
            itemView.setOnClickListener(this);
            shareBtn.setOnClickListener(this);
            whatsappBtn.setOnClickListener(this);

            //for Whatsapp Button
            whatsappBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mOnPoetryClickListener != null){
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION){
                            mOnPoetryClickListener.onWhatsappBtnClick(position);
                        }
                    }
                }
            });

            //for share Butt
            shareBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mOnPoetryClickListener != null){
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION){
                            mOnPoetryClickListener.onShareBtnClick(position);
                        }
                    }
                }
            });


            //for Copy Button
            copyBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mOnPoetryClickListener != null){
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION){
                            mOnPoetryClickListener.onCopyBtnClick(position);
                        }
                    }
                }
            });

        }


        @Override
        public void onClick(View v) {

        }
    }

    public interface OnPoetryListClickListener {
        void onPoetryListClick(int position);
        void onShareBtnClick(int position);
        void onCopyBtnClick(int position);
        void onWhatsappBtnClick (int position);
    }
}
