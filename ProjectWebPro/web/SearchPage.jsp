<%-- 
    Document   : SearchPage
    Created on : Oct 23, 2018, 8:57:36 PM
    Author     : James
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" ></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" ></script>
        <style>
            .wrapperSearch{
                display: grid;
                grid-template-columns: 40% 30% 30%;
                justify-items:center;
            }
            
        </style>
    </head>
    <body>
        <jsp:include page = "include/Header.jsp"/>
        <div class="wrapperSearch">
        <h1>Store Search</h1>
        

        </div>  
    </body>
</html>
