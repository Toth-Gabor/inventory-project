package com.codecool;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        StoreManager storeManager = new StoreManager();
        PersistentStore persistentStore = new PersistentStore();
        storeManager.addStorage(persistentStore);
        List<Product> productsList = persistentStore.loadProduct();
        for (Product product: productsList) {
            System.out.println(product.getName() + " " + product.getPrice() + " " + product.getSize() + " " + product.toString());
            if(product instanceof CDProduct){
                storeManager.addCDProduct(product.getName(), product.getPrice(), product.getSize());
            } else if(product instanceof BookProduct){
                storeManager.addBookProduct(product.getName(), product.getPrice(), product.getSize());
            }
            
        }
        //storeManager.addBookProduct("józsi az erdőben", 20, 300);
        //storeManager.addCDProduct("Kurva szar album", 100000, 5);
        
    
        //System.out.println(storeManager.listProduct());
        

    }

}
