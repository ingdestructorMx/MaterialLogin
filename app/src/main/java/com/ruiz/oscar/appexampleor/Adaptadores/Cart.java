package com.ruiz.oscar.appexampleor.Adaptadores;

/**
 * Created by prg on 6/20/18.
 */

public class Cart {

    private String name , price ;
    private int image ;

    public Cart(String name, String price) {
        this.name = name;
        this.price = price;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
