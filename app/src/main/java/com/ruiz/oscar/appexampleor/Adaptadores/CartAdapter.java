package com.ruiz.oscar.appexampleor.Adaptadores;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.ruiz.oscar.appexampleor.R;

import java.util.List;

/**
 * Created by prg on 6/20/18.
 */
public class CartAdapter extends RecyclerView.Adapter<CartAdapter.MyViewHolder> {

    private List<Cart> cartlist;


    Context ctx = null;
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, price;
        public ImageButton deletefromcart;

        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.tvnameitem);
            price = (TextView) view.findViewById(R.id.tvpriceitem);
//            addtocart = (ImageButton) view.findViewById(R.id.ibaddtocart);
        }
    }


    public CartAdapter(List<Cart> cartList) {
        this.cartlist = cartList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cartitem, parent, false);

        ctx = parent.getContext();

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        Cart cart = cartlist.get(position);
        holder.name.setText(cart.getName());
        holder.price.setText(cart.getPrice());



    }

    @Override
    public int getItemCount() {
        return cartlist.size();
    }
}