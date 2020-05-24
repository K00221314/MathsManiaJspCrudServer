
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="entities.User"%>

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
                        <li class="nav-item active">
                            <a class="nav-link" href="userHome.jsp">Home</a>
                        </li>
                        <li class="nav-item">
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
                    <h1 class="display-4">Math Mania</h1>
                </div>
                <hr>
                <div class="col-12">
                    <p class="lead">A Virtual reality application for primary school children.</p>
                </div>

            </div>
        </div>


        <!--- Three Column Section -->
        <div class="container-fluid padding">
            <div class="row text-center padding">
                <div class="col-xs-12 col-sm-6 col-md-4">
                    <i class="fas fa-bullseye"></i>
                    <h3>Objective</h3>
                    <p>The objective of this game is to create a virtual reality environment that allows children to learn and practice their maths skills.
                    </p>
                </div>

                <div class="col-xs-12 col-sm-6 col-md-4">
                    <i class="fas fa-crosshairs"></i>
                    <h3>Aim</h3>
                    <p>The main aims of this educational Virtual Reality game is to achieve learning in a fun way. I hope to motivate children who are struggling with maths to realise they are capable and can solve problems.
                    </p>
                </div>

                <div class="col-sm-12 col-md-4">
                   <i class="fas fa-calculator"></i>
                    <h3>Background</h3>
                    <p>Maths is currently a major talking point in Ireland with the introduction of the new curriculum which is believed to be introduced in 2021. </p>
                </div>

            </div>
            <hr class="my-4">
        </div>

        <!--- Two Column Section -->
        <div class="container-fluid padding">
            <div class="row padding">
                <div class="col-lg-6">

                     <h2>What is Virtual Reality ?</h2>
                    <br>
                    <p>Virtual reality (VR) is a simulated experience that can be similar to or completely different from the real world.</p>
                    <p>Applications of virtual reality can include entertainment (i.e. video games) and educational purposes (i.e. medical or military training). Other, distinct types of VR style technology include augmented reality and mixed reality.</p>
                    <p>Currently standard virtual reality systems use either virtual reality headsets or multi-projected environments to generate realistic images, sounds and other sensations that simulate a user's physical presence in a virtual environment. A person using virtual reality equipment is able to look around the artificial world, move around in it, and interact with virtual features or items.</p>
                    <p>The effect is commonly created by VR headsets consisting of a head-mounted display with a small screen in front of the eyes, but can also be created through specially designed rooms with multiple large screens.</p>
                    <p>  Virtual reality typically incorporates auditory and video feedback, but may also allow other types of sensory and force feedback through haptic technology.</p>
                    <p>Maths Mania has been designed to use the HTC Vive headset and takes full advantage of the headsets capabilities to give the user a fun and immersive experience</p>

                    <br>








                </div>
                <div class="col-lg-6">
                    <img src="img/Untitled-1.png" class="img-fluid">
                </div>


            </div>

            <div class="row padding">
                <div class="col-lg-6">
                    <img src="img/vr-children_feature.jpg" class="img-fluid">
                </div>

                <div class="col-lg-6">
                     <h2>Learning through educational games</h2>
                    <br>
                    <p>The goal of this interactive VR game is to promote the learning of Maths. Educational games refer to
                        “complex systems that include pre-defined roles of participants and strictly defined objectives
                        through interactive activities with goals and rewards”.
                        As Maths Mania is a “educational game” this has many benefits to achieve the goal of educating children with
                        maths.</p>
                    <p>Currently gaming is one of the biggest industries in the world,and video games generate $137.9 billion per year.</p>
                    <p>Research shows that the average 8 to 12-year-old plays 13 hours of video games a week. This shows that students are naturally motivated to play games and if
                        education can be adapted through such a highly motivational media, it is a win-win for both students
                        and teachers.</p>
                    <p>There are many benefits to game based learning, it can increase a child’s memory capacity as games
                        often revolve around the utilization of memory, it can provide computer and simulation fluency as
                        playing games allows children to get used to how a computer works and teaches them the basics
                        such as creating an account for a website etc, it can also help with fast strategic thinking and
                        problem solving as with a maths game it will require users to think quickly and logically.
                        </p>
                    <br>
                </div>



            </div>

            <hr class="my-4">  
        </div>






       <!--- Connect -->
        <div class="container-fluid padding">
            <div class="row text-center padding">
                <div class="col-12">
                    <h2>Download the VR game</h2>
                </div>
                <div class="col-12 social padding">
                     <button type="button" class="btn btn-primary btn-lrg " hr>Download</button>
                </div>
            </div>
        </div>

        <!--- Footer -->
        <footer>
            <div class="container-fluid padding">
                <div class="row text-center">
                    <div class="col-md-4">

                        <img src="img/logofooter1.png">


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




