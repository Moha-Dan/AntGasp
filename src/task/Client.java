package task;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import com.fall.persistence.Table;

import entities.Commande;
import entities.Panier;
import entities.User;

public class Client {
	Table<Commande> commandes; 
	public Client(Table table) {
		commandes = table;
	}

	public String createButton(Panier btnfor, String action) {
		StringBuffer sb = new StringBuffer();
		String uuid = btnfor.getUuid().toString();
		sb.append("<form method=\"POST\" action=\""+action+"\">");
		sb.append("<input type=\"hidden\" hidden name=\"panier\" value=\""+uuid+"\" >");
		sb.append("<input type=\"submit\" class=\"btn\" name=\"submit\" value=\"Commander\" >");
		sb.append("</form>");
		return sb.toString();
	}

	public List<Panier> getPaniers(entities.User user) {
		List<Panier> lp = new ArrayList();
		Iterator<Commande> it = commandes.iterator();
		while(it.hasNext()) {
			Commande c = it.next();
			if(c.getClient().equals(user)) {
				Panier p = c.getPanier();
				lp.add(p);
			}
		}
		return lp;
	}
	public void order(User u, Panier p) {
		System.out.println("buy panier :"+p);
		if(u!=null && p!=null) {
			Commande c = new Commande();
			c.setClient(u);
			c.setPanier(p);
			commandes.add(c);
		}
	}
	
}
