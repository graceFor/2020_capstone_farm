package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Where_DetailAdapter extends RecyclerView.Adapter<Where_DetailAdapter.ViewHolder> {
    private ArrayList<MyData> mDataset;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public ImageView mImageView;
        public TextView name, detail,place, widths, around, call;

        public ViewHolder(View view) {
            super(view);
            mImageView = (ImageView)view.findViewById(R.id.image);
            name = (TextView)view.findViewById(R.id.name);
            detail = (TextView)view.findViewById(R.id.detail);
            place = (TextView)view.findViewById(R.id.place);
            widths = (TextView)view.findViewById(R.id.width);
            around = (TextView)view.findViewById(R.id.around);
            call = (TextView)view.findViewById(R.id.call);

        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public Where_DetailAdapter(ArrayList<MyData> myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public Where_DetailAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.where_detail, parent, false);
        // set the view's size, margins, paddings and layout parameters

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element

        holder.name.setText(mDataset.get(position).name);
        holder.mImageView.setImageResource(mDataset.get(position).img);
        holder.detail.setText(mDataset.get(position).detail);
        holder.place.setText(mDataset.get(position).place);
        holder.widths.setText(mDataset.get(position).widths);
        holder.around.setText(mDataset.get(position).around);
        holder.call.setText(mDataset.get(position).call);

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}

class MyData{
    public String name;
    public String place;
    public String around;
    public String widths;
    public String call;
    public String detail;
    public int img;
    public MyData(String name, int img, String detail, String place, String widths, String around, String call){
        this.name = name;
        this.img = img;
        this.detail = detail;
        this.place= place;
        this.widths = widths;
        this.around = around;
        this.call= call;
    }
}


