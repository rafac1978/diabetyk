<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Diabetyk Portal</title>
    
    <link href="resources/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link href="resources/css/style.css" rel="stylesheet" media="screen">
</head>
<body>
<div id="loginForm" class="modal hide fade" tabindex="-1" role="dialog">
    <div class="modal-header">
        <h3 id="myModalLabel">Logowanie</h3>
    </div>
    <form class="form-horizontal" action="j_spring_security_check" method="post">
        <div class="modal-body">
            <div class="control-group">
                <label class="control-label" for="inputLogin">Nazwa użytkownika:</label>
                <div class="controls">
                    <input id="inputLogin" type="text" name="j_username">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="inputPassword">Hasło:</label>
                <div class="controls">
                    <input id="inputPassword" type="password" name="j_password">
                </div>
            </div>
            <c:if test="${param['error'] == true}">
                <div class="alert alert-block alert-error fade in">
                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                    <h5 class="alert-heading">Błąd logowania</h5>
                    <p>Podany login lub hasło są nieprawidłowe.</p>
                </div>
            </c:if>
        </div>
        <div class="modal-footer">
            <button type="submit" class="btn btn-primary">Zaloguj</button>
        </div>
    </form>
</div>
    
    <%@include file="../template/bootstrap-footer.jsp" %>

<script>
    $(function () {
        $('#loginForm').on('shown', function() {
            $('#inputLogin').focus();
        }).modal('show');
    });
</script>
</body>
</html>
