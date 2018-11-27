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
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <table>
            <th>#</th>
            <th>Order Number</th>
            <th>Order Date</th>
            
            <c:forEach items="${sessionScope.account.orderlistList}" var="ol" varStatus="vs">
                <tr>
                    <td>${vs.count}</td>
                    <td>${ol.ordernumber}</td>
                    <td>${ol.orderdate}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
