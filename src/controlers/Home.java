package controlers;

import java.util.Set;

import javax.servlet.http.HttpSession;

import com.fall.builder.ObjectBuilder;
import com.fall.persistence.EntityManager;
import com.fall.stereotype.Controler;
import com.fall.ui.Model;
import com.fall.web.bind.annotation.Method;

import entities.Panier;
import task.CommercantGRUD;
import task.Login;
import task.PanierGRUD;

@Controler("/")
public class Home {
	EntityManager em = EntityManager.createInstance();
	Login login = new Login(em.get("User"));
	PanierGRUD paniers = new PanierGRUD(em.get("Panier"));
	CommercantGRUD commerce = new CommercantGRUD(em.get("Commercant"));
	@Method("/")
	public String index(Model mdl) {
		mdl.setAttribute("paniers", paniers.randomPanier());
		return "index.jsp";
	}
	@Method(value="/search")
	public String panier_commercant(Model mdl) {
		String want = mdl.getAttributeAsString("want");
		if(want!=null && "commerce".equals(want)){
			mdl.setAttribute("choices", commerce.find(mdl));
		}else {
			Set<Panier> choices = paniers.find(mdl);
			StringBuffer sb = new StringBuffer();
			for(Panier choice : choices){
				sb.append(ObjectBuilder.buildGroup(choice));
			}
			mdl.setAttribute("choices",sb.toString());
		}
		return "search.jsp";
	}
	@Method(value="/login",method = Method.GET)
	public String login(Model mdl) {
		HttpSession session = mdl.getRequest().getSession(false);
		if(login.hasSession(session))
			return "redirect:dashboard";
		return "client.jsp";
	}
	
	@Method(value="/login",method = Method.POST)
	public String connect(Model mdl) {
		String username = mdl.getAttributeAsString("userName");
		String password =  mdl.getAttributeAsString("password");
		HttpSession session = mdl.getRequest().getSession(true);
		if(!login.connect(username,password,session) ){
			mdl.setAttribute("error", "il n'y a pas de system de connection");
			return "client.jsp";	
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
			return "client.jsp";	
		}else {
			return "redirect:index";
		}
	}
}
