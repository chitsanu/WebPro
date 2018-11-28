<%-- 
    Document   : EditProfile
    Created on : Nov 25, 2018, 9:31:05 AM
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="EditProfile" method="post">
            <h1>Profile</h1><br>

            <label>First Name</label>
            <input type="text" name="fname" value="${sessionScope.profile.fname}">


            <label>Last Name</label>
            <input type="text" name="lname" value="${sessionScope.profile.lname}">


            <label>Address</label>
            <input type="text" name="address" value="${sessionScope.profile.address}">


            <label>Phone number</label>
            <input type="text" name="tel" value="${sessionScope.profile.tel}">
            <br>
            <br>
            <label>Credit Card</label> <br>           
            Card Number<input type="number" name="card" minlength="16" maxlength="16" value="${sessionScope.card.cardnumber}"/><br>    
            Exp.<input type="text"name="exp" minlength="5" maxlength="5" value="${sessionScope.card.exp}"><br>        
            CVC<input type="number"name="cvc" minlength="3" maxlength="3" value="${sessionScope.card.cvc}"/>
                      
                      
            <br>
            <button type="submit">Update profile</button>
        </form>
    </body>
</html>
