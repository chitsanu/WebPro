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
                grid-template-columns: 20% 60% 20%;

                grid-gap: 1em;
                margin-left: 1em;
                margin-right: 1em;
                margin-bottom: 1em;

            }
            h1{
                padding :1em;
                text-align: center;
            }
            .show{
                display:grid;
                grid-template-columns: 25% 25% 25% 25%;

                padding: 1em;
            }
            .productbd{
                display:grid;

                padding : 1em;
            }
            .product{
                display:grid ;
                padding: 2em; 
              
                justify-content: flex-start;
                align-content: center;
            }
            .productimage{
                display:grid ;
                
                align-self: center;
                align-content: center;
            }
            .button{
                padding: 1em;
                display: grid;
                align-content: center;
            }
        </style>
    </head>
    <body>
        <jsp:include page = "include/Header.jsp"/>

        <h1>Product Page</h1>
        <div class="Wrapper">
            <div>

            </div>
            <div class="show">
                <c:forEach items="${products}" var="p">
                    <div class="productbd">
                        <div class="showProduct">

                            <div class="productimage">

                                <img src="Pic/${p.productcode}.jpeg" width="70%"><br>

                            </div>

                            <div class="product">

                                <p>${p.productname}</p> <br>
                                <p>Price: ${p.productprice} Baht</p><br>


                            </div>
                            <div class="button">
                                <a href="AddItems?productCode=${p.productcode}">
                                    <input type="button" class="btn btn-outline-success" value="Add to cart"/>
                                </a>
                            </div>
                        </div>   
                    </div>
                </c:forEach>
            </div>
            <div>

            </div>
        </div>

    </body>
</html>
