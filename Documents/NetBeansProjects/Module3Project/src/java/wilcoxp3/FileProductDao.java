/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wilcoxp3;

import edu.lcc.citp.utility.CollectionFileStorageUtility;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Paul
 */
public class FileProductDao implements DataAccessObject<Product> {

    List<Product> myProductList;
    
    public FileProductDao() {
        myProductList = readAll();
    }
    
    @Override
    public List<Product> readAll() {
        myProductList = new ArrayList<>();

        try {
            myProductList.addAll(CollectionFileStorageUtility.load(Product.class));
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error: could not load product list.");
        }
        return myProductList;
    }

    @Override
    public Product read(Object id) {
        String upc = (String) id;
        for (Product p : myProductList) {
            if (upc.equalsIgnoreCase(p.getUpc())) {
                return p;
            }
        }

        return null;
    }

    @Override
    public void create(Product p) {
        for (Product product : myProductList) {
            if (product.compareTo(p) == 0) {
                System.out.println("Product is already in database.");
                return;
            }
        }
        myProductList.add(p);
        try {
            CollectionFileStorageUtility.save(myProductList, Product.class);
        } catch (IOException e) {
            System.out.println("Error: could not save product.");
        }
    }

    @Override
    public void update(Product p) {
        for (Product product : myProductList) {
            if (product.compareTo(p) == 0) {
                product.setShortDetails(p.getShortDetails());
                product.setLongDetails(p.getLongDetails());
                product.setPrice(p.getPrice());
                product.setStock(p.getStock());
                try {
                    CollectionFileStorageUtility.save(myProductList, Product.class);
                } catch (IOException e) {
                    System.out.println("Error: could not save product.");
                }
                return;
            } else {
                System.out.println("Product not found.");
            }
        }
    }

    @Override
    public void delete(Object id) {
        
        String upc = (String) id;
        for (Product p : myProductList) {
            if (p.getUpc().equalsIgnoreCase(upc)) {
                myProductList.remove(p);
                System.out.println("Product successfully deleted.");
                try {
                    CollectionFileStorageUtility.save(myProductList, Product.class);
                } catch (IOException e) {
                    System.out.println("Error: could not delete product.");
                }
                return;
            }
        }
        System.out.println("Product not found.");
    }
    
}
