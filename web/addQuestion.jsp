<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="entities.Results"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="${pageContext.request.contextPath}/css/form.css" rel="stylesheet" type="text/css">
        <title>Maths Mania</title>
    </head>
    <body>
        <div class="login-page">
            <div class="logo">

                <img class="logohome" src="${pageContext.request.contextPath}/img/logonew2.png">

            </div>
            <h1>Sign Up</h1>
            <div class="form">
                <form action="ResultsController" method="get" class="register-form" name="registration">

                    <br>
                    <label>category</label>
                    <input type="text" name="category" id="category" value="Maths"/>
                    <br>
                    <label>type</label>
                    <input type="text" name="type" id="type" value="3rd class"/>
                    <br>
                    <label>difficulty</label>

					<select name="difficulty" id="difficulty" >
						<option value="Easy" selected="true">Easy</option>
						<option value="Medium">Medium</option>
						<option value="Hard">Hard</option>
					</select>
                    <br>
                    <label>question</label>
                    <input type="text" name="question" id="question"/>
                    <br>
                    <label>correct answer</label>
                    <input type="text" name="correct_answer" id="correct_answer"/>
                    <br>
                    <br>
                    <label for="incorrect_answer1">incorrect answer 1</label>
                    <input type="text" name="incorrect_answer1" id="incorrect_answers1"/>
                    <br>
                    <label for="incorrect_answer2">incorrect answer 2</label>
                    <input type="text" name="incorrect_answer2" id="incorrect_answers2"/>
                    <br>
                    <label for="incorrect_answer3">incorrect answer 3</label>
                    <input type="text" name="incorrect_answer3" id="incorrect_answers3"/>
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
