package task;

import java.util.Collection;
import java.util.List;

import com.fall.persistence.GRUD;
import com.fall.persistence.Table;

import entities.Commercant;

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
}
