<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       
        <meta charset="UTF-8">
        <title>Login</title>
        <link href="${pageContext.request.contextPath}/css/form.css" rel="stylesheet" type="text/css">
        <meta name="viewport" content="width=device-width , initial-scale=1.0">
    </head>
    <body>
		
		<!-- Navigation -->
        <nav class="navbar navbar-expand-md navbar-light bg-light sticky-top">
            <div class="container-fluid">
                <a class = "navbar-brand" href="home.jsp"><img src="img/logonew2.png"></a>
                <button class="navbar-toggler" type ="button" data-toggle="collapse" data-target="#navbarResponsive">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item active">
                            <a class="nav-link" href="home.jsp">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="about.jsp">About</a>
                        </li>

                        <li class="nav-item">
                            <a class="nav-link" href="gallery.jsp">Gallery</a>
                        </li>

                        <li class="nav-item">
                            <a href="login.jsp" class="btn btn-primary btn-block">Sign In</a>
                        </li>

                        <li class="nav-item">
                            <a href="AddUser.jsp" class="btn btn-primary btn-block">Sign Up</a>
                        </li>

                    </ul>


                </div>
            </div>


        </nav>

        <div class="login-page">
           
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