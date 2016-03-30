package wilcoxp3;

/*
 * Paul Wilcox 
 * Module 2 Project 
 * This application allows the user to manage an
 * inventory of products. The user may add view a product's information, add a
 * new product to the inventory, update information for an existing product, or
 * delete a product from the inventory.
 */
import java.io.IOException;
import java.math.BigDecimal;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * InventoryServlet overrides doGet and doPost in order to add and save new
 * products to the product inventory, and to display a list of all saved
 * products.
 *
 * @author wilcoxp3
 */
@WebServlet("/inventory")
public class InventoryServlet extends HttpServlet {

    /**
     * This method displays the list of all saved products in the inventory.
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.getWriter().println("<!DOCTYPE html><html><head></head><body>");
        InventoryManager invMan = new InventoryManager();
        for (Product p : invMan.getProductList()) {
            resp.getWriter().println(p.toString());
        }
        resp.getWriter().println("</body></html>");
    }

    /**
     * This method adds a new product, edits an existing product, or deletes a
     * product from the inventory with the data taken from inventory.jsp. It
     * then calls the doGet method in order to display the saved products upon
     * form submittal.
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Product p = new Product();
        DataAccessObject<Product> productDao = DataAccessObjectFactory.getProductDao();
        String upc = req.getParameter("upc");
        String shortDetails = req.getParameter("shortDetails");
        String longDetails = req.getParameter("longDetails");
        String priceInput = req.getParameter("price");
        String stockInput = req.getParameter("stock");

        try {
            BigDecimal price = new BigDecimal(priceInput);
        } catch (NumberFormatException e) {
            priceInput = "-999";
        }
        try {
            Integer stock = new Integer(stockInput);
        } catch (NumberFormatException e) {
            stockInput = "-999";
        }

        BigDecimal price = new BigDecimal(priceInput);
        Integer stock = new Integer(stockInput);

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
