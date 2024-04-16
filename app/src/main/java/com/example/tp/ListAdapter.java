package com.example.tp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.List;

public class ListAdapter extends BaseAdapter {
    List<OnePieceCharacter> collection;
    LayoutInflater inflater;
    public ListAdapter(List<OnePieceCharacter> liste, Context context){
        collection = liste;
        inflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return collection.size();
    }

    @Override
    public Object getItem(int position) {
        return collection.get(position);
    }

    @Override
    public long getItemId(int position) {
        return collection.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.list_item, null);
        ImageView img = convertView.findViewById(R.id.CharImage);
        TextView name = convertView.findViewById(R.id.CharName);
        RatingBar ratingBar = convertView.findViewById(R.id.ratingBar);
        TextView ratingValue = convertView.findViewById(R.id.ratingValue);
        name.setText(collection.get(position).getName());
        ratingBar.setRating(collection.get(position).getValue());
        ratingValue.setText(ratingBar.getRating()+"");

        return convertView;
    }
}