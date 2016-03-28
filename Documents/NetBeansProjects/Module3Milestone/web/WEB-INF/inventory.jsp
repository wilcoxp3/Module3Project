<%-- 
    Document   : inventory
    Created on : Mar 12, 2016, 9:54:41 PM
    Author     : Paul
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inventory Manager</title>
        <jsp:useBean id="inventoryManager" scope="application" class="wilcoxp3.InventoryManager"/>
    </head>
    <body>
        <h1>Inventory Manager</h1>
        <h2>View, edit, and delete inventory below.</h2>
        <p>A price or stock of -999 indicates invalid input.</p>
        <c:forEach var="p" items="${inventoryManager.productList}">
            <div>
                <form action="inventory" method="POST">
                    <label>
                        <span>UPC</span>
                        <input type="text" name="upc" value="${p.getUpc()}" readonly="readonly"/>
                    </label>
                    <label>
                        <span>Short Details</span>
                        <input type="text" name="shortDetails" value="${p.getShortDetails()}" />
                    </label>
                    <label>
                        <span>Long Details</span>
                        <input type="text" name="longDetails" value="${p.getLongDetails()}" />
                    </label>
                    <label>
                        <span>Price</span>
                        <input type="text" name="price" value="${p.getPrice()}" />
                    </label>
                    <label>
                        <span>Stock</span>
                        <input type="text" name="stock" value="${p.getStock()}" />
                    </label>
                    <input type="submit" name="button" value="Edit" />
                    <input type="submit" name="button" value="Delete" />
                </form>
            </div>
        </c:forEach>
        <div>
            <h2>Create new inventory item below.</h2>
        </div>
        <div>
            <form action="inventory" method="post">
                <div>
                    <label for="upc">UPC</label>
                    <input type="text" id="upc" name="upc" />
                </div>
                <div>
                    <label for="shortDetails">Short Details</label>
                    <input type="text" id="shortDetails" name="shortDetails" />
                </div>
                <div>
                    <label for="longDetails">Long Details</label>
                    <input type="text" id="longDetails" name="longDetails" />
                </div>
                <div>
                    <label for="price">Price</label>
                    <input type="text" id="price" name="price" />
                </div>
                <div>
                    <label for="stock">Stock</label>
                    <input type="text" id="stock" name="stock" />
                </div>
                <div>
                    <input type="submit" value="Create" name="button" />
                </div>
            </form>
        </div>
    </body>
</html>
