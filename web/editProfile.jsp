<%-- 
    Document   : newjsp
    Created on : 10-Dec-2018, 11:32:24
    Author     : K00214105
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.User"%>
<!doctype html>
<html>

    <head>
        <meta charset="UTF-8">
        <title>Edit Profile</title>
        <link rel="stylesheet" href="css/form.css">
        <meta name="viewport" content="width=device-width , initial-scale=1.0">
    </head>

    <body>

        <div class="login-page">
            <div class="logo">               
                    <img class="logohome" src="${pageContext.request.contextPath}/img/logo1.png" alt="LIT Gallery Logo">
            </div>
            <h1>Edit Profile</h1>
            <div class="form">
                <form action="UserController" method="post" class="register-form" name="registration">

                    <br>
                    <label>First name</label>
                    <input type="text" name="fName" id="fName" value="${user.fName}" maxlength="40"/>
                    <br>
                    <label>Last name</label>
                    <input type="text" name="lName" id="lName" value="${user.lName}" maxlength="40"/>
                    <br>
                    <label>Email</label>
                    <input type="email" name="email" id="email" value="${user.email}" maxlength="40"/>
                    <br>
                    <label>User name</label>
                    <input type="text" name="username" id="username" value="${user.username}" maxlength="40"/>
                    <br>
                    <label>Password</label>
                    <input type="password" name="password" id="password" value="${user.password}" maxlength="40"/>
                    <br>
                    <label>Bio</label>
                    <input type="text" name="bio" id="bio" value="${user.bio}" maxlength="400"/>
                    <br>
                    
					
					<label>Profile Picture</label>
      
                    <br>
					 <select name="profilePic" id="pic">

                        <option name="profilePic" id="pic" value = "1.jpg">Image1</option>
                        <option name="profilePic" id="pic" value = "ISD">ISD</option>

                    </select>
					
					<br>

                 

                    <input type="submit" name="menu" value="Save User Details"/>
                    <input type="reset" />
                    <input type="submit" name="menu" value="Delete User Check"/>


                </form>
            </div>
        </div>

    </body>

</html>

