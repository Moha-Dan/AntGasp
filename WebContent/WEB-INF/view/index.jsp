<%@page import="com.fall.builder.ObjectBuilder"%>
<%@page import="java.util.List"%>
<%@page import="entities.Panier"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://mote.dyndns.biz/libs/haiku.js"></script>
</head>
<body template="market">
		<style>
			haiku-burger{
				width:3em;
				height:3em;
			}
			#navbar.open{
				display:flex;
			}
		</style>
	<nav>
		<ul  id="navbar" class="hide-sm list centred row" >
			<li>
				<a class="nav-item centred" href="login">Login</a>
			</li>
		</ul>
		<div class="list centred row" >
			<haiku-light class="nav-item centred" ></haiku-light>
			<haiku-burger class="hide-lg centred" menu="navbar" style="height: 3em;width: 3em;--dark: #333;"></haiku-burger>
		</div>
	</nav>
	<header>
	<haiku-searchpanel content="categories,commercant,prices" method="GET" action="search?want=panier">
		<ul class="categories-list" id="categories">
			<li>
	<haiku-searchpanel content="" method="POST" action="search?want=commerce">
		
	</haiku-searchpanel>
	</header>
	<main>
		<div class="col-6 centred-line col">
			<h2 class="centred">Decouvrez nos Paniers</h2>
			<% List<Panier> paniers = (List) request.getAttribute("paniers"); %>
			<% for(Panier panier : paniers){ %>
				<%= ObjectBuilder.buildGroup(panier,"centred row") %>
			<% } %>
		</div>
	</main>
</body>
</html>