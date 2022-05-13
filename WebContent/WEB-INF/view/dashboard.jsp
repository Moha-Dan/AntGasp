<%@page import="com.fall.builder.ObjectBuilder"%>
<%@page import="entities.Panier"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DashBoard</title>
<script src="http://mote.dyndns.biz/libs/haiku.js"></script>
</head>
<body>
	<main>
		<%= ObjectBuilder.buildGroup(request.getAttribute("userinfo"),"col-6 centred-line row") %>
		<div class="col-6 centred-line col">
			<h2 class="centred">Decouvrez nos Paniers</h2>
			<% List<Panier> paniers = (List) request.getAttribute("userpanier"); %>
			<% for(Panier panier : paniers){ %>
				<%= ObjectBuilder.buildGroup(panier,"centred row") %>
			<% } %>
		</div>
	</main>
</html>