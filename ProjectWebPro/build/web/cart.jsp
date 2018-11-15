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
            .Wrapper{
                display:grid;
                grid-template-columns: 50% 50% ;
                grid-gap: 1em;
                margin-left: 1em;
                margin-right: 1em;
                margin-bottom: 1em;

            }
            h1{
                padding :1em;
                text-align: center;
            }
            .showProduct{
                display:grid;
                grid-gap: 1em;
                grid-template-columns: 50%;
                border-style : solid;
                border-radius: 5px;
                border-color: #A8DBA8;  
            }
            .product{
                display:grid ;
                padding-top: 2em; 
                justify-content: flex-start;
                align-content: center;
            }
            .productimage{
                display:grid ;
                align-content: center;
            }
            #total{
                
            }
        </style>
    </head>
    <body> 
        <jsp:include page = "include/Header.jsp"/>
        <h1>Your Cart</h1>

        <div class="Wrapper">
            <c:set var="items" value="${sessionScope.cart.itemsInCart}"/>
            <c:forEach items="${cart.itemsInCart}" var="i">
                <div class="showProduct">

                    <div class="product">

                        <p>${i.product.productcode}</p> <br>
                        <p>${i.product.productname}</p> <br>
                        
                        <p>Quantity : ${i.quantity}</p><br>
                        <p>${i.totalPrice} Baht</p>
                         <a href="RemoveItems?productCode=${i.product.productcode}">
                            <input type="button" class="btn btn-outline-danger" value="Remove"/>
                        </a>

                    </div>

                </div>   
            </c:forEach>
            <div id="total">
            Total Quantity : ${cart.totalQuantity}<br>
            Total Price ${cart.totalPrice} Baht<br>
            <a href="#">
            <input type="button"class="btn btn-outline-success" value= "Check Out"/>
            </a>
            </div>
        </div>
    </body>
</html>
