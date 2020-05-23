
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="entities.User"%>
<%@page import="entities.Result"%>

<!DOCTYPE html>
<html lang="en">
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




        <!--- Welcome Section -->

        <div class="container-fluid padding">
            <div class="row welcome text-center">
                <div class="col-12">
                    <h1 class="display-4">Maths Mania</h1>
                </div>
                <hr>
                <div class="col-12">
                    <p class="lead">Admin Area.</p>
                </div>

            </div>
        </div>

      
		
		  <!--- Three Column Section -->
        <div class="container-fluid padding">
            <div class="row text-center padding">
                <div class="col-xs-12 col-sm-6 col-md-4">
                 
                    <h3>Add Questions</h3>
                    <p>Fill out the information to add a question to the quiz.
                    </p>
					<a href="addQuestion.jsp" class="btn btn-primary">Add Questions</a>
					
                </div>

                <div class="col-xs-12 col-sm-6 col-md-4">
                    
                    <h3>Manage Users</h3>
                    <p>View all users and edit or delete users.
                    </p>
					<a href="AdminController?menu=getUserView" class="btn btn-primary">Manage Users</a>
                </div>

                <div class="col-sm-12 col-md-4">
                    
                    <h3>Manage Questions</h3>
                    <p>Modify of delete quiz questions. </p>
					<a href="ResultsController?home=getResultsView" class="btn btn-primary">Manage Questions</a>
                </div>

            </div>
            <hr class="my-4">
        </div>



        <!--- Footer -->
        <footer>
            <div class="container-fluid padding">
                <div class="row text-center">
                    <div class="col-md-4">

                        <img src="img/logonew3.png">


                    </div>

                    <div class="col-md-4">

                    </div>

                    <div class="col-md-4">
                        <h5>By Robert Daly</h5>
                        <hr class="light">
                        <p>K00221314</p>
                        <p>IDM4</p>
                        <p>LIT</p>

                    </div>

                    <div class="col-12">
                        <hr class="light-1ong">
                        <h5>&copy; Robert Daly</h5>  
                    </div>
                </div>
            </div>


        </footer>

    </body>
</html>









