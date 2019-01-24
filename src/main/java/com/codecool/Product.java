package com.codecool;

public abstract class Product {

    String name;
    int price;

    public String getName(){
        return this.name;
    }

    public int getPrice(){
        return this.price;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setPrice(int price) {
        this.price = price;
    }
}

