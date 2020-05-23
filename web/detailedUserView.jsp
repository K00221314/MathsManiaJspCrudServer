
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="entities.User"%>



<!doctype html>


<html>

    <head>
        <meta charset="UTF-8">
        <title>Edit Profile</title>
        <link rel="stylesheet" href="css/form.css">
        <meta name="viewport" content="width=device-width , initial-scale=1.0">
    </head>

    <body>

        <div class="login-page">
            <div class="logo">               
                <img class="logohome" src="img/logonew3.png" alt="LIT Gallery Logo">
            </div>
            <h1>Edit Profile</h1>
            <div class="form">
                <form action="AdminController" method="get" class="show-form" name="user">


                    <br>
                    <label>First name</label>
                    <input type="text" name="f_name" id="f_name" value="${user.fName}" maxlength="40"/>
                    <br>
                    <label>Last name</label>
                    <input type="text" name="l_name" id="l_name" value="${user.lName}" maxlength="40"/>
                    <br>
                    <label>Email</label>
                    <input type="email" name="email" id="email" value="${user.email}" maxlength="40"/>
                    <br>
                    <label>User name</label>
                    <input type="text" name="username" id="username" value="${user.username}" maxlength="40"/>
                    <br>
                    <label>Password</label>
                    <input type="password" name="password" id="password" value="${user.password}" maxlength="40"/>
                    <br>
                    <label>Bio</label>
                    <input type="text" name="bio" id="bio" value="${user.bio}" maxlength="400"/>
                    <br>
                    <label>Profile Picture</label>

                    <br>
                    <select name="profile_pic" id="pic">

                        <option name="profile_pic" id="pic" value = "1.jpg">Image1</option>
                        <option name="profile_pic" id="pic" value = "ISD">ISD</option>

                    </select>

                    <br>



                    <input type="submit" name="menu" value="Update" />


                </form>
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



