package com.ruiz.oscar.appexampleor.Adaptadores;

/**
 * Created by prg on 6/19/18.
 */

public class Product {
    private String name, description, price;
    private Integer image;

    public Product() {
    }

    public Product(String name, String description, String price , Integer image) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }
}