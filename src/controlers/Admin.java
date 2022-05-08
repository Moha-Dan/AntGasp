package controlers;

import com.fall.persistence.EntityManager;
import com.fall.stereotype.Controler;
import com.fall.ui.Model;
import com.fall.web.bind.annotation.Method;

@Controler("/admin")
public class Admin {
	EntityManager em = EntityManager.createInstance();
	@Method("/")
	public String index(Model mdl) {
		mdl.setAttribute("result", "cette page d'accueil admin");
		return "index.jsp";
	}
	
	@Method(value = "/invite",method = Method.GET)
	public String invite(Model mdl) {
		return "invite.jsp";
	}
	@Method(value = "/invite",method = Method.POST)
	public String invite_Form(Model mdl) {
		return "invite_view.jsp";
	}
	
	
	@Method("/stats")
	public String stats(Model mdl) {
		System.out.println();
		mdl.setAttribute("usernb", em.get("User").size());
		mdl.setAttribute("result", "cette page affiche les statisiques");
		return "stats.jsp";
	}

	@Method("/adere")
	public String adere(Model mdl) {
		mdl.setAttribute("result", "cette page est pour les adersion");
		return "stats.jsp";
	}
	
	
	@Method(value="/login",method = Method.GET)
	public String login(Model mdl) {
		mdl.setAttribute("result", "cette page est pour se connecter en admin");
		return "login.jsp";
	}
	@Method(value="/login",method = Method.POST)
	public String connect(Model mdl) {
		mdl.setAttribute("error", "il n'y a pas de system de connection");
		return "login.jsp";
	}
}
