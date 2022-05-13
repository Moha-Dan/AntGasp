<%@page import="com.fall.persistence.Table"%>
<%@page import="entities.Panier"%>
<%@page import="com.fall.builder.FormBuilder"%>
<%@page import="com.fall.builder.ObjectBuilder"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<script src="http://mote.dyndns.biz/libs/haiku.js"></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body template="classic">
<header>
	<%@include file="nav.jsp"%>
</header>
	<main class="row">
		<div class="col-6 centred-line col">
			<h2 class="centred">Paniers existant</h2>
			<% Table<Panier> paniers = (Table) request.getAttribute("paniers"); %>
			<% for(Panier panier : paniers){ %>
				<%= ObjectBuilder.buildGroup(panier,"centred row") %>
			<% } %>
		</div>
		<div class="col-6 centred-line col">
			<h2 class="centred-line">Ajouter un panier</h2>
			<form method="POST">
				<input type="hidden" hidden name="operation" value="ADD">
				<%= FormBuilder.buildGroup(request.getAttribute("panier_group"),"col-10 centred col") %>
				<div class="col-10 col-lg-6 centred col form-submit">
					<input class="btn outline col-6 form-submit" type="submit">
				</div>
			</form>
		</div>
	</main>
</body>
</html>