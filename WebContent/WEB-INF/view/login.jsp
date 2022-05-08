<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form name="login" method="POST">
			<div style="color: red">${error}</div>
			<label>User Name</label>
			<input type="text" name="userName" />
			<label>Password</label>
			<input type="password" name="password" />
			<input type="submit" value="Submit" />
		</form>
</body>
</html>