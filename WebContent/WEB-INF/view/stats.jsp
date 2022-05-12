<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="./style.css" />
<script src="http://mote.dyndns.biz/libs/haiku.js"></script>
</head>
<body template>
<div class="card centred col-10 col-lg-3 col-md-5 col">
	${ result }
	<p> Nombre utilisaeur : ${ usernb }</p>
	<p> Nombre Panier : ${ paniernb }</p>
	<p> Nombre Commercant : ${ commercantnb }</p>
</div>
	<h2 class="centred">Paniers</h2>
	<div class="col">${ Panier }</div>
</body>
</html>