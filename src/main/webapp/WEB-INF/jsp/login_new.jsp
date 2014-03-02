<%-- 
    Document   : login_new
    Created on : 2014-03-02, 23:24:11
    Author     : Adrian Lapierre
--%>

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

        <title>Diabetyk Portal :: Logowanie</title>

        <%@include file="../template/bootstrap.jsp" %>

        <!-- Custom styles for this template -->
        <link href="resources/css/signin.css" rel="stylesheet">

    </head>

    <body>

        <div class="container">

            <form class="form-signin" role="form" action="j_spring_security_check" method="post">
                <h2 class="form-signin-heading">Proszę się zalogować</h2>
                <input type="text" name="j_username" class="form-control" placeholder="Login" required autofocus>
                <input type="password" name="j_password" class="form-control" placeholder="Hasło" required>
                <label class="checkbox">
                    <input name="_spring_security_remember_me" type="checkbox" > Zapamiętaj mnie
                </label>

                <c:if test="${param['error'] == true}">
                    <div class="alert alert-block alert-error fade in">
                        <button type="button" class="close" data-dismiss="alert">&times;</button>
                        <h5 class="alert-heading">Błąd logowania</h5>
                        <p>Podany login lub hasło są nieprawidłowe.</p>
                    </div>
                </c:if>

                <button class="btn btn-lg btn-primary btn-block" type="submit">Zaloguj</button>
            </form>

        </div> <!-- /container -->


        <%@include file="../template/bootstrap-footer.jsp" %>
    </body>
</html>

