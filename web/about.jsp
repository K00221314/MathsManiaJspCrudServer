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
	<title>Math Mania</title>
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
    <a class = "navbar-brand" href="#"><img src="img/logo.png"></a>
    <button class="navbar-toggler" type ="button" data-toggle="collapse" data-target="#navbarResponsive">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
            <li class="nav-item">
                <a class="nav-link" href="home.jsp">Home</a>
            </li>
            <li class="nav-item active">
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

<!--- Image Slider -->
<div id="slides" class="carousel slide" data-ride="carousel">
    <ul class="carousel-indicators">
        <li data-target="#slides" data-slide-to="0" class="active"></li>
         <li data-target="#slides" data-slide-to="1"></li>
          <li data-target="#slides" data-slide-to="2"></li>
    </ul>
    <div class="carousel-inner">
       
        <div class="carousel-item active">
            <img src="img/test.png">
            <div class="carousel-caption">
                <h1 class="display-2">Welcome</h1>
                <h3>To Math Mania</h3>
                <button type="button" class="btn btn-primary btn-lrg">Download</button>
                
            </div>
        </div>
        
        <div class="carousel-item">
            <img src="img/test.png">
        </div>
        
        <div class="carousel-item">
            <img src="img/test.png">
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
           <img src="img/22.PNG" class="img-fluid">
       </div>
          
          <div class="col-lg-6">
           <h2>Second Level</h2>
            <p>The second level was inspired by the beatsaber game where the users objective is to hit the correct cube to move onto the next question.</p>
			<p>The user is displayed with a multiplication question and has the option of 4 different answers. They must hit the correct answer to move onto the next question and earn a score which is displayed at the end of the game</p>
			
            <br>
           
       </div>
      
       
        
    </div>
    
    
</div>

  
<!--- Meet the team -->
<div class="container-fluid padding">
    <div class="row welcome text-center">
        <div class="col-12">
            <h1 class="display-4">Title </h1>
        </div>
        <hr>
    </div>
    
</div>


<!--- Cards -->
<div class="container-fluid padding">
    <div class="row padding">
        <div class="col-md-4">
            <div class="card">
             
                <div class="card-body">
                    <h4 class="card-title">Test</h4>
                    <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quis necessitatibus totam, ipsam harum est consequuntur magnam dolore nulla ab? Harum.</p>
                    <a href="#" class="btn btn-outline-secondary">Button</a>
                </div>
            </div>
        </div>
        
        <div class="col-md-4">
            <div class="card">
                <img class="card-img-top" src="img/team1.png">
                <div class="card-body">
                    <h4 class="card-title">Test</h4>
                    <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quis necessitatibus totam, ipsam harum est consequuntur magnam dolore nulla ab? Harum.</p>
                    <a href="#" class="btn btn-outline-secondary">Button</a>
                </div>
            </div>
        </div>
        
        <div class="col-md-4">
            <div class="card">
                <img class="card-img-top" src="img/team1.png">
                <div class="card-body">
                    <h4 class="card-title">Test</h4>
                    <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quis necessitatibus totam, ipsam harum est consequuntur magnam dolore nulla ab? Harum.</p>
                    <a href="#" class="btn btn-outline-secondary">Button</a>
                </div>
            </div>
        </div>
        
    </div>
    
</div>






<!--- Footer -->
<footer>
<div class="container-fluid padding">
    <div class="row text-center">
        <div class="col-md-4">
           <!--<img src="img/w3newbie.png">-->
           <h1>Math Mania</h1>
            <hr class="light">
            <p>gbskgbsgjbsogb</p>
            <p>gbskgbsgjbsogb</p>
            <p>gbskgbsgjbsogb</p>
             <p>gbskgbsgjbsogb</p>
            
        </div>
        
          <div class="col-md-4">
            <hr class="light">
            <h5>footer</h5>
             <hr class="light">
            <p>gbskgbsgjbsogb</p>
            <p>gbskgbsgjbsogb</p>
            <p>gbskgbsgjbsogb</p>
            
        </div>
        
          <div class="col-md-4">
            <hr class="light">
            <h5>footer</h5>
             <hr class="light">
            <p>gbskgbsgjbsogb</p>
            <p>gbskgbsgjbsogb</p>
            <p>gbskgbsgjbsogb</p>
            
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





