<%-- 
    Document   : product
    Created on : Oct 28, 2018, 9:07:49 PM
    Author     : James
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product Page</title>
        <style>
            .Wrapper{
                display:grid;
                grid-template-columns: 25% 25% 25% 25%;
                grid-gap: 1em;
                padding: 5em;
            }
            .product{
                
                
            }
        </style>
    </head>
    <body>
        <jsp:include page = "include/Header.jsp"/>
        <div class="Wrapper">
            <c:forEach items="${products}" var="p">
                    
                <div class="productimage">
                <img src="Pic/${p.productcode}.jpeg" width="70%"><br>
                </div>
                <div class="product">
                    <p>${p.productname}</p> <br>
                    <p>${p.productprice}</p><br>
                    <form action="addItemstoCart" method="post">
                        <input type="submit" value="Add To cart"/>
                    </form>
                </div>
            </c:forEach>

        </div>

    </body>
</html>
