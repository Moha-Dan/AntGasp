package controlers;

import javax.servlet.http.HttpSession;

import com.fall.persistence.EntityManager;
import com.fall.stereotype.Controler;
import com.fall.ui.Model;
import com.fall.web.bind.annotation.Method;

import task.Login;

@Controler("/")
public class Home {
	EntityManager em = EntityManager.createInstance();
	Login login = new Login(em.get("User"));
	
	@Method("/")
	public String index(Model mdl) {
		return "index.jsp";
	}
	@Method("/search")
	public String panier_commercant(Model mdl) {
		return "index.jsp";
	}
	@Method(value="/login",method = Method.GET)
	public String login(Model mdl) {
		HttpSession session = mdl.getRequest().getSession(false);
		if(login.hasSession(session))
			return "redirect:dashboard";
		return "login.jsp";
	}
	
	@Method(value="/login",method = Method.POST)
	public String connect(Model mdl) {
		String username = mdl.getAttributeAsString("userName");
		String password =  mdl.getAttributeAsString("password");
		HttpSession session = mdl.getRequest().getSession(true);
		if(!login.connect(username,password,session) ){
			mdl.setAttribute("error", "il n'y a pas de system de connection");
			return "login.jsp";	
		}else {
			return "redirect:dashboard";
		}
	}
	
	@Method(value="/register",method = Method.POST)
	public String register(Model mdl) {
		String username = mdl.getAttributeAsString("userName");
		String password =  mdl.getAttributeAsString("password");
		login.register(username,password);
		HttpSession session = mdl.getRequest().getSession(true);
		if(!login.connect(username,password,session) ){
			mdl.setAttribute("error", "il n'y a pas de system de connection");
			return "login.jsp";	
		}else {
			return "redirect:index";
		}
	}
}
