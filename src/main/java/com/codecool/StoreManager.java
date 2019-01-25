package com.codecool;

public class StoreManager {

    private StorageCapable storageCapable;

    public StoreManager(){
    }

    public void addStorage(StorageCapable storageCapable){
        this.storageCapable = storageCapable;
    }

    public void addCDProduct(String name, int price, int tracks){
        storageCapable.storeCDProduct(name, price, tracks);
    }

    public void addBookProduct(String name, int price, int pages){
        storageCapable.storeBookProduct(name, price, pages);
    }

    public String listProduct(){
        String allProduct = "";
        for (Product name: storageCapable.getAllProduct()) {
            allProduct += name.getName() + "\n";
        }
        return allProduct;
    }

    public int getTotalProductPrice(){
        int totalProductPrice = 0;
        for (Product product : storageCapable.getAllProduct()) {
            totalProductPrice += product.getPrice();
        }
        return totalProductPrice;
    }
}
