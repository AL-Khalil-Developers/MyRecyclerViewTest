package com.alkhalildevelopers.recyclerviewtest.poetryPagePack;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alkhalildevelopers.recyclerviewtest.R;

import java.util.ArrayList;

public class poetryPageViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    ArrayList<String> poetryP = new ArrayList<>();
    Context contextP;
    public poetryPageViewAdapter(@NonNull Context contextP,ArrayList<String> poetryP) {
        this.contextP = contextP;
        this.poetryP = poetryP;

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(contextP);
        View view = layoutInflater.inflate(R.layout.poetry_page_list_layout,parent,false);
        poetryPP poetryPP = new poetryPP(view);

        return poetryPP;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
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
    public class poetryPP extends RecyclerView.ViewHolder {
        TextView poetryLinesTxt;
        ImageButton shareBtn,copyBtn,whatsappBtn;
        public poetryPP(@NonNull View itemView) {
            super(itemView);
            poetryLinesTxt = itemView.findViewById(R.id.poetryLinesTxtID);
            shareBtn = itemView.findViewById(R.id.shareBtn);
            whatsappBtn = itemView.findViewById(R.id.whatsappBtn);
            copyBtn = itemView.findViewById(R.id.copyBtn);
        }
    }
}
