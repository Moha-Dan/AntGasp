# SansGaspi
Une appication Spring(Java) pour lutter contre le gaspillage

Cette application vous invite a faire plus attention à votre consommation de produits.

Il y a deux acteurs pour cette application: l'utilisateur et le commerçant.


Pour l'utilisateur, l'objectif est de pouvoir rechercher des paniers de produit parmi une liste et de pouvoir les commander.
Pour le commerçant, l'intérêt est d'avoir un outil lui permettant de créer librement ses paniers de produit qu'il vend au consommateur.

website : http://localhost:8090/AntGasp/

Sur cette page vous trouverez un récapitulatif des paniers déjà entrés par le commerçant.

Mais aussi la possibilité d'utiliser des méthodes de recherche pour trouver des paniers bien précis.

Si vous faites une recherche (en exemple, mettre le type en vitamine et prix maximal a 50) vous pourrez avoir une liste de paniers avec un bouton pour commander celui que vous voulez.

Si vous faites cela vous vous retrouverez sur une page de connexion. Pour les besoins de la démonstration les autentifications sont désactivées.

Vous aurez une fois la connexion établit un récapitulatif de vos commandes.


http://localhost:8090/AntGasp/admin/login

Ceci est la page de connexion pour les administrateurs. Pour les besoins de la démonstration les autentifications sont désactivées.

http://localhost:8090/AntGasp/admin/dashboard

Une fois connecter.

Dans cette page vous trouverez des statistiques utiles sur les utilisateurs ainsi que les paniers passer

Vous pouvez aussi ajouter un panier ou un commerçant a la liste

http://localhost:8090/AntGasp/admin/panier

Un formulaire se trouve sur cette page vous demandant de remplir les champs utile à sa création.

Une base de données au forma Sql est utilisé pour sauvegarder les données


Le Css utilisé est géré par haikuCSS. C'est un ensemble d'instructions se basant sur bootstrap.


Tom TOUZE, Alexandre LEGAL et Bastian LEGUAY.
