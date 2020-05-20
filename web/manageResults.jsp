
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="entities.Results"%>



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


        <div class="container-fluid padding">
            <div class="row welcome text-center">
                <div class="col-12">
                    <h1 class="display-4">All Questions</h1>
                </div>
                <hr>
                <div class="col-12">
                    <p class="lead">Edit questions.</p>
                </div>

            </div>
        </div>

        <!--- Cards -->
        <div class="container-fluid padding">
            <div class="row padding">


                <c:forEach var="results" items="${allresults}">  
                    <div class="col-md-4">
                        <div class="card">


                            <div class="card-body">
                                <h4 class="card-title"><a href="ResultsController?menu=getResultsView&Id=${results.id}">Question : ${results.question}</a></h4>

                                <h4 class="card-title"><a href="ResultsController?menu=getResultsView&Id=${results.id}">Correct Answer : ${results.correct_answer}</a></h4>


                                <a href="ResultsController?menu=DeleteResults&id=${results.id}" class="btn btn-primary">Delete Question</a>
                                <a href="ResultsController?menu=getResultsView&id=${results.id}" class="btn btn-primary">Update Question</a>


                            </div>

                        </div>
                    </div>
                </c:forEach>


            </div>




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

