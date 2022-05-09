package task;

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
}
