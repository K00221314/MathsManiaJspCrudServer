

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="entities.User"%>
<%@page import="entities.User"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="${pageContext.request.contextPath}/css/form.css" rel="stylesheet" type="text/css">
        <title>Log in</title>
    </head>
    <body>

        <div class="login-page">
            <div class="logo">             
                <img class="logohome" src="img/logonew3.png">           
            </div>
            <h1>Sign In</h1>
            <div class="form">
                <form action="UserController" method="post" class="login-form" name="Login">
                    <br>
                    <label>Username</label>
                    <input type="text" name="username" id="username"/>
                    <br>
                    <label>Password</label>
                    <input type="password" name="password" id="password"/>
                    <br>
                    <input type="submit" name="menu" value="Process Login"/>

                </form>
                <a href="AdminController?menu=Login">Teacher Sign in</a>
            </div>
        </div>
        <script
            src="https://code.jquery.com/jquery-1.12.4.js"
            integrity="sha256-Qw82+bXyGq6MydymqBxNPYTaUXXq7c8v3CwiYwLLNXU="
        crossorigin="anonymous"></script>
        <script src="js/jquery.validate.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/form-validation.js"></script>
    </body>
</html>

