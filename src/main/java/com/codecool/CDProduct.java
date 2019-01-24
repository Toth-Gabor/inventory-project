package com.codecool;

public class CDProduct extends Product{

    private int numOfTracks;

    public CDProduct(String name, int price, int numOfTracks){
        this.name = name;
        this.price = price;
        this.numOfTracks = numOfTracks;
    }
    
    public void setNumOfTracks(int numOfTracks) {
        this.numOfTracks = numOfTracks;
    }
    
    public int getNumOfTracks(){
        return this.numOfTracks;
    }
}
