package com.codecool;

import java.util.List;

public interface StorageCapable {

    public List<Product> getAllProduct();
    public void storeCDProduct(String name, int price, int numOfTracks);
    public void storeBookProduct(String name, int price, int numOfPages);

}
