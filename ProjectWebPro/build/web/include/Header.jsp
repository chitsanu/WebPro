<%-- 
    Document   : Header
    Created on : Oct 23, 2018, 4:55:32 PM
    Author     : James
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<header>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" ></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" ></script>
    <style>
        .wrapper{
            display:grid;
            grid-template-columns: 30% 70%;
            justify-items:stretch;
            align-items: stretch;
            background: #79BD9A;
        }

        .brandner{
            padding-left: 1em;
            align-self: flex-start;
        }
        .navHead{
            padding-top: 1em;
            padding-right: 1em;
            justify-self: end;


        }
        a:Link{
            color: whitesmoke;
            text-decoration: none;
        }
        a:visited{
            color: whitesmoke;
            text-decoration: none;
        }
        a:hover{
            color: #CFF09E;
        }
        img{
            padding: 5px;
        }
        

    </style>
</header>
<div class="wrapper">
    <div class="brandner">
        <a href="HomePage.jsp"><img src="Pic/LOGO.png" width="100px" hight="50px"></a>
    </div>     
    <div class="navHead">
        <a href="#">Sign up</a>
        <c:choose>
            <c:when test="${sessionScope.user!= null}"><!--แก้ตรงuser-->
                <a href="logout">${sessionScope.accountname}</a> <!--แก้ชื่อColumn-->
            </c:when>
            <c:otherwise>
                <a href="login">Sign in</a>
            </c:otherwise>
        </c:choose>
        <a href="#">Shopping Cart</a>
    </div>
</div>
<nav class="navbar navbar-expand-lg navbar-light" style="background-color: #A8DBA8"><!--NavBar-->
    <a class="navbar-brand" style="color : whitesmoke" href="HomePage.jsp">Exotic Animal Food</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" style="color : whitesmoke" href="HomePage.jsp">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" style="color : whitesmoke" href="#">Product</a><!--ใส่link-->
            </li>
            <li class="nav-item">
                <a class="nav-link" style="color : whitesmoke" href="#">Contact</a><!--ใส่link-->
            </li>
            
            
        </ul>
        <form class="form-inline my-2 my-lg-0" action="#" method="post">
            <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
    </div>
</nav>