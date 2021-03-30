package com.example.adapterdemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.adapterdemo.R;
import com.example.adapterdemo.model.Product;

import java.util.List;

public class ProductAdapter extends BaseAdapter {
    //1.list of product 2.Context and constructor and override

    List<Product> products;
    Context context;
    // set width of item
    int itemWidth;

    public void setItemWidth(int itemWidth) {
        this.itemWidth = itemWidth;
    }

    // constructor
    public ProductAdapter(List<Product> products, Context context) {
        this.products = products;
        this.context = context;
    }

    //override
    @Override
    public int getCount() {
        return products.size();
    }

    @Override
    public Object getItem(int position) {
        return products.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = null;
        if (convertView==null)
            view= LayoutInflater.from(context)
                    .inflate(R.layout.products_item_list,parent,false);
        else
            view=convertView;

        //bind data
        Product product = products.get(position);
        ImageView imageView=view.findViewById(R.id.imageView);
        TextView tvPrice=view.findViewById(R.id.tvPrice);
        ImageView btnFavorite=view.findViewById(R.id.btnfavorite);

        //set width item
        imageView.getLayoutParams().width=itemWidth;
        //Set data to layout
        imageView.setImageResource(product.getThumbnail());
             //Price is double covert to string
        tvPrice.setText(""+product.getPrice());
        btnFavorite.setOnClickListener(v -> {
            Toast.makeText(context, "add to favorite", Toast.LENGTH_SHORT).show();
        });
        return view;
    }
}
