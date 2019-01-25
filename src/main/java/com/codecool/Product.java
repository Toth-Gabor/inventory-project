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
    
    public abstract int getSize();

}

