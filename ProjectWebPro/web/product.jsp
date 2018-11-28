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
                grid-template-columns: 10% 80% 10%;
                
               
               

            }
           
            .show{
               
                display:grid;
                grid-template-columns:  30% 30% 30%;
               justify-content: center;
                padding: 1em;
            }
            
            .product{
                display:grid ;
                padding: 2em; 
                
                justify-content: center;
                align-content: center;
            }
            .showProduct{
                 display:grid ;
                 grid-template-columns: 70% 30%;
                 padding: 1em;
                 margin: 2em;
                box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
                 justify-content: center;
                
            }
            .productimage{
                display:grid ;
                
                 justify-content: center;
                align-content: center;
            }
            .button{
                padding: 1em;
                display: grid;
                align-content: end;
                justify-content: center;
            }
           
        </style>
    </head>
    <body>
        <jsp:include page = "include/Header.jsp"/>

        
        <div class="Wrapper">
            <div>
               
            </div>
            <div class="show">
                <c:forEach items="${products}" var="p">
                    
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
                                    <input type="button" class="btn btn-outline-success" style="color:#217a43" value="Add to cart"/>
                                </a>
                            </div>
                        </div>   
                    
                </c:forEach>
            </div>
            <div>

            </div>
        </div>

    </body>
</html>
