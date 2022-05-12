<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<script src="http://mote.dyndns.biz/libs/haiku.js"></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:forEach var="panier"  items="${requestScope['paniers']}" >
	<div class="card centred">
	${ panier.nom }
	</div>
</c:forEach>

<form method="POST">
	<input type="hidden" hidden name="operation" value="ADD">
	${ panier_group }
	<div class="col-10 col-lg-6 centred col">
		<input class="btn outline col-6" type="submit">
	</div>
	
</form>
</body>
</html>