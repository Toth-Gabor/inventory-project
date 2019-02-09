package com.codecool;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        StoreManager storeManager = new StoreManager();
        PersistentStore persistentStore = new PersistentStore();
        storeManager.addStorage(persistentStore);
        //List<Product> productsList = persistentStore.loadProduct();
//        for (Product product: productsList) {
//            System.out.println(product.getName() + " " + product.getPrice() + " " + product.getSize() + " " + product.toString());
//            if(product instanceof CDProduct){
//                storeManager.addCDProduct(product.getName(), product.getPrice(), product.getSize());
//            } else if(product instanceof BookProduct){
//                storeManager.addBookProduct(product.getName(), product.getPrice(), product.getSize());
//            }
//
//        }
        
        SeconderyStore ss = new SeconderyStore();
        storeManager.addStorage(ss);
        storeManager.addBookProduct("józsi az erdőben", 20, 300);
        storeManager.addCDProduct("Kurva szar album", 100000, 5);
        Product cd = new CDProduct("Kurva szar album", 1000, 7);
        Product book = new BookProduct("Józsi befosott", 10000, 1);
        /*ss.saveToCsv(cd);
        ss.saveToCsv(book);*/
        List<Product> products = ss.loadProduct();
        for (Product product : products) {
            System.out.println(product);
        }
        
        //persistentStore.saveToXml(persistentStore.allProduct.get(0));
        
    
        /*List<Product> allCucc = persistentStore.getAllProduct();
        System.out.println(allCucc.get(0).getName());
        persistentStore.saveToXml(allCucc.get(0));*/
        

    }

}
