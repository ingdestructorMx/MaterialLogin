package com.ruiz.oscar.appexampleor.Adaptadores;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ruiz.oscar.appexampleor.CartActivity;
import com.ruiz.oscar.appexampleor.ClassicSingleton;
import com.ruiz.oscar.appexampleor.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by prg on 6/19/18.
 */

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.MyViewHolder> {

    private List<Product> moviesList;



    Context ctx = null;
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, description, price;
        public ImageButton addtocart;

        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.tvname);
            description = (TextView) view.findViewById(R.id.tvdescripcion);
            price = (TextView) view.findViewById(R.id.tvprecio);
            addtocart = (ImageButton) view.findViewById(R.id.ibaddtocart);
        }
    }


    public ProductAdapter(List<Product> moviesList) {
        this.moviesList = moviesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_childpager, parent, false);

        ctx = parent.getContext();

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        final Product movie = moviesList.get(position);
        holder.name.setText(movie.getName());
        holder.description.setText(movie.getDescription());
        holder.price.setText(movie.getPrice());


        holder.addtocart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(ctx,"Added to Cart" + position,Toast.LENGTH_SHORT).show();



                ClassicSingleton global = new ClassicSingleton();

                global.getInstance().namecartlist.add(new Cart(holder.name.getText().toString(),holder.price.getText().toString()));
            }
        });

    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }
}