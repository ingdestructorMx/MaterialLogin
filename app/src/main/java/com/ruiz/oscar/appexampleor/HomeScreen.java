package com.ruiz.oscar.appexampleor;


import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.mxn.soul.flowingdrawer_core.ElasticDrawer;
import com.mxn.soul.flowingdrawer_core.FlowingDrawer;
import com.ruiz.oscar.appexampleor.Adaptadores.Product;
import com.ruiz.oscar.appexampleor.Adaptadores.ProductAdapter;

import java.util.ArrayList;
import java.util.List;

import FlowingMenu.MenuListFragment;

public class HomeScreen extends AppCompatActivity {


//    Recycler

    private List<Product> prductlist = new ArrayList<>();
    private RecyclerView recyclerView;
    private ProductAdapter mAdapter;

    private Boolean MenuState = false;
//



    ImageView menu;
    FlowingDrawer mDrawer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        menu =  findViewById(R.id.btnmenu);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (MenuState == Boolean.TRUE){
                    mDrawer.closeMenu();
                    MenuState = Boolean.FALSE;
                }else{
                    mDrawer.openMenu();
                    MenuState = Boolean.TRUE;

                }

            }
        });


        mDrawer = (FlowingDrawer) findViewById(R.id.drawerlayout);
        mDrawer.setTouchMode(ElasticDrawer.TOUCH_MODE_BEZEL);
        mDrawer.setOnDrawerStateChangeListener(new ElasticDrawer.OnDrawerStateChangeListener() {
            @Override
            public void onDrawerStateChange(int oldState, int newState) {
                if (newState == ElasticDrawer.STATE_CLOSED) {
                    Log.i("MainActivity", "Drawer STATE_CLOSED");
                }
            }

            @Override
            public void onDrawerSlide(float openRatio, int offsetPixels) {
                Log.i("MainActivity", "openRatio=" + openRatio + " ,offsetPixels=" + offsetPixels);
            }
        });


//        Recycler

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mAdapter = new ProductAdapter(prductlist);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
//




        setupMenu();
        setuprecycler();


    }



    private void setupMenu() {
        FragmentManager fm = getSupportFragmentManager();
        MenuListFragment mMenuFragment = (MenuListFragment) fm.findFragmentById(R.id.id_container_menu);
        if (mMenuFragment == null) {
            mMenuFragment = new MenuListFragment();
            fm.beginTransaction().add(R.id.id_container_menu, mMenuFragment).commit();
        }
    }


    private void setuprecycler(){


        Product product = new Product("Pollo frito","Esta es una comida para 1 persona","$ 120",null);
        prductlist.add(product);

        Product product2 = new Product("Pollo frito2","Esta es una comida para 1 persona","$ 120",null);
        prductlist.add(product2);

        Product product3 = new Product("Pollo frito3","Esta es una comida para 1 persona","$ 120",null);
        prductlist.add(product3);


        mAdapter.notifyDataSetChanged();

    }



}
