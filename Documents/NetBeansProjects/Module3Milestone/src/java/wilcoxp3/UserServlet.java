/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wilcoxp3;

import java.io.IOException;
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
public class UserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User u = new User();
        DataAccessObject<User> userDao = DataAccessObjectFactory.getUserDao();
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String admin = req.getParameter("isAdministrator");
        String invMan = req.getParameter("isInventoryManager");
        Set<String> roles = new HashSet<>();
        if (admin != null) {
            roles.add(User.ADMINISTRATOR);
        }
        if (invMan != null) {
            roles.add(User.INVENTORY_MANAGER);
        }

        switch (req.getParameter("button")) {
            case "Create":
                u.setUsername(username);
                u.setPassword(password);
                u.setRoles(roles);
                userDao.create(u);
                break;
            case "Edit":
                u.setUsername(username);
                u.setPassword(password);
                u.setRoles(roles);
                userDao.update(u);
                break;
            case "Delete":
                userDao.delete(username);
                break;
        }

        resp.sendRedirect("users.jsp");
    }
}
