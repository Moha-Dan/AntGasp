package entities;

import java.util.List;
import java.util.UUID;

import com.fall.persistence.Entity;
import com.fall.persistence.Id;
import com.fall.persistence.ParseClass;

import data.TypePanier;

/*
 *  idée d'object : https://www.potimarron.com/catalogue/primeur/panier-fruits-et-legumes
 */
@Entity
public class Panier {
	@Id
	private UUID uuid = UUID.randomUUID();
	public UUID getUuid() {
		return uuid;
	}
	public Panier(String description, String contenu, String name, TypePanier type, int quantity, float price) {
		super();
		this.description = description;
		this.contenu = contenu;
		this.name = name;
		this.type = type;
		this.quantity = quantity;
		this.price = price;
	}
	public Panier() {
	}
	private String description;
	private String contenu;
	private String name;
	private TypePanier type;
	private Integer quantity;
	private Float price;
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
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Float getPrice() {
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
				sb.append(" \n");
			}
			return sb.toString();
		}
}
