package com.codecool;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class PersistentStore extends Store{
    
    private File file = new File("src/main/java/data/products.xml");
    protected List<Product> allProduct = new ArrayList<>();// ez így nem jó

    @Override
    protected void saveToXml(Product product){
        DocumentBuilderFactory bFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        try {
            builder = bFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

        //xml cucc ide!!!
    }
    
    @Override
    protected void storeProduct(Product product){
        allProduct.add(product);
    }
    
    @Override
    protected List<Product> loadProduct() {
        try {
            
            
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.parse(file);
            document.getDocumentElement().normalize();
            NodeList nodeList = document.getElementsByTagName("Product");
    
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node childNode = nodeList.item(i);
                if (childNode.getNodeType() == childNode.ELEMENT_NODE){
                    Element element = (Element) childNode;
    
                    allProduct.add(createProduct(element.getAttribute("type"),
                            element.getAttribute("name"),
                            Integer.parseInt(element.getAttribute("price")),
                            Integer.parseInt(element.getAttribute("size"))));
                }
            }
            return allProduct;
    
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;

    }

}
