<%-- 
    Document   : profile
    Created on : 12-Mar-2020, 22:20:02
    Author     : Rob
--%>
<%@page import="model.User"%>
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
                <a class="nav-link" href="userHome.jsp">Home</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="about_User.jsp">About</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="gallery_User.jsp">Gallery</a>
            </li>
            <li class="nav-item active">
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

<div class="container-fluid padding">
   <div class="row padding">
       
       <div class="col-md-3">
          <div class="text-center">
			  <a class="username" href="profile.jsp"><img src="${pageContext.request.contextPath}/img/${user.profilePic}" class="img-fluid"></a>
          
           <h2>Name</h2>
		   <h3>${user.username}</h3>
           
           <a href="editProfile.jsp" class="btn btn-primary">Edit Profile</a>
       </div>
       </div>
       
       <div class="col-md-9">
		   <h2>Bio</h2>
           <p class="lead">${user.bio}</p>
           
           <hr>
           
           <p>
               Lorem ipsum dolor sit amet, consectetur adipisicing elit. Possimus quo ea repellendus recusandae nihil, minima aut deleniti exercitationem dolorum. Voluptates delectus nisi, suscipit totam porro commodi repellat eos dicta fugit, cumque, aut a velit. Quisquam qui, ab modi eius sequi quas aperiam inventore voluptatibus facere quia consequatur nesciunt debitis minima non distinctio repudiandae saepe tenetur cupiditate fugit! Explicabo a voluptatum sunt ipsam vel, assumenda adipisci, ut ab quia ratione, ipsum quidem reiciendis omnis qui, sint laudantium iure magnam commodi totam!
           </p>
           
           <p>
               Lorem ipsum dolor sit amet, consectetur adipisicing elit. Possimus quo ea repellendus recusandae nihil, minima aut deleniti exercitationem dolorum. Voluptates delectus nisi, suscipit totam porro commodi repellat eos dicta fugit, cumque, aut a velit. Quisquam qui, ab modi eius sequi quas aperiam inventore voluptatibus facere quia consequatur nesciunt debitis minima non distinctio repudiandae saepe tenetur cupiditate fugit! Explicabo a voluptatum sunt ipsam vel, assumenda adipisci, ut ab quia ratione, ipsum quidem reiciendis omnis qui, sint laudantium iure magnam commodi totam!
           </p>
       </div>
   </div> 
    
</div>

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

</body>
</html>





