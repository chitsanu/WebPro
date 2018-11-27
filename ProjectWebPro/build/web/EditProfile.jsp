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
            <button type="submit">Update profile</button>
        </form>
    </body>
</html>
