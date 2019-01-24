package com.codecool;

import java.io.InputStream;
import java.net.URL;
import java.util.*;

public abstract class Store implements StorageCapable{

    List<Product> listAll = new ArrayList<>();
    List<CDProduct> CDList = new ArrayList<>();
    List<BookProduct> bookList = new ArrayList<>();

    protected abstract void saveToxml(Product product);
    protected abstract void storeProduct(Product product);

    protected Product createProduct(String type, String name, int price, int size){

        if (type.equals("CDProduct")){
            return new CDProduct(name, price, size);
        } else if (type.equals("BookProduct")){
            return new BookProduct(name, price, size);
        } else {
            System.out.println("This type is not exist!");
        }
        return null;
    }

    public List<Product> loadProduct(){
        //read from xml to list
        // file path --> src/main/java/data/products.xml
        InputStream is = new Inpu
        return null;
    }


    public void store(Product product){
        saveToxml(product);
        storeProduct(product);

    }

    public List<Product> getAllProduct(){
        listAll.addAll(bookList);
        listAll.addAll(CDList);
        return listAll;
    }

    public void storeCDProduct(String name, int price, int numOfTracks){
        CDList.add(new CDProduct(name, price, numOfTracks));
    }

    public void storeBookProduct(String name, int price, int numOfPages){
        bookList.add(new BookProduct(name, price, numOfPages));

    }



}
