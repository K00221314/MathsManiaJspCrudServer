<%-- 
    Document   : deleteProfile
    Created on : 10-Dec-2018, 13:55:42
    Author     : K00214105
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html>

    <head>
        <meta charset="UTF-8">
        <title>Delete Profile</title>
        <link href="${pageContext.request.contextPath}/css/form.css" rel="stylesheet" type="text/css">
        <meta name="viewport" content="width=device-width , initial-scale=1.0">
    </head>

    <body>

        <div class="login-page">
            <div class="logo">
                <a href="index.html">
                    <img class="logohome" src="${pageContext.request.contextPath}/img/logo1.png" alt="LIT Gallery Logo">
                </a>
            </div>
            <h1>Delete Profile</h1>
            <div class="form">
                <form>

                    <label>User Name</label>
                    <input type="text" value="${user.username}"/>
                    <br>
                    <label>Password</label>
                    <input type="password" />
                    <br>


                    <label>Confirm Password</label>
                    <input type="password" />
                    <br>

                    <input type="submit" name="menu" value="Delete User"/>
                    
                </form>
            </div>
        </div>

    </body>

</html>

