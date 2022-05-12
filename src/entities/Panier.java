package entities;

import java.util.List;

import com.fall.persistence.Entity;
import com.fall.persistence.ParseClass;

import data.TypePanier;

/*
 *  idée d'object : https://www.potimarron.com/catalogue/primeur/panier-fruits-et-legumes
 */
@Entity
public class Panier {
	private String description;
	private String contenu;
	private String name;
	private TypePanier type;
	private int quantity;
	private float price;
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getContenu() {
		return contenu;
	}
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public TypePanier getType() {
		return type;
	}
	public void setType(TypePanier type) {
		this.type = type;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	@Override
		public String toString() {
			StringBuffer sb = new StringBuffer();
			List<String> fields = ParseClass.getProprietyNames(this);
			for(String field : fields) {
				sb.append(field);
				sb.append(" : ");
				sb.append(ParseClass.getPropriety(this, field));
			}
			return sb.toString();
		}
}
