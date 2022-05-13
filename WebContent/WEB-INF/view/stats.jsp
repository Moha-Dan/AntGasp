<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
	<%@page import="com.fall.persistence.Table"%>
	<%@page import="entities.Panier"%>
	<%@page import="com.fall.builder.FormBuilder"%>
	<%@page import="com.fall.builder.ObjectBuilder"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="./style.css" />
<script src="http://mote.dyndns.biz/libs/haiku.js"></script>
</head>	
<body template class="col">
<header>
	<%@include file="nav.jsp"%>
</header>

<div class="card centred col-10 col-lg-3 col-md-5 col">
	${ result }
	<p> Nombre utilisaeur : ${ usernb }</p>
	<p> Nombre Panier : ${ paniernb }</p>
	<p> Nombre Commercant : ${ commercantnb }</p>
</div>
<div class="centred">
	<a href="panier">Ajouter un panier</a>
	<a href="invite">Ajouter un commercant</a>
</div>
	<h2 class="centred">Paniers</h2>
	<div class="col">${ Panier }</div>
	<h2 class="centred">Commandes</h2>
	<div class="col">${ Commande }</div>
	<h2 class="centred">Utilisateurs</h2>
	<div class="col">${ User }</div>
	<h2 class="centred">Commercants</h2>
	<div class="col">${ Commercant }</div>
</body>
</html>