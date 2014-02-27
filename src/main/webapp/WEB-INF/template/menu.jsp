<%-- 
    Document   : menu
    Created on : 2014-02-24, 22:22:59
    Author     : Adrian Lapierre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Nawigacja</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="home.htm">Diabetyk</a>
        </div>
        <ul class="nav navbar-nav">
<!--            <li class="active"><a href="home.htm">Home</a></li>-->
            <li><a href="list.htm">Produkry</a></li>
            <li><a href="product/add.htm">Dodaj produkt</a></li>
            <li><a href="#about">O projekcie</a></li>
            <li><a href="#contact">Kontakt</a></li>
        </ul>
        <div class="navbar-collapse collapse">
            <form class="navbar-form navbar-right" role="form">
                <div class="form-group">
                    <input type="text" placeholder="Email" class="form-control">
                </div>
                <div class="form-group">
                    <input type="password" placeholder="Hasło" class="form-control">
                </div>
                <button type="submit" class="btn btn-success">Zaloguj</button>
            </form>
        </div><!--/.navbar-collapse -->
    </div>
</div>
