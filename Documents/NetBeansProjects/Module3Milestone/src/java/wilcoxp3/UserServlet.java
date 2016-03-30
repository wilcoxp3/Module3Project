/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wilcoxp3;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Paul
 */
@WebServlet("/users")
public class UserServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User u = new User();
        DataAccessObject<User> userDao = DataAccessObjectFactory.getUserDao();
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Set<String> roles = new HashSet<>();




        switch (req.getParameter("button")) {
            case "Create":
                p.setUpc(upc);
                p.setShortDetails(shortDetails);
                p.setLongDetails(longDetails);
                p.setPrice(price);
                p.setStock(stock);
                productDao.create(p);
                break;
            case "Edit":
                p.setUpc(upc);
                p.setShortDetails(shortDetails);
                p.setLongDetails(longDetails);
                p.setPrice(price);
                p.setStock(stock);
                productDao.update(p);
                break;
            case "Delete":
                productDao.delete(upc);
                break;
        }

        resp.sendRedirect("inventory.jsp");
    }
}
