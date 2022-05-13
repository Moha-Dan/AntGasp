<%@page import="com.fall.builder.FormBuilder"%>
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
	<%@include file="nav.jsp"%>
	<header class="clean-block" style="color:#2222;">
	<div class="col-12">
		<haiku-searchpanel content="panier,commercant" method="GET" action="search?want=panier">
		<div id="panier" name="panier" class="clean-form form">
			<%= FormBuilder.buildPropriety(new Panier(),"type") %>
			<label>Devise</label>
		<select>
			<option>€</option>
			<option>$</option>
		</select>
		<label>Prix visé</label>
		<input type="number" name="pricemin" value="5" min="5" max="100" onchange="var v = this.parentElement.querySelector('input[name=pricemax]');v.min=this.value;if(~~(v.value)<~~(v.min))v.value = this.value">
		<label>Prix Maximal</label>
		<input type="number" name="pricemax" value="5" min="5" max="100">
		</div>
		<div id="commercant" name="commercant" class="clean-form form">
			<input type="text" name="nomCommercial" placeholder="Nom Commercial" />
			<input type="text" name="adresse" placeholder="Adresse" />
			<input type="text" name="ville" placeholder="Ville" />
			<input type="text" name="cp" placeholder="Code Postal" />
			<input type="button" class="next action-button" value="Suivant" name="next"/>
		</div>v>
	</haiku-searchpanel>
	<haiku-searchpanel content="commercant" method="GET" action="search?want=commerce">
		<div id="commercant" name="commercant" class="clean-form form">
			<input type="hidden" hidden name="want" value="commerce" />
			<input type="text" name="nomCommercial" placeholder="Nom Commercial" />
			<input type="text" name="adresse" placeholder="Adresse" />
			<input type="text" name="ville" placeholder="Ville" />
			<input type="text" name="cp" placeholder="Code Postal" />
		</div>
	</haiku-searchpanel>

	</div>
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