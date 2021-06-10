package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ProductAdapter.IOnClickItem {
    List<Product> productList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //B1
        initData();
        //B2
        ProductAdapter productAdapter = new ProductAdapter(this,productList, this);
        //B3
        GridLayoutManager layoutManager = new GridLayoutManager(this,2);
        //B4
        RecyclerView rvProduct = (RecyclerView) findViewById(R.id.rvProduct);
        rvProduct.setLayoutManager(layoutManager);
        rvProduct.setAdapter(productAdapter);

    }

    private void initData(){
        productList.add(new Product("Zara 1", "Love Shift 1", "1100.000",R.drawable.ic_launcher_background ));
        productList.add(new Product("Zara 2", "Love Shift 2", "1100.000",R.drawable.ic_launcher_background ));
        productList.add(new Product("Zara 3", "Love Shift 3", "1100.000",R.drawable.ic_launcher_background ));
        productList.add(new Product("Zara 4", "Love Shift 4", "1100.000",R.drawable.ic_launcher_background ));
        productList.add(new Product("Zara 5", "Love Shift 5", "1100.000",R.drawable.ic_launcher_background ));
        productList.add(new Product("Zara 6", "Love Shift 6", "1100.000",R.drawable.ic_launcher_background ));
        productList.add(new Product("Zara 7", "Love Shift 7", "1100.000",R.drawable.ic_launcher_background ));
        productList.add(new Product("Zara 8", "Love Shift 8", "1100.000",R.drawable.ic_launcher_background ));
        productList.add(new Product("Zara 9", "Love Shift 9", "1100.000",R.drawable.ic_launcher_background ));
        productList.add(new Product("Zara 10", "Love Shift 10", "1100.000",R.drawable.ic_launcher_background ));
        productList.add(new Product("Zara 11", "Love Shift 11", "1100.000",R.drawable.ic_launcher_background ));
    }


    @Override
    public void onClickItem(int position) {
        Product product = productList.get(position);
        Toast.makeText(this,product.getTitle(), Toast.LENGTH_SHORT).show();
    }
}
