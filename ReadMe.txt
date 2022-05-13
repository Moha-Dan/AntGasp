# SansGaspi
Une appication Spring(Java) pour lutter contre le gaspillage

Cette application vous invites a faire plus attention à votre consomation de produit.

Il y a deux acteurs pour cette application: l'utilisateur et le commercant.


Pour l'utilisateur, l'objectif est de pouvoir rechercher des paniers de produit parmis une liste et de pouvoir les commander.
Pour le commercant, l'intérêt et d'avoir un outil lui permettant de créer librement ses paniers de produit qu'il vend au consommateur.

website : http://localhost:8090/AntGasp/

Sur cette page vous trouverez un récapitulatif des paniers déjà entréer par le commercant.

Mais aussi la possibilité d'utilisé des méthodes de recherche pour trouver des paniers bien précis.

Si vous faites une recherche (en exemple, mettre le type en vitamine et prix maximal a 50) vous pourrez avoir une liste de panier avec un bouton pour commander celui que vous voulez.

Si vous faites cela vous vous retrouverez sur une page de connection. Pour les besoins de la démonstration les autentification sont désactivés.

Vous aurez une fois la connection établis un récapitulatif de vos commandes.


http://localhost:8090/AntGasp/admin/login

Ceci est la page de connection pour les administrateur. Pour les besoins de la démonstration les autentification sont désactivés.

http://localhost:8090/AntGasp/admin/dashboard

Une fois connecter.

Dans cette page vous trouverez des statistique utile sur les utilisateurs ainsi que les paniers passer

Vous pouver aussi ajouter un panier ou un commercant a la liste

http://localhost:8090/AntGasp/admin/panier

Un formulaire se trouve sur cette page vous demandant de remplir les champs utile à ça création.

Une base de donnée au forma sql est utiliser pour sauvegarder les données


Le css utiliser par haikuCSS. Ces un ensemble d'instruction se basant sur bootstrap.
