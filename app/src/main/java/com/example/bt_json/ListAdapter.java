package com.example.bt_json;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ListAdapter extends ArrayAdapter<JSONItem> {
    private Context context;
    private ArrayList<JSONItem> jsonItems;

    public ListAdapter(Context context, ArrayList<JSONItem> jsonItems) {
        super(context, R.layout.product_item, jsonItems);
        this.context = context;
        this.jsonItems = jsonItems;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.product_item, parent, false);
        }
        JSONItem jsonItem = getItem(position);

        ImageView imageView = convertView.findViewById(R.id.product_pic);
        Picasso.get().load(jsonItem.getThumbnail()).into(imageView);

        TextView titleTextView = convertView.findViewById(R.id.txt_title);
        titleTextView.setText(jsonItem.getTitle());

        TextView brandTextView = convertView.findViewById(R.id.txt_brand);
        brandTextView.setText(jsonItem.getBrand());

        TextView priceTextView = convertView.findViewById(R.id.txt_price);
        priceTextView.setText(jsonItem.getPrice());

        TextView stockTextView = convertView.findViewById(R.id.txt_stock);
        stockTextView.setText(jsonItem.getStock());

        TextView cateTextView = convertView.findViewById(R.id.txt_cate);
        cateTextView.setText(jsonItem.getStock());

        TextView rateTextView = convertView.findViewById(R.id.txt_rating);
        rateTextView.setText(jsonItem.getStock());

        return convertView;
    }
}
