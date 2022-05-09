<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
${ paniers }
<form method="POST">
	<input type="hidden" hidden name="operation" value="ADD">
	<label>Categorie</label>
	<select>
		<option>Repas</option>
		<option>Perimer</option>
	</select>
	<input type="submit">
</form>
</body>
</html>