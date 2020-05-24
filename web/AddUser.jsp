
<!DOCTYPE html>
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
        <link href="${pageContext.request.contextPath}/css/form.css" rel="stylesheet" type="text/css">
        <title>Sign Up</title>
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
            
            </div>
            <h1>Sign Up</h1>
            <div class="form">
                <form action="UserController" method="get" class="register-form" name="registration">

                    <br>
                    <label>First name</label>
                    <input type="text" name="fName" id="fName"/>
                    <br>
                    <label>Last name</label>
                    <input type="text" name="lName" id="lName"/>
                    <br>
                    <label>Email</label>
                    <input type="email" name="email" id="email"/>
                    <br>
                    <label>User name</label>
                    <input type="text" name="username" id="username"/>
                    <br>
                    <label>Profile Picture</label>

                    <br>
                    <select name="profile_pic" id="pic">

                        <option name="profile_pic" id="profile_pic" value = "1.jpg" >Image1</option>
                          <option name="profile_pic" id="profile_pic" value = "ISD" ${User.profile_pic == "ISD" ? "selected" : ""}>ISD</option>

                    </select>

                    <br>
                    <br>
                    <label>Password</label>
                    <input type="password" name="password" id="password"/>
                    <br>
                    <label>Bio</label>
                    <input type="text" name="bio" id="bio"/>
                    <br>





                    <input type="submit" name="menu" value="Save" />
                    <input type="reset" />
                </form>
            </div>
        </div
        <script
            src="https://code.jquery.com/jquery-1.12.4.js"
            integrity="sha256-Qw82+bXyGq6MydymqBxNPYTaUXXq7c8v3CwiYwLLNXU="
        crossorigin="anonymous"></script>
        <script src="js/jquery.validate.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/form-validation.js"></script>
    </body>
</html>
