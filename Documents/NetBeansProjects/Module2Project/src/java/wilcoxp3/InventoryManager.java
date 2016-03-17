package wilcoxp3;

/*
 * Paul Wilcox 
 * Module 1 Project 
 * This application allows the user to manage an
 * inventory of products. The user may add view a product's information, add a
 * new product to the inventory, update information for an existing product, or
 * delete a product from the inventory.
 */
import edu.lcc.citp.utility.CollectionFileStorageUtility;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * The InventoryManager class makes all changes to the product inventory. It
 * loads from and saves to a locally stored file the product inventory as a
 * List.
 *
 * @author wilcoxp3
 */
public class InventoryManager {

    List<Product> myProductList; // This pattern will cause problems with databases

    /**
     * Default constructor for InvetoryManager loads the list of products.
     */
    public InventoryManager() {
        myProductList = getProductList();
    }

    /**
     * This method loads the product list from a file, and returns the list.
     *
     * @return myProductList
     */
    public final List<Product> getProductList() {

        myProductList = new ArrayList<>();

        try {
            myProductList.addAll(CollectionFileStorageUtility.load(Product.class));
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error: could not load product list.");
        }
        return myProductList;
    }

    /**
     * This method gets a product from the product list with a UPC which matches
     * what the user has entered. If no UPC is found, returns null.
     *
     * @param upc
     * @return Product p
     */
    public Product getProduct(String upc) {

        for (Product p : myProductList) {
            if (upc.equalsIgnoreCase(p.getUpc())) {
                return p;
            }
        }

        return null;
    }

    /**
     * This method adds a product to the list as specified by the user and saves
     * the new list. It displays an error message if a product with the same UPC
     * is already in the list.
     *
     * @param p
     */
    public void addProduct(Product p) {

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

    /**
     * This method updates the fields for an existing product as specified by
     * the user, and saves the updated product list. If no product with a
     * matching UPC is found, displays an error message.
     *
     * @param p
     */
    public void updateProduct(Product p) {

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

    /**
     * This method deletes a product from the product list as specified by the
     * user and saves the updated list. If no product with a matching UPC is
     * found, displays an error message.
     *
     * @param upc
     */
    public void removeProduct(String upc) {

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
