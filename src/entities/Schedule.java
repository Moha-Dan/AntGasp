package entities;

import com.fall.persistence.Entity;

@Entity
public class Schedule {
	private Long id;
	public Schedule(String open, String close) {
		ouverture = open;
		fermeture = close;
	}
	
	private String ouverture;
	private String fermeture;
	public String getOuverture() {
		return ouverture;
	}
	public void setOuverture(String ouverture) {
		this.ouverture = ouverture;
	}
	public String getFermeture() {
		return fermeture;
	}
	public void setFermeture(String fermeture) {
		this.fermeture = fermeture;
	}
}
