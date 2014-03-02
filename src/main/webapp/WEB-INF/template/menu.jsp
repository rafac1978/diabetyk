<%-- 
    Document   : menu
    Created on : 2014-02-24, 22:22:59
    Author     : Adrian Lapierre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page import="java.lang.String" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<% 
    String url = (String) request.getAttribute("javax.servlet.forward.request_uri");
    out.print(url);
    String[] arr = url.split("/", 3);
    pageContext.setAttribute("menu", arr[2]);
%>


<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Nawigacja</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="home">Diabetyk</a>
        </div>
        <ul class="nav navbar-nav">
<!--            <li class="active"><a href="home.htm">Home</a></li>-->
            <li <c:if test="${menu == 'list.htm'}">class="active"</c:if>><a href="list">Produkty</a></li>
            <sec:authorize ifAnyGranted="ROLE_MODERATOR,ROLE_ADMIN">
                <li <c:if test="${menu == 'product/add.htm'}">class="active"</c:if>><a href="product/add">Dodaj produkt</a></li>
            </sec:authorize>
            <li><a href="#about">O projekcie</a></li>
            <li><a href="#contact">Kontakt</a></li>
        </ul>
        <div class="navbar-collapse collapse">
        
        <sec:authorize access="isAnonymous()">
            
            <form class="navbar-form navbar-right" role="form" action='/diabetyk-web/j_spring_security_check' method='POST'>
                <div class="form-group">
                    <input type="text" placeholder="Email" class="form-control" name='j_username'>
                </div>
                <div class="form-group">
                    <input type="password" placeholder="Hasło" class="form-control" name='j_password'>
                </div>
                <button type="submit" class="btn btn-success">Zaloguj</button>
            </form>
        </sec:authorize>
        <sec:authorize access="isAuthenticated()">
            <div class="container">
                <ul class="navbar-right">
                    <li><a href="<c:url value="/logout" />">Logout</a></li>
                </ul>
            </div>
        </sec:authorize>
            
        </div><!--/.navbar-collapse -->
    </div>
</div>
