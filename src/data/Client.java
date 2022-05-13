package data;

import javax.servlet.http.HttpSession;

import entities.User;

public class Client {
	private User user;
	private HttpSession session;
	public Client(User e, HttpSession session2) {
		user = e;session = session2;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public HttpSession getSession() {
		return session;
	}
	public void setSession(HttpSession session) {
		this.session = session;
	}
	
}
