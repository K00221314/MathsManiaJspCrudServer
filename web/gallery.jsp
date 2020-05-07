<%-- 
    Document   : gallery
    Created on : 12-Mar-2020, 22:18:47
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
	<script src="https://cdnjs.cloudflare.com/ajax/libs/ekko-lightbox/5.3.0/ekko-lightbox.js"></script>
	<link href="https://cdnjs.cloudflare.com/ajax/libs/ekko-lightbox/5.3.0/ekko-lightbox.css" rel="stylesheet">
	<link href="css/styles.css" rel="stylesheet">
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
            <li class="nav-item">
                <a class="nav-link" href="home.jsp">Home</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="about.jsp">About</a>
            </li>
            <li class="nav-item active">
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

<section>
    
    <div class="row justify-content-center">
    <div class="col-md-8">
        <div class="row">
            <a href="img/123.PNG" data-toggle="lightbox" data-gallery="example-gallery" class="col-sm-4">
                <img src="img/123.PNG" class="img-fluid">
            </a>
            <a href="img/123.PNG" data-toggle="lightbox" data-gallery="example-gallery" class="col-sm-4">
                <img src="img/123.PNG" class="img-fluid">
            </a>
            <a href="img/123.PNG" data-toggle="lightbox" data-gallery="example-gallery" class="col-sm-4">
                <img src="img/123.PNG" class="img-fluid">
            </a>
        </div>
        <div class="row">
            <a href="img/123.PNG" data-toggle="lightbox" data-gallery="example-gallery" class="col-sm-4">
                <img src="img/123.PNG" class="img-fluid">
            </a>
            <a href="img/123.PNG" data-toggle="lightbox" data-gallery="example-gallery" class="col-sm-4">
                <img src="img/123.PNG" class="img-fluid">
            </a>
            <a href="img/123.PNG" data-toggle="lightbox" data-gallery="example-gallery" class="col-sm-4">
                <img src="img/123.PNG" class="img-fluid">
            </a>
        </div>
    </div>
</div>
    
</section>


<!--- Footer -->
<footer>
<div class="container-fluid padding">
    <div class="row text-center">
        <div class="col-md-4">
            <img src="img/w3newbie.png">
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
           <hr class="light">
           <h5>&copy; Robert Daly</h5>  
        </div>
    </div>
</div>


    </footer>
    
    <script>
    $(document).on('click', '[data-toggle="lightbox"]', function(event) {
                event.preventDefault();
                $(this).ekkoLightbox();
            });
    </script>

</body>
</html>





