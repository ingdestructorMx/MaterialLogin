package com.ruiz.oscar.appexampleor;

import com.ruiz.oscar.appexampleor.Adaptadores.Cart;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by prg on 6/20/18.
 */

public class ClassicSingleton {


    private static ClassicSingleton instance = null;
    public ArrayList<Cart> namecartlist = new ArrayList<Cart>(); // Member

    public ArrayList<Cart> getNamecartlist() {
        return namecartlist;
    }

    public void setNamecartlist(ArrayList<Cart> namecartlist) {
        this.namecartlist = namecartlist;
    }

    public ClassicSingleton() {
        // Exists only to defeat instantiation.
    }
    public static synchronized ClassicSingleton getInstance() {
        if(null == instance){
            instance = new ClassicSingleton();
        }
        return instance;
    }



}