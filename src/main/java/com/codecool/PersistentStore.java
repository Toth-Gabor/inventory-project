package com.codecool;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.ArrayList;
import java.util.List;

public class PersistentStore extends Store{

    private List<Product> listAll = new ArrayList<>();  // ez így nem jó

//    @Override
    protected void saveToxml(Product product){
//        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
//        DocumentBuilder builder = null;
//        try {
//            builder = builderFactory.newDocumentBuilder();
//        } catch (ParserConfigurationException e) {
//            e.printStackTrace();
//        }
//
//        //xml cucc ide!!!
    }

    public void storeProduct(Product product){
        listAll.add(product); // ez így nem jó

    }

}
