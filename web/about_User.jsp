<%-- 
    Document   : about
    Created on : 12-Mar-2020, 22:13:39
    Author     : Rob
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
                <a class = "navbar-brand" href="userHome.jsp"><img src="img/logonew2.png"></a>
                <button class="navbar-toggler" type ="button" data-toggle="collapse" data-target="#navbarResponsive">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item">
                            <a class="nav-link" href="userHome.jsp">Home</a>
                        </li>
                        <li class="nav-item active">
                            <a class="nav-link" href="about_User.jsp">About</a>
                        </li>
                         <li class="nav-item">
                            <a class="nav-link" href="QuizMathsMania/MathsManiaQuiz.html">Quiz</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="gallery_User.jsp">Gallery</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="profile.jsp">Profile</a>
                        </li>

                        <li class="nav-item">
                            <form action="UserController" class="login-form">  
                                <input type="submit" name="menu" value="Logout" class="btn btn-primary btn-lrg" />

                            </form>

                        </li>

                    </ul>


                </div>
            </div>


        </nav>

        <!--- Image Slider -->
        <div id="slides" class="carousel slide" data-ride="carousel">
            <ul class="carousel-indicators">
                <li data-target="#slides" data-slide-to="0" class="active"></li>
                <li data-target="#slides" data-slide-to="1"></li>
                <li data-target="#slides" data-slide-to="2"></li>
            </ul>
             <div class="carousel-inner">

                <div class="carousel-item active">
                    <img src="img/menuscene3-dark.png">
                    <div class="carousel-caption">
                        <h1 class="display-2">Welcome</h1>
                        <h3>To Maths Mania</h3>
                        <button type="button" class="btn btn-primary btn-lrg" hr>Download</button>

                    </div>
                </div>

                <div class="carousel-item">
                    <img src="img/division.PNG">
                </div>

                <div class="carousel-item">
                    <img src="img/division3.PNG">
                </div>
				
				<div class="carousel-item">
                    <img src="img/division2.PNG">
                </div>
				
				<div class="carousel-item">
                    <img src="img/multi1.PNG">
                </div>
				
				<div class="carousel-item">
                    <img src="img/multi4.PNG">
                </div>
            </div>




        </div>

        <!--- Welcome Section -->

        <div class="container-fluid padding">
            <div class="row welcome text-center">
                <div class="col-12">
                    <h1 class="display-4">About</h1>
                </div>
                <hr>

            </div>
        </div>

        <div class="container-fluid padding">
            <div class="row padding">
                <div class="col-lg-12 text-center">

                    <p>Math Mania is an interactive virtual reality application created by Robert Daly as part of his final year project at Limerick Institute of Technology. The applications target audience is 3rd class primary school pupils</p>
                    <p>The game currently has two levels. The first level deals with a division question and the second level deals with a multiplication question. </p>			
                </div>
            </div>
        </div>




       <!--- Two Column Section -->
        <div class="container-fluid padding">
            <div class="row padding">
                <div class="col-lg-6">
                    <h2>First Level</h2>
                    <p>In the first level you are greeted with the task of solving a division question. The user is presented with a problem where they have to divide a number of apples between 3 boxes.</p>
                    <p> The user can interact with buttons in front of the boxes which drops an apple from the pipe above the box. The user must place the correct amount of apples in each box to solve the question.</p>
                    <p>This level also offers the user a tutorial where they can watch a similar question being answered. There is also an animated video that shows the user how to solve the question if they cannot figure it out. </p>
                    <p>The users are guided through the level by a character named Jammo who is a friendly robot who's aim is to guide the user through the level. </p>

                    <a href="gallery.jsp" class="btn btn-primary">See Jammo</a>
                   
                </div>
                <div class="col-lg-6">
                    <img src="img/123.PNG" class="img-fluid">
                </div>


            </div>

            <div class="row padding">
                <div class="col-lg-6">
                    <img src="img/multi4.PNG" class="img-fluid">
                </div>

                <div class="col-lg-6">
                    <h2>Second Level</h2>
                    <p>The second level was inspired by the beatsaber game where the users objective is to hit the correct cube to move onto the next question.</p>
                    <p>The user is displayed with a multiplication question and has the option of 4 different answers. They must hit the correct answer to move onto the next question and earn a score which is displayed at the end of the game</p>
					<p> The user is can pick up two blasters using the controllers. When the player squeezes the trigger the blaster will shoot an apple.</p>
                    <br>

                </div>



            </div>

            <div class="row padding">
                <div class="col-lg-6">
                    <h2>Quiz</h2>
                    <p>The quiz allows users to practice what they have learned on the virtual reality application on the website.</p>
                    <p> The admin or teacher can create the quiz and add or modify questions in the quiz to target the users specific learning ability on the quiz.</p>
                    <p> The quiz uses a score system where the user will be awarded points when they answer a question correctly. The quiz also notifies the user if they have got the question right or wrong. </p>



                </div>
                <div class="col-lg-6">
                    <img src="img/quiz1.PNG" class="img-fluid">
                </div>


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





