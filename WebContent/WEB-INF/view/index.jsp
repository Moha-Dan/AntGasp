<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://mote.dyndns.biz/libs/haiku.js"></script>
</head>
<body>
<a href="login">Login</a>
	<haiku-searchpanel content="categories,commercant,prices" method="GET" action="search">
		<ul class="categories-list" id="categories">
			<li>
				<input type="button" class="card" value="Graphisme &amp; Design" >
			</li>
			<li>
				<input type="button" class="card" value="Vidéo &amp; Animation" >
			</li>
			<li>
				<input type="button" class="card" value="Programmation" >
			</li>
			<li>
				<input type="button" class="card" value="Gestion" >
			</li>
			<li>
				<input type="button" class="card" value="Serveur" >
			</li>
		</ul>
		<div id="commercant" name="commercant" class="clean-form form">
			<input type="text" name="nomCommercial" placeholder="Nom Commercial" />
			<input type="text" name="adresse" placeholder="Adresse" />
			<input type="text" name="ville" placeholder="Ville" />
			<input type="text" name="cp" placeholder="Code Postal" />
			<input type="button" class="next action-button" value="Suivant" name="next"/>
		</div>
		<div id="prices" class="clean-form form">
		<label>Devise</label>
		<select>
			<option>€</option>
			<option>$</option>
		</select>
		<label>Prix visé</label>
		<input type="number" name="Art-price" value="5" min="5" max="100" onchange="var v = this.parentElement.querySelector('input[name=pricemax]');v.min=this.value;if(~~(v.value)<~~(v.min))v.value = this.value">
		<label>Prix Maximal</label>
		<input type="number" name="Art-pricemax" value="5" min="5" max="100">
	</div>
	</haiku-searchpanel>
	<haiku-searchpanel content="" method="POST" action="search">
		
	</haiku-searchpanel>
</body>
</html>