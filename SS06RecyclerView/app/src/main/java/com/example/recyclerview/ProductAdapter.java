package com.example.recyclerview;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter {
    private Activity activity;
    private List<Product> productList;
    private IOnClickItem iOnClickItem;

    public ProductAdapter(Activity activity, List<Product> productList, IOnClickItem iOnClickItem) {
        this.activity = activity;
        this.productList = productList;
        this.iOnClickItem = iOnClickItem;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = activity.getLayoutInflater();
        View v = inflater.inflate(R.layout.item_product, parent,false);
        ProductHolder holder = new ProductHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ProductHolder productHolder = (ProductHolder) holder;
        Product product = productList.get(position);
        productHolder.tvTitle.setText(product.getTitle());
        productHolder.tvDesc.setText(product.getDesc());
        productHolder.tvPrice.setText(product.getPrice());
        productHolder.ivCover.setImageResource(product.getImg());
        productHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iOnClickItem.onClickItem(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return productList.size();
    }
    public static class ProductHolder extends RecyclerView.ViewHolder{
        private ImageView ivCover;
        private TextView tvTitle;
        private TextView tvDesc;
        private TextView tvPrice;

        public ProductHolder(View itemView) {
            super(itemView);
            ivCover = (ImageView) itemView.findViewById(R.id.ivCover);
            tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
            tvDesc = (TextView) itemView.findViewById(R.id.tvDesc);
            tvPrice = (TextView) itemView.findViewById(R.id.tvPrice);
        }
    }

    public interface IOnClickItem{
        void onClickItem(int position);
    }
}
