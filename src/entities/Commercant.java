package entities;

import com.fall.persistence.Entity;

@Entity
public class Commercant {
	private Long id;
	public Commercant(String nomCommercial, String adresse, String cp, String ville, String email, String tel,
			String website, String facebook, String instagram, Schedule week) {
		super();
		this.nomCommercial = nomCommercial;
		this.adresse = adresse;
		this.cp = cp;
		this.ville = ville;
		this.email = email;
		this.tel = tel;
		this.website = website;
		this.facebook = facebook;
		this.instagram = instagram;
		this.week = week;
	}
	public Commercant(String nomCommercial, String adresse, String cp, String ville, String email, String tel,
			String website, String facebook, String instagram, String open,String close) {
		super();
		this.nomCommercial = nomCommercial;
		this.adresse = adresse;
		this.cp = cp;
		this.ville = ville;
		this.email = email;
		this.tel = tel;
		this.website = website;
		this.facebook = facebook;
		this.instagram = instagram;
		this.week = new Schedule(open,close);
	}
	
	private String nomCommercial;
	private String adresse,cp,ville,email,tel;
	private String website;
	private String facebook,instagram;
	
	private Schedule week;
	public String getNomCommercial() {
		return nomCommercial;
	}
	public void setNomCommercial(String nomCommercial) {
		this.nomCommercial = nomCommercial;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getCp() {
		return cp;
	}
	public void setCp(String cp) {
		this.cp = cp;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getFacebook() {
		return facebook;
	}
	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}
	public String getInstagram() {
		return instagram;
	}
	public void setInstagram(String instagram) {
		this.instagram = instagram;
	}
	public Schedule getWeek() {
		return week;
	}
	public void setWeek(Schedule week) {
		this.week = week;
	}
	
}
