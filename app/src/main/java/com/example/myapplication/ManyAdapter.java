package com.example.myapplication;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ManyAdapter extends RecyclerView.Adapter<ManyAdapter.ViewHolder> {
    private ArrayList<ManyItem> mDataset;
    private LayoutInflater inflater;
    Context context;

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public CardView cv;
        public ImageView image;
        public TextView name, time, chat, good;


        public ViewHolder(View v) {
            super(v);
            cv = (CardView)v.findViewById(R.id.card_view);
            image = (ImageView)v.findViewById(R.id.image);
            name = (TextView)v.findViewById(R.id.name);
            time = (TextView)v.findViewById(R.id.time);
            chat = (TextView)v.findViewById(R.id.chat);
            good = (TextView)v.findViewById(R.id.good);
        }
    }

    public ManyAdapter(Context context, ArrayList<ManyItem> myDataset){
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.mDataset = myDataset;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.many_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.image.setImageResource(mDataset.get(position).getImage()) ;
        holder.name.setText(mDataset.get(position).getName());
        holder.time.setText(mDataset.get(position).getTime());
        holder.chat.setText(String.valueOf(mDataset.get(position).getChat())); //int를 가져온다는점 유의
        holder.good.setText(String.valueOf(mDataset.get(position).getGood())); //int를 가져온다는점 유의
        holder.cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle(1);
                ((MainActivity2)context).replaceFragment(Many_detail.newInstance(), bundle);
            }
        });



    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}

