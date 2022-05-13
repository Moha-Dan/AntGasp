package task;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.fall.persistence.Table;

import data.Client;
import data.TypeRole;
import entities.User;

public class Login {
	private List<Client> online = new ArrayList<Client>();
	private Table<User> userTable;
	public Login(Table table) {
		userTable = table;
	}
	public boolean Adminconnect(String username,String password, HttpSession session){
		boolean res = true;
		User e = new User(username,password);
		e.setRole(TypeRole.Admin);
		//res = userTable.find(e).size()>0;
		if(!res)return false;
		Client c = new Client(e,session);
		online.add(c);
		System.out.println(online);
		
		return res;
	}
	public boolean connect(String username,String password, HttpSession session){
		boolean res = true;
		User e = new User(username,password);
		//res = userTable.find(e).size()>0;
		if(!res)return false;
		Client c = new Client(e,session);
		online.add(c);
		System.out.println(online);
		
		return res;
	}
	public boolean hasSession(HttpSession session) {
		System.out.println(session+" in "+online);
		return online.stream().filter((Client c)->{
			return c.getSession().equals(session);
		}).distinct().count() != 0;
	}
	public void register(String username, String password) {
		
	}
	public User userInfo(HttpSession session) {
		return online.stream().filter((Client c)->{
			return c.getSession().equals(session);
		}).distinct().findFirst().get().getUser();
	}
}
