<%-- 
    Document   : register
    Created on : 07-Dec-2016, 21:39:41
    Author     : AMarie
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="model.Admin"%>

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
    <a class = "navbar-brand" href="#"><h1>Math Mania</h1></a>
    <button class="navbar-toggler" type ="button" data-toggle="collapse" data-target="#navbarResponsive">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
            <li class="nav-item active">
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
			<li class="nav-item">
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
            <i class="fas fa-code"></i>
            <h3>Icon1</h3>
            <p>gbiugbeweiugbwieugbiweugb</p>
        </div>
        
        <div class="col-xs-12 col-sm-6 col-md-4">
            <i class="fas fa-code"></i>
            <h3>Icon1</h3>
            <p>gbiugbeweiugbwieugbiweugb</p>
        </div>
        
        <div class="col-sm-12 col-md-4">
            <i class="fas fa-code"></i>
            <h3>Icon1</h3>
            <p>gbiugbeweiugbwieugbiweugb</p>
        </div>
        
    </div>
    <hr class="my-4">
</div>

<!--- Two Column Section -->
<div class="container-fluid padding">
    <div class="row padding">
       <div class="col-lg-6">
           <h2>Title</h2>
           <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Tenetur assumenda illo ea nesciunt magni quaerat sed incidunt earum facere est quae quo explicabo, fugiat culpa eos? Iste, excepturi, doloremque nesciunt delectus rerum cum omnis incidunt officiis aperiam dolor reprehenderit nam!</p>
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Tenetur assumenda illo ea nesciunt magni quaerat sed incidunt earum facere est quae quo explicabo, fugiat culpa eos? Iste, excepturi, doloremque nesciunt delectus rerum cum omnis incidunt officiis aperiam dolor reprehenderit nam!</p>
            <br>
            <a href="#" class="btn btn-primary">Learn More</a>
       </div>
       <div class="col-lg-6">
           <img src="img/test.png" class="img-fluid">
       </div>
       
        
    </div>
    
    <div class="row padding">
        <div class="col-lg-6">
           <img src="img/test.png" class="img-fluid">
       </div>
          
          <div class="col-lg-6">
           <h2>Title</h2>
           <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Tenetur assumenda illo ea nesciunt magni quaerat sed incidunt earum facere est quae quo explicabo, fugiat culpa eos? Iste, excepturi, doloremque nesciunt delectus rerum cum omnis incidunt officiis aperiam dolor reprehenderit nam!</p>
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Tenetur assumenda illo ea nesciunt magni quaerat sed incidunt earum facere est quae quo explicabo, fugiat culpa eos? Iste, excepturi, doloremque nesciunt delectus rerum cum omnis incidunt officiis aperiam dolor reprehenderit nam!</p>
            <br>
            <a href="#" class="btn btn-primary">Learn More</a>
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
                <img class="card-img-top" src="img/test.png">
                <div class="card-body">
                    <h4 class="card-title">Test</h4>
                    <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quis necessitatibus totam, ipsam harum est consequuntur magnam dolore nulla ab? Harum.</p>
                    <a href="#" class="btn btn-outline-secondary">Button</a>
                </div>
            </div>
        </div>
        
        <div class="col-md-4">
            <div class="card">
                <img class="card-img-top" src="img/test.png">
                <div class="card-body">
                    <h4 class="card-title">Test</h4>
                    <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quis necessitatibus totam, ipsam harum est consequuntur magnam dolore nulla ab? Harum.</p>
                    <a href="#" class="btn btn-outline-secondary">Button</a>
                </div>
            </div>
        </div>
        
        <div class="col-md-4">
            <div class="card">
                <img class="card-img-top" src="img/test.png">
                <div class="card-body">
                    <h4 class="card-title">Test</h4>
                    <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quis necessitatibus totam, ipsam harum est consequuntur magnam dolore nulla ab? Harum.</p>
                    <a href="#" class="btn btn-outline-secondary">Button</a>
                </div>
            </div>
        </div>
        
    </div>
    
</div>




<!--- Connect -->
<div class="container-fluid padding">
    <div class="row text-center padding">
        <div class="col-12">
            <h2>Connect</h2>
        </div>
        <div class="col-12 social padding">
            <a href="#"><i class="fab fa-facebook"></i></a>
             <a href="#"><i class="fab fa-youtube"></i></a>
              <a href="#"><i class="fab fa-instagram"></i></a>
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




