<%@page import="com.fall.builder.FormBuilder"%>
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
<c:forEach var="panier"  items="${paniers}" >
	 <div class="card centred col-10 col-lg-3 col-md-5 col">
            <h2>${ panier.name }</h2>
            <c:forEach var="elem"  items="${panier.list}" >
            	<p>${ elem }</p>
            </c:forEach>
            <h2>${ panier }</h2>
            <p class="text-start">${panier.prix}</p>
        </div>
</c:forEach>

<form method="POST">
	<input type="hidden" hidden name="operation" value="ADD">
	<fall:form source="panier_group" />
	<%= FormBuilder.buildGroup(request.getAttribute("panier_group")) %>
	<div class="col-10 col-lg-6 centred col">
		<input class="btn outline col-6" type="submit">
	</div>
	
</form>
</body>
</html>