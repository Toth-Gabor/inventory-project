package com.codecool;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PersistentStore extends Store{
    
    private File xmlFile = new File("src/main/java/data/productsSample.xml");
    protected List<Product> allProduct = new ArrayList<>();
    
    @Override
    protected void saveToCsv(Product product) {
    
    }
    
    @Override
    protected void saveToXml(Product product){
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        
            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("Products");
            doc.appendChild(rootElement);
        
            Element productTag = doc.createElement("Product");
            rootElement.appendChild(productTag);
        
            productTag.setAttribute("name", product.getName());
            productTag.setAttribute("price", Integer.toString(product.getPrice()));
            productTag.setAttribute("size", Integer.toString(product.getSize()));
            productTag.setAttribute("type", product.toString());
        
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(xmlFile);
        
            transformer.transform(source, result);
        
            System.out.println("File saved!");
        
        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }
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
            Document document = db.parse(xmlFile);
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
