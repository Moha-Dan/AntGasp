package task;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.fall.persistence.Table;

import entities.User;

public class Login {
	private List<HttpSession> online = new ArrayList<HttpSession>();
	//private Table<User> userTable;
	public Login(Table table) {
		//userTable = table;
	}
	public boolean connect(String username,String password, HttpSession session){
		boolean res = true;
		User e = new User(username,password);
		//res = userTable.find(e).size()>0;
		if(!res)return false;
		
		online.add(session);
		System.out.println(online);
		
		return res;
	}
	public boolean hasSession(HttpSession session) {
		System.out.println(session+" in "+online);
		return online.contains(session);
	}
	public void register(String username, String password) {
		// TODO Auto-generated method stub
		
	}
}
