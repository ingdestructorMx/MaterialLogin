package com.ruiz.oscar.appexampleor.Adaptadores;

import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ruiz.oscar.appexampleor.R;

import java.util.List;

/**
 * Created by prg on 6/19/18.
 */

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.MyViewHolder> {

    private List<Product> moviesList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, description, price;

        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.tvname);
            description = (TextView) view.findViewById(R.id.tvdescripcion);
            price = (TextView) view.findViewById(R.id.tvprecio);
        }
    }


    public ProductAdapter(List<Product> moviesList) {
        this.moviesList = moviesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_childpager, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Product movie = moviesList.get(position);
        holder.name.setText(movie.getName());
        holder.description.setText(movie.getDescription());
        holder.price.setText(movie.getPrice());
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }
}