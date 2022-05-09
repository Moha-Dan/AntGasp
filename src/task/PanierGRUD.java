package task;

import com.fall.persistence.GRUD;
import com.fall.persistence.Table;

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
}