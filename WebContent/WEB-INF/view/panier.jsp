<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fall" uri="/WEB-INF/fall.tld" %>
<!DOCTYPE html>
<html>
<head>
<script src="http://mote.dyndns.biz/libs/haiku.js"></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
${ paniers }
<form method="POST">
	<input type="hidden" hidden name="operation" value="ADD">
	<fall:form source="panier_group" />
	<div class="col-10 col-lg-6 centred col">
		<input class="btn outline col-6" type="submit">
	</div>
	
</form>
</body>
</html>