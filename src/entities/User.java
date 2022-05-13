package entities;

import com.fall.persistence.Entity;

import data.TypeRole;

@Entity
public class User {
	
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	private String username;
	private String password;
	private TypeRole role;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public TypeRole getRole() {
		return role;
	}
	public void setRole(TypeRole role) {
		this.role = role;
	}
	
}
