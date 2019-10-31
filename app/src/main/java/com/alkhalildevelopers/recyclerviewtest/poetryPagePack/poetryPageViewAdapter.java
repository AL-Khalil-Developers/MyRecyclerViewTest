package com.alkhalildevelopers.recyclerviewtest.poetryPagePack;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alkhalildevelopers.recyclerviewtest.R;
import com.alkhalildevelopers.recyclerviewtest.favourite_list_sql.fvtsqlHelper;
import com.alkhalildevelopers.recyclerviewtest.model.PoetryData;

import java.util.List;

public class poetryPageViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public OnPoetryListClickListener mOnPoetryClickListener;
    List<PoetryData> selectedPoetryData;
    Context contextP;

    //favourite db
    fvtsqlHelper localDB;


    public poetryPageViewAdapter(@NonNull Context contextP, List<PoetryData> selectedPoetryData, OnPoetryListClickListener mOnPoetryClickListener) {
        this.contextP = contextP;
        this.selectedPoetryData = selectedPoetryData;
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


        ((poetryPP) holder).poetryLinesTxt.setText(selectedPoetryData.get(position).getPoetryLineText());





    }

    @Override
    public int getItemCount() {
        return selectedPoetryData.size();
    }

    // we creating our View Holder
    public class poetryPP extends RecyclerView.ViewHolder implements View.OnClickListener {
        private OnPoetryListClickListener mOnPoetryClickListener;
        TextView poetryLinesTxt;
        ImageButton shareBtn,copyBtn,whatsappBtn,addFvtBtn;
        LinearLayout container;

        public poetryPP(@NonNull View itemView, final OnPoetryListClickListener mOnPoetryClickListener) {
            super(itemView);
            this.mOnPoetryClickListener = mOnPoetryClickListener;
            addFvtBtn = itemView.findViewById(R.id.favtAddBtn);
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
            addFvtBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mOnPoetryClickListener !=null){
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION){
                            mOnPoetryClickListener.onAddFvtBtnClick(position);
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
        void onShareBtnClick(int position);
        void onCopyBtnClick(int position);
        void onWhatsappBtnClick (int position);
        void onAddFvtBtnClick (int position);
    }
}
