<%-- 
    Document   : register
    Created on : 2014-03-03, 22:24:11
    Author     : Adrian Lapierre
--%>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pl">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="shortcut icon" href="resources/i/Diabetes_icon.png">

        <title>Diabetyk Portal :: Rejestracja</title>

        <%@include file="../template/bootstrap.jsp" %>

        <!-- Custom styles for this template -->
        <link href="resources/css/signin.css" rel="stylesheet">

    </head>

    <body>

        <div class="container">

            <form:form cssClass="form-signin" method="post" commandName="user">
                <h2 class="form-signin-heading">Rejestracja</h2>
                <form:label path="userName">Login:</form:label>
                <form:input path="userName" cssClass="form-control" placeholder="Login" required="true"/>
                
                <form:label path="password">Hasło:</form:label>
                <form:password path="password" cssClass="form-control" placeholder="Hasło" required="true"/>
                
                <form:label path="passwordAgain">Powtórz hasło:</form:label>
                <form:password path="passwordAgain" cssClass="form-control" placeholder="Powtórz hasło" required="true"/>
                
                <form:label path="email">Email</form:label>
                <form:input type="email" path="email" cssClass="form-control" placeholder="Email" required="true"/>
                <br/>
                <button class="btn btn-lg btn-primary btn-block" type="submit">Rejestruj</button>
            </form:form>

        </div> <!-- /container -->


        <%@include file="../template/bootstrap-footer.jsp" %>
    </body>
</html>

