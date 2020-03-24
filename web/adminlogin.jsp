

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Admin"%>
<!doctype html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Untitled Document</title>
        <link href="${pageContext.request.contextPath}/css/form.css" rel="stylesheet" type="text/css">
        <meta name="viewport" content="width=device-width , initial-scale=1.0">
    </head>
    <body>

        <div class="login-page">
            <div class="logo">
                <a href="index.html">
                    <img class="logohome" src="img/logo1.png" alt="LIT Gallery Logo">
                </a>
            </div>
            <h1>Teacher Sign In</h1>
            <div class="form">
                <form action="AdminController" method="get" class="login-form" name="Login"> 


                    <label for="username">username</label>
                    <input type="username" name="username" id="username">
                    <br>
                    <label for="password">Password</label>
                    <input type="password" name="password" id="password">
                    <br>
                    <p class="message">${message}</p>               
                    <input type="submit" name="menu" value="Process Login" />
                   

                </form>
            </div>
        </div>

    </body>
</html>