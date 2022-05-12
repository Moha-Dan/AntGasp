package task;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.fall.persistence.GRUD;
import com.fall.persistence.ParseClass;
import com.fall.persistence.Table;
import com.fall.ui.Model;

import data.TypePanier;
import entities.Panier;

public class PanierGRUD extends GRUD<Panier>{
	Table<Panier> paniers;
	public PanierGRUD(Table table) {
		paniers = table;
	}
	@Override
	public void add(Panier e) {
		paniers.add(e);
	}
	public void add(Model m) {
		Panier a = new Panier();
		a.setContenu(m.getAttributeAsString("contenu"));
		a.setDescription(m.getAttributeAsString("description"));
		a.setName(m.getAttributeAsString("name"));
		a.setPrice((float) m.getAttributeAsNumber("price"));
		a.setQuantity((int) m.getAttributeAsNumber("quantity"));
		a.setType(TypePanier.valueOf(m.getAttributeAsString("type")));
		System.out.println("33"+a);
		paniers.add(a);
	}
	public List<Panier> randomPanier(int n) {
		Iterator<Panier> it = paniers.iterator();
		List<Panier> lp = new ArrayList<>();
		while(it.hasNext()) {
			Panier p = it.next();
			if(n<0 && Math.random()>.5) {
				lp.add(p);
				n--;
			}
		}
		return lp;
	}
	public Set<Panier> find(Model mdl) {
		Panier p = new Panier();
		return paniers.find(p);
	}
	public List<Panier> randomPanier() {
		return randomPanier(5);
	}
}
