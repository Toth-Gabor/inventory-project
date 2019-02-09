package com.codecool;

import java.awt.print.Book;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SeconderyStore extends Store {
    
    List<Product> allProduct = new ArrayList<>();
    
    @Override
    protected void saveToCsv(Product product) {
       
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("products.csv",true));
            if(product instanceof CDProduct){
                String[] productDetails = new String[]{product.getName(),String.valueOf(product.getPrice()),
                        String.valueOf(((CDProduct)product).getSize())};
                for (int i = 0; i < productDetails.length; i++) {
                    bw.append(productDetails[i]+",");
                }
                bw.append("CD" + "\n");
            } else {
                String[] productDetails = new String[]{product.getName(),String.valueOf(product.getPrice()),
                        String.valueOf(((BookProduct)product).getSize())};
                for (int i = 0; i < productDetails.length; i++) {
                    bw.append(productDetails[i]+",");
                }
                bw.append("Book" + "\n");
                
            }
            bw.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    
    @Override
    protected void saveToXml(Product product) {
    
    }
    
    @Override
    protected void storeProduct(Product product) {
        allProduct.add(product);
    }
    
    @Override
    protected List<Product> loadProduct() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("products.csv"));
            int lineCount = countLines("products.csv");
            String[][] productDetails = new String[lineCount][4];
            
            for (int i = 0; i < lineCount; i++) {
                productDetails[i] = br.readLine().split(",");
            }
            for (String[] row : productDetails) {
                if(row[3].equals("CD")){
                    allProduct.add(new CDProduct(row[0],Integer.valueOf(row[1]),Integer.valueOf(row[2])));
                } else {
                    allProduct.add(new BookProduct(row[0],Integer.valueOf(row[1]),Integer.valueOf(row[2])));
                }
            }
            return allProduct;
        
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public int countLines(String fileName){
        int count = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            while (br.ready()) {
                br.readLine();
                count++;
            }
    
        } catch (Exception e){
        e.printStackTrace();
        }
        return count;
    }
}
