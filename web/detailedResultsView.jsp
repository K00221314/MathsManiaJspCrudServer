
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="entities.Result"%>

<!doctype html>
<html>
    <head>
		<meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Maths Mania</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="https://use.fontawesome.com/releases/v5.0.8/js/all.js"></script>
        <link href="css/styles.css" rel="stylesheet">
        <meta charset="UTF-8">

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
           
            <h1>Edit Question</h1>
            <div class="form">
                <form action="ResultsController" method="get" class="show-form" name="results">
                    <br>
                    <label>category</label>
                    <input type="text" name="category" id="category" value="${results.category}"/>
                    <br>
                    <label>type</label>
                    <input type="text" name="type" id="type" value="${results.type}"/>
                    <br>
                    <label>difficulty</label>
                    <input type="text" name="difficulty" id="difficulty" value="${results.difficulty}"/>
                    <br>
                    <label>question</label>
                    <input type="text" name="question" id="question" value="${results.question}"/>
                    <br>
                    <label>correct answer</label>
                    <input type="text" name="correct_answer" id="correct_answer" value="${results.correct_answer}"/>
                    <br>
                    <label>incorrect answer 1</label>
                    <input type="text" name="incorrect_answer1" id="incorrect_answer1" value="${incorrect_answer1}"/>
                    <br>
                    <label>incorrect answer 2</label>
                    <input type="text" name="incorrect_answer2" id="incorrect_answer2" value="${incorrect_answer2}"/>
                    <br>
                    <label>incorrect answer 3</label>
                    <input type="text" name="incorrect_answer3" id="incorrect_answer3" value="${incorrect_answer3}"/>
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



