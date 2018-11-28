<%-- 
    Document   : HomePage
    Created on : Oct 23, 2018, 6:16:41 PM
    Author     : James
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Exotic Animal Food</title>
    </head>
    <style>
        .wrapper{
            display: grid;
        }
        .topic{
            display: grid;
            justify-content: center;
        }
        .image{
            display:Grid;

            justify-items: stertch;


        }
        .img1{
            max-width: 100%;
            height: auto;
        }
        .img2{
            max-width: 100%;
            height: auto;

        }
        .img2{
            max-width: 100%;
            height: auto;

        }

    </style>
    <body>
        <jsp:include page = "include/Header.jsp"/>


        <div class="image">
            <div class="img1">
                <img src="Pic/img1.png" class="img-thumbnail " >
            </div>
            <div class="img2">
                <img src="Pic/img2.jpg" class="img-thumbnail " >
            </div>
            <div class="img3">
                <img src="Pic/img3.jpg" class="img-thumbnail " >
            </div>
        </div>
    </body>

</html>
