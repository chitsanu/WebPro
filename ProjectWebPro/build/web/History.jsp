<%-- 
    Document   : History
    Created on : Nov 27, 2018, 12:35:35 PM
    Author     : SSirith
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>History Page</title
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
            <th>Order Number</th>
            <th>Product Name</th>
            <th>Quantity</th>
            <th>Order Date</th>

            <c:forEach items="${Orderlist}" var="ol">
                <tr>
                    <td>${ol.ordernumber}</td>
                    <c:forEach items="${ol.orderdetailList}" var="dol">
                        <td>${dol.productcode.productname}</td>
                        <td>${dol.quantity}</td>
                    </c:forEach>
                    <td>${ol.orderdate}</td>
                </tr>

            </c:forEach>
        </table>
    </body>
</html>
