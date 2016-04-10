/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wilcoxp3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Paul
 */
public class DatabaseProductDao implements DataAccessObject<Product> {
    
    private boolean exists;
    Connection con;

    DatabaseProductDao() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseProductDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/store;create=true");
            exists = con.getMetaData().getTables(null, null, "PRODUCT", null).next();
            if (!exists) {
                String createDml = "CREATE TABLE PRODUCT (UPC VARCHAR(25), "
                        + "SHORT_DETAILS VARCHAR(50), LONG_DETAILS VARCHAR(5000), "
                        + "PRICE DECIMAL(10,2), STOCK INTEGER, PRIMARY KEY (UPC))";
                PreparedStatement createStatement = con.prepareStatement(createDml);
                createStatement.execute();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseProductDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public List<Product> readAll() {
        List<Product> products = new ArrayList<>();
        try {
            PreparedStatement readAllStatement = con.prepareStatement("SELECT UPC, "
                    + "SHORT_DETAILS, LONG_DETAILS, PRICE, STOCK FROM PRODUCT");
            ResultSet results = readAllStatement.executeQuery();
            while (results.next()) {
                Product product = new Product();
                product.setUpc(results.getString("UPC"));
                product.setShortDetails(results.getString("SHORT_DETAILS"));
                product.setLongDetails(results.getString("LONG_DETAILS"));
                product.setPrice(results.getBigDecimal("PRICE"));
                product.setStock(results.getInt("STOCK"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseProductDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return products;
    }

    @Override
    public Product read(Object id) {
        Product product = null;
        String upc = (String) id;
        try {
            PreparedStatement readStatement = con.prepareStatement("SELECT UPC, "
                    + "SHORT_DETAILS, LONG_DETAILS, PRICE, STOCK FROM PRODUCT "
                    + "WHERE UPC = ?");
            readStatement.setString(1, upc);
            ResultSet results = readStatement.executeQuery();
            if (results.next()) {
                product = new Product();
                product.setUpc(results.getString("UPC"));
                product.setShortDetails(results.getString("SHORT_DETAILS"));
                product.setLongDetails(results.getString("LONG_DETAILS"));
                product.setPrice(results.getBigDecimal("PRICE"));
                product.setStock(results.getInt("STOCK"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseProductDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return product;
    }

    @Override
    public void create(Product product) {
        if (product != null && read(product.getUpc()) == null) {
            try {
                PreparedStatement createStatement = con.prepareStatement(
                        "INSERT INTO PRODUCT (UPC, SHORT_DETAILS, LONG_DETAILS, "
                                + "PRICE, STOCK) VALUES (?,?,?,?,?)");
                
            } catch (SQLException ex) {
                Logger.getLogger(DatabaseProductDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void update(Product entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
