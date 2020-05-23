<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="entities.User"%>
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
                <img class="logohome" src="img/logonew3.png">
            </div>
            <h1>Edit Profile</h1>
            <div class="form">
                <form action="UserController" method="post" class="register-form" name="registration">

                    <br>
                    <label>First name</label>
                    <input type="text" name="fName" id="fName" value="${activeUser.fName}" maxlength="40"/>
                    <br>
                    <label>Last name</label>
                    <input type="text" name="lName" id="lName" value="${activeUser.lName}" maxlength="40"/>
                    <br>
                    <label>Email</label>
                    <input type="email" name="email" id="email" value="${activeUser.email}" maxlength="40"/>
                    <br>
                    <label>User name</label>
                    <input type="text" name="username" id="username" value="${activeUser.username}" maxlength="40"/>
                    <br>
                    <label>Password</label>
                    <input type="password" name="password" id="password" value="${activeUser.password}" maxlength="40"/>
                    <br>
                    <label>Bio</label>
                    <input type="text" name="bio" id="bio" value="${activeUser.bio}" maxlength="400"/>
                    <br>


                    <label>Profile Picture</label>

                    <br>
                    <select name="profile_pic" id="pic">

                        <option name="profile_pic" id="profile_pic" value = "1.jpg">Image1</option>
                        <option name="profile_pic" id="profile_pic" value = "ISD" ${activeUser.profile_pic == "ISD" ? "selected" : ""}>ISD</option>

                    </select>

                    <br>



                    <input type="submit" name="menu" value="Save User Details"/>
                    <input type="reset" />
                    <input type="submit" name="menu" value="Delete User"/>


                </form>
            </div>
        </div>
    </body>
</html>