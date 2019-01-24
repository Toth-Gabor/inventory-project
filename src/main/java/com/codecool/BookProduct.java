package com.codecool;

public class BookProduct extends Product{

    private int numOfPages;

    public BookProduct(String name, int price, int numOfPages){
        this.name = name;
        this.price = price;
        this.numOfPages = numOfPages;
    }
    
    public int getNumOfPages() {
        return numOfPages;
    }
    
    public void setNumOfPages(int numOfPages) {
        this.numOfPages = numOfPages;
    }
}
