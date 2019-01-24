package com.codecool;

public class Main {


    public static void main(String[] args) {

        StoreManager storeManager = new StoreManager();
        PersistentStore persistentStore = new PersistentStore();
        storeManager.addStorage(persistentStore);
        storeManager.addBookProduct("józsi az erdőben", 20, 300);
        storeManager.addCDProduct("Kurva szar album", 100000, 5);
        
    
        System.out.println(storeManager.listProduct());
        

    }

}
