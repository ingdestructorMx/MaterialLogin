package com.ruiz.oscar.appexampleor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ruiz.oscar.appexampleor.Adaptadores.Cart;
import com.ruiz.oscar.appexampleor.Adaptadores.CartAdapter;
import com.ruiz.oscar.appexampleor.Adaptadores.Product;
import com.ruiz.oscar.appexampleor.Adaptadores.ProductAdapter;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Boolean.TRUE;

public class CartActivity extends AppCompatActivity {

    //    Recycler
    public List<Cart> cartList = new ArrayList<>();
    private RecyclerView recyclerView;
    private CartAdapter mAdapter;
//


    private ImageView btnmenu , btncart;
    private TextView txttoolbar;

    ClassicSingleton global = new ClassicSingleton();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        txttoolbar = (TextView) findViewById(R.id.tvtoolbartitle);
        btnmenu = (ImageView) findViewById(R.id.btnmenu);
        btncart = (ImageView) findViewById(R.id.btncart);

        btnmenu.setVisibility(View.INVISIBLE);
        btncart.setVisibility(View.INVISIBLE);
        txttoolbar.setText("Cart");




        //        Recycler

        recyclerView = (RecyclerView) findViewById(R.id.recycler_viewcart);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        //


        setuprecycler();
    }


    private void setuprecycler(){



        Log.e("Arrayglobal",global.getInstance().namecartlist.get(0).getName());


        if (global.getInstance().namecartlist.isEmpty() == TRUE){

            Cart cart = new Cart("Oscar", "123");
            cartList.add(cart);
            mAdapter = new CartAdapter(cartList);
            recyclerView.setAdapter(mAdapter);
            mAdapter.notifyDataSetChanged();
        }else {
            mAdapter = new CartAdapter(global.getInstance().namecartlist);
            recyclerView.setAdapter(mAdapter);
            mAdapter.notifyDataSetChanged();
        }


    }
}
