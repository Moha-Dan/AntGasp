<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Sans GasPI| invitation</title>
<link rel="stylesheet" href="./style.css" />
<script src="http://mote.dyndns.biz/libs/haiku.js"></script>
</head>
<body template="market">
	<haiku-form method="post" action="invite">
		<fieldset>
			<h2>Commerce</h2>
			<h3>Page 1/4</h3>
			<input type="text" name="nomCommercial" placeholder="Nom Commercial" />
			<input type="text" name="adresse" placeholder="Adresse" />
			<input type="text" name="ville" placeholder="Ville" />
			<input type="text" name="cp" placeholder="Code Postal" />
			<input type="button" class="next action-button" value="Suivant" name="next"/>
		</fieldset>
		<fieldset>
			<h2>Informations Contact</h2>
			<h3>Page 2/4</h3>
			<input type="email" name="email" placeholder="Email" />
			<input type="tel" name="tel" placeholder="Telephone" />
			<input type="url" name="siteweb" placeholder="Site Web" />
			<input type="button" class="previous action-button" value="Precedant" name="previous"/>
			<input type="button" class="next action-button" value="Suivant" name="next"/>
		</fieldset>
		<fieldset>
			<h2>Réseaux</h2>
			<h3>Page 3/4</h3>
			<input type="text" name="facebook" placeholder="facebook" />
			<input type="text" name="instagram" placeholder="instagram" />
			<input type="button" class="previous action-button" value="Precedant" name="previous"/>
			<input type="button" class="next action-button" value="Suivant" name="next"/>
		</fieldset>
		<fieldset>
			<h2>Horaires</h2>
			<h3>Page 4/4</h3>
			<div class="group-input">
						<label>heure d'ouverture</label>
						<input type="time" name="open" placeholder="heure d'ouverture" value="09:00"/>
					</div>
					<div class="group-input">
						<label>heure de fermeture</label>
						<input type="time" name="close" placeholder="heure de fermeture" value="18:00"/>
					</div>
			<input type="button" class="previous action-button" value="Precedant" name="previous"/>
			<input type="submit" name="send" class="submit action-button" value="Submit" />
		</fieldset>
	</haiku-form>
</body>
</html>