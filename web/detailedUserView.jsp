
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="entities.User"%>



<!doctype html>


<html>

    <head>
		<meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="https://use.fontawesome.com/releases/v5.0.8/js/all.js"></script>
        <link href="css/styles.css" rel="stylesheet">
        <meta charset="UTF-8">
        <title>Edit Profile</title>
        <link rel="stylesheet" href="css/form.css">
        <meta name="viewport" content="width=device-width , initial-scale=1.0">
    </head>

    <body>
		
		 <!-- Navigation -->
        <nav class="navbar navbar-expand-md navbar-light bg-light sticky-top">
            <div class="container-fluid">
                <a class = "navbar-brand" href="adminHome.jsp"><img src="img/logonew2.png"></a>
                <button class="navbar-toggler" type ="button" data-toggle="collapse" data-target="#navbarResponsive">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item">
                            <a class="nav-link" href="adminHome.jsp">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="about_Admin.jsp">About</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="gallery_Admin.jsp">Gallery</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="profile_Admin.jsp">Profile</a>
                        </li>
                        <li class="nav-item active">
                            <a class="nav-link" href="AdminControllPage.jsp">Edit</a>
                        </li>
                        <li class="nav-item">
                            <form action="AdminController" class="login-form">  
                                <input type="submit" name="menu" value="Logout" class="btn btn-primary btn-lrg" />

                            </form>

                        </li>
                    </ul>


                </div>
            </div>


        </nav>

        <div class="login-page">
            
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



