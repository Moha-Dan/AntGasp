package task;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import com.fall.persistence.GRUD;
import com.fall.persistence.Table;
import com.fall.ui.Model;

import entities.Commercant;
import entities.Panier;

public class CommercantGRUD extends GRUD<Commercant>{
	Table<Commercant> commercant;
	public CommercantGRUD(Table table) {
		commercant = table;
	}
	@Override
	public void add(Commercant e) {
		commercant.add(e);
	}
	public Collection<Commercant> filtreByCategory(String cat){
		Commercant c = new Commercant();
		c.setCategory(cat);
		return commercant.find(c);
	}
	public Collection<Commercant> filtreByLocation(String adress,String ville,String CP){
		Commercant c = new Commercant();
		c.setVille(ville);
		c.setAdresse(adress);
		c.setCp(CP);
		return commercant.find(c);
	}
	public Set<Commercant> find(Model mdl) {
		Commercant c = new Commercant();
		return filtre(c);
	}
	public Set<Commercant> filtre(Commercant c){
		return commercant.find(c);
	}
}
