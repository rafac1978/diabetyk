<%-- 
    Document   : product-list
    Created on : 2014-02-27, 21:04:50
    Author     : Adrian Lapierre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net" %>
<!DOCTYPE html>
<html lang="pl">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="i/Diabetes_icon.png">

    <title>Diabetyk Portal :: lista produktów</title>

    <%@include file="../template/bootstrap.jsp" %>
  </head>

  <body>

      <%@include file="../template/menu.jsp" %>

    <div class="container">
        <div class="jumbotron">
            
            <h2>Lista produków</h2>
            
            <display:table name="products">
                <display:column property="name" title="Nazwa" />
                <display:column property="fat" title="Tłuszcz" />
                <display:column property="protein" title="Białko" />
                <display:column property="carbohydrates" title="Węglowodany" />
            </display:table>
        </div>
        
      <hr>

      <%@include file="../template/footer.jsp" %>
    </div> <!-- /container -->


    <%@include file="../template/bootstrap-footer.jsp" %>
  </body>
</html>
