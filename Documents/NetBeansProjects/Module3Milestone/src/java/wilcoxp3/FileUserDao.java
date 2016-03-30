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
public class FileUserDao implements DataAccessObject<User> {

    List<User> myUserList;
    
    public FileUserDao() {
        myUserList = readAll();
    }
    
    @Override
    public List<User> readAll() {
        myUserList = new ArrayList<>();

        try {
            myUserList.addAll(CollectionFileStorageUtility.load(User.class));
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error: could not load user list.");
        }
        return myUserList;
    }

    @Override
    public User read(Object id) {
        String username = (String) id;
        for (User u : myUserList) {
            if (username.equalsIgnoreCase(u.getUsername())) {
                return u;
            }
        }

        return null;
    }

    @Override
    public void create(User user) {
        for (User u : myUserList) {
            if (u.getUsername().equalsIgnoreCase(user.getUsername())) {
                System.out.println("User is already in database.");
                return;
            }
        }
        myUserList.add(user);
        try {
            CollectionFileStorageUtility.save(myUserList, User.class);
        } catch (IOException e) {
            System.out.println("Error: could not save user.");
        }
    }

    @Override
    public void update(User user) {
        for (User u : myUserList) {
            if (u.getUsername().equalsIgnoreCase(user.getUsername())) {
                u.setPassword(user.getPassword());
                u.setRoles(user.getRoles());
                try {
                    CollectionFileStorageUtility.save(myUserList, User.class);
                } catch (IOException e) {
                    System.out.println("Error: could not save user.");
                }
                return;
            } else {
                System.out.println("User not found.");
            }
        }
    }

    @Override
    public void delete(Object id) {
        String username = (String) id;
        for (User u : myUserList) {
            if (u.getUsername().equalsIgnoreCase(username)) {
                myUserList.remove(u);
                System.out.println("User successfully deleted.");
                try {
                    CollectionFileStorageUtility.save(myUserList, User.class);
                } catch (IOException e) {
                    System.out.println("Error: could not delete user.");
                }
                return;
            }
        }
        System.out.println("User not found.");
    }
    
}
