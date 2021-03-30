package com.example.adapterdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.widget.GridView;

import com.example.adapterdemo.adapter.ProductAdapter;
import com.example.adapterdemo.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductListActivity extends AppCompatActivity {

    GridView gridView;
    ProductAdapter adapter;
    List<Product> products = new ArrayList<Product>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        gridView=findViewById(R.id.gridView);
        adapter=new ProductAdapter(products,this);
        gridView.setAdapter(adapter);
        gridView.setColumnWidth(getWindowsWidthSize()/2);
        adapter.setItemWidth(getWindowsWidthSize()/2);
        getProducts();
    }
    private int getWindowsWidthSize(){
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        return size.x;
    }

    private void getProducts(){
        for (int i=0; i<50; i++){
            products.add(new Product(
                            700d,
                            R.drawable.product
            ));
            products.add(new Product(
                    752d,
                    R.drawable.auto_temperature
            ));
            products.add(new Product(
                    700d,
                    R.drawable.processed
            ));

        }
        adapter.notifyDataSetChanged();
    }
}
