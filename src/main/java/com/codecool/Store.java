package com.codecool;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public abstract class Store implements StorageCapable{
    
    List<CDProduct> CDList = new ArrayList<>();
    List<BookProduct> bookList = new ArrayList<>();

    protected abstract void saveToXml(Product product);
    protected abstract void storeProduct(Product product);
    protected abstract List<Product> loadProduct();

    protected Product createProduct(String type, String name, int price, int size){

        if (type.equals("CD")){
            return new CDProduct(name, price, size);
        } else if (type.equals("Book")){
            return new BookProduct(name, price, size);
        } else {
            System.out.println("This type is not exist!");
        }
        return null;
    }

    


    public void store(Product product){
        saveToXml(product);
        storeProduct(product);
    }
    
    @Override
    public List<Product> getAllProduct(){
        List<Product> listAll = new ArrayList<>();
        listAll.addAll(bookList);
        listAll.addAll(CDList);
        return listAll;
    }
    
    @Override
    public void storeCDProduct(String name, int price, int numOfTracks){
        CDList.add(new CDProduct(name, price, numOfTracks));
    }
    
    @Override
    public void storeBookProduct(String name, int price, int numOfPages){
        bookList.add(new BookProduct(name, price, numOfPages));

    }



}
