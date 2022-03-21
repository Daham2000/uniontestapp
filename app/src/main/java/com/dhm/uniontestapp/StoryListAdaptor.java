package com.dhm.uniontestapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class StoryListAdaptor extends RecyclerView.Adapter<StoryListAdaptor.ViewHolder> {

    //    variables
    private ArrayList<String> imageUrlList;
    private ArrayList<String> nameList;
    private ArrayList<String> description;
    private ArrayList<String> expireDate;
    private Context context;
    private ViewHolder holder;
    private int position;

    public StoryListAdaptor(ArrayList<String> imageUrlList,
                            ArrayList<String> nameList,
                            ArrayList<String> description,
                            ArrayList<String> expireDate,
                            Context context) {
        this.imageUrlList = imageUrlList;
        this.nameList = nameList;
        this.context = context;
        this.description = description;
        this.expireDate = expireDate;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_component, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Glide.with(context).asBitmap().load(imageUrlList.get(position)).into(holder.image);
        holder.text.setText(nameList.get(position));
        holder.des.setText(description.get(position));
        holder.exp.setText(expireDate.get(position));
    }

    @Override
    public int getItemCount() {
        return imageUrlList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView text;
        TextView des;
        TextView exp;
        ImageView image;

        public ViewHolder(View itemView) {
            super(itemView);
            text = (TextView) itemView.findViewById(R.id.textCart);
            image = (ImageView) itemView.findViewById(R.id.image);
            des = (TextView) itemView.findViewById(R.id.textCartDescription);
            exp = (TextView) itemView.findViewById(R.id.textCartExpire);
        }
    }
}
