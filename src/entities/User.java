package entities;

import web.Entity;

@Entity
public class User {
	
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	public String username;
	private String password;
}
