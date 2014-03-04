<%-- 
    Document   : add-product
    Created on : 2014-02-26, 22:01:32
    Author     : Adrian Lapierre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="pl">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="shortcut icon" href="resources/i/Diabetes_icon.png">

        <title>Diabetyk Portal</title>

        <base href="${pageContext.request.contextPath}/">

        <%@include file="../template/bootstrap.jsp" %>
        
        <style>
            td { 
                padding: 5px;
                vertical-align: top;
            }
            .error {
                color: red;
            }
        </style>
    </head>

    <body>

        <%@include file="../template/menu.jsp" %>

        <!-- Main jumbotron for a primary marketing message or call to action -->

        <div class="container">
            <div class="jumbotron">
                
                <h2>Dodawanie produktu</h2>
                
                <form:form commandName="product">
                    <table >
                        <tr>
                            <td></td>
                            <td><form:errors path="name" cssClass="error"/></td>
                        </tr>
                        <tr>
                            <td >Nazwa*: </td>
                            <td><form:input path="name" size="64"/></td>
                        </tr>
                        
                        <tr>
                            <td></td>
                            <td><form:errors path="description" cssClass="error"/></td>
                        </tr>
                        <tr>
                            <td>Opis: </td>
                            <td><form:input path="description" size="64"/></td>
                        </tr>
                        
                        <tr>
                            <td></td>
                            <td><form:errors path="fat" cssClass="error"/></td>
                        </tr>
                        <tr>
                            <td>Tłuszcz: </td>
                            <td><form:input path="fat"/></td>
                        </tr>
                        
                        <tr>
                            <td></td>
                            <td><form:errors path="protein" cssClass="error"/></td>
                        </tr>
                        <tr>
                            <td>Białko: </td>
                            <td><form:input path="protein"/></td>
                        </tr>
                        
                        <tr>
                            <td></td>
                            <td><form:errors path="carbohydrates" cssClass="error"/></td>
                        </tr>
                        <tr>
                            <td>Węglowodany: </td>
                            <td><form:input path="carbohydrates" /></td>
                        </tr>
                        
                        <tr>
                            <td></td>
                            <td><form:errors path="homeMeasure" cssClass="error"/></td>
                        </tr>
                        <tr>
                            <td>Porcja: </td>
                            <td> <form:input path="homeMeasure" size="64"/></td>
                        </tr>
                        
                        <tr>
                            <td></td>
                            <td><form:errors path="wwInPortion" cssClass="error"/></td>
                        </tr>
                        <tr>
                            <td>WW w porcji: </td>
                            <td><form:input path="wwInPortion" size="64"/></td>
                        </tr>
                        
                        <tr>
                            <td></td>
                            <td><form:errors path="categories" cssClass="error"/></td>
                        </tr>
                        <tr>
                            <td>Kategoria: </td>
                            <td><form:select path="categories" multiple="true" items="${categories}" itemLabel="name" itemValue="id" cssStyle="width: 300px"/></td>
                        </tr>
                        
                    </table>
                    <button type="submit" class="btn btn-success">Zapisz</button>
                    <button type="button" class="btn btn-danger" onclick="window.location.href='<c:url value="/list"/>'">Anuluj</button>
                    
                </form:form>
                
            </div>
            <%@include file="../template/footer.jsp" %>
        </div>


        
        <%@include file="../template/bootstrap-footer.jsp" %>
    </body>
</html>