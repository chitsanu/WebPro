<%-- 
    Document   : Cart
    Created on : Nov 13, 2018, 10:19:28 PM
    Author     : James
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cart</title>
        <style>

        </style>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
    </head>
    <body> 
        <jsp:include page = "include/Header.jsp"/>



        <table class="table table-hover">   


            <thead>
                <tr>
                    <th>Product Code</th>
                    <th>Product Name</th>
                    <th>Quantity</th>
                    <th>Price(Baht)</th>

                </tr>
            </thead>
            <c:set var="items" value="${sessionScope.cart.itemsInCart}"/>
            <c:forEach items="${cart.itemsInCart}" var="i">
                <tbody>
                    <tr>
                        <td>${i.product.productcode}</td>
                        <td>${i.product.productname}</td>
                        <td>${i.quantity}</td>
                        <td>${i.totalPrice}</td>

                    </tr>
                    <tr>
                        <td>
                            <a href="AddItemFromCart?productCode=${i.product.productcode}">
                                <input type="button" class="btn btn-outline-success" style='color:#217a43' value="Add to cart"/>
                            </a>
                            <a href="RemoveItems?productCode=${i.product.productcode}">
                                <input type="button" class="btn btn-outline-danger" style="color: brown" value="Remove"/>
                            </a> 
                        </td>
                    </tr>
                </tbody>




            </c:forEach>
        </table>
        Total Quantity : ${cart.totalQuantity}<br>
        Total Price ${cart.totalPrice} Baht<br>
        <a href="Checkout">
            <button onclick="noti()"type="button" class="btn btn-primary">Check Out</button>
        </a>
        <script>
            function noti() {
                alert("Check out Complete");
            }
        </script>
    </div>
</div>
</body>
</html>
