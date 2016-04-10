/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wilcoxp3;

/**
 *
 * @author Paul
 */
public class DataAccessObjectFactory {

    DataAccessObjectFactory() {
    }

    public static DataAccessObject<User> getUserDao() {
        return new FileUserDao();
    }

    public static DataAccessObject<Product> getProductDao() {
        return new FileProductDao();
    }

}
