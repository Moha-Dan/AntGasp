package entities;

import com.fall.persistence.Entity;

@Entity
public class Commande {
	private User client;
	private Panier panier;
	public User getClient() {
		return client;
	}
	public void setClient(User client) {
		this.client = client;
	}
	public Panier getPanier() {
		return panier;
	}
	public void setPanier(Panier panier) {
		this.panier = panier;
	}
	
}
