package wilcoxp3;

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
     * This method adds a new product to the inventory with the data taken from
     * inventory.jsp. It then calls the doGet method in order to
     * display the saved products upon form submittal.
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Product p = new Product();
        InventoryManager invMan = new InventoryManager();
        String upc = req.getParameter("upc");
        String shortDetails = req.getParameter("shortDetails");
        String longDetails = req.getParameter("longDetails");
        BigDecimal price = new BigDecimal(req.getParameter("price"));
        Integer stock = new Integer(req.getParameter("stock"));
        
        switch (req.getParameter("button")) {
            case "Create":
                p.setUpc(upc);
                p.setShortDetails(shortDetails);
                p.setLongDetails(longDetails);
                p.setPrice(price);
                p.setStock(stock);
                invMan.addProduct(p);
                break;
            case "Edit":
                p.setUpc(upc);
                p.setShortDetails(shortDetails);
                p.setLongDetails(longDetails);
                p.setPrice(price);
                p.setStock(stock);
                invMan.updateProduct(p);
                break;
            case "Delete":
                invMan.removeProduct(upc);
                break;
        }

        resp.sendRedirect("inventory.jsp");
    }
}
