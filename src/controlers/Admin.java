package controlers;

import java.util.Iterator;
import java.util.Set;

import javax.servlet.http.HttpSession;

import com.fall.builder.FormBuilder;
import com.fall.builder.ObjectBuilder;
import com.fall.persistence.EntityManager;
import com.fall.persistence.Table;
import com.fall.stereotype.Controler;
import com.fall.ui.Model;
import com.fall.web.bind.annotation.Method;

import entities.Commercant;
import entities.Panier;
import task.CommercantGRUD;
import task.Login;
import task.PanierGRUD;

@Controler("/admin")
public class Admin {
	EntityManager em = EntityManager.createInstance();
	Login login = new Login(em.get("User"));
	PanierGRUD panier = new PanierGRUD(em.get("Panier"));
	CommercantGRUD commerncant = new CommercantGRUD(em.get("Commercant"));
	@Method("/")
	public String index(Model mdl) {
		return "redirect:login";
	}
	
	@Method(value = "/invite",method = Method.GET)
	public String invite(Model mdl) {
		return "invite.jsp";
	}
	@Method(value = "/invite",method = Method.POST)
	public String inviteForm(Model mdl) {
		String nomCommercial = mdl.getAttributeAsString("nomCommercial"); 
		String adresse = mdl.getAttributeAsString("adresse");
		String ville = mdl.getAttributeAsString("ville");
		String cp = mdl.getAttributeAsString("cp");
		String email = mdl.getAttributeAsString("email");
		String tel = mdl.getAttributeAsString("tel");
		String siteweb = mdl.getAttributeAsString("siteweb"); 
		String facebook = mdl.getAttributeAsString("facebook"); 
		String instagram = mdl.getAttributeAsString("instagram"); 
		String open = mdl.getAttributeAsString("open");
		String close = mdl.getAttributeAsString("close");
		
		Commercant c = new Commercant(nomCommercial,adresse,cp,ville,email,tel,siteweb,facebook,instagram,open,close);
		commerncant.add(c);
		return "invite_view.jsp";
	}
	
	
	@Method("/stats")
	public String stats(Model mdl) {
		HttpSession session = mdl.getRequest().getSession(false);
		if(!login.hasSession(session))
			return "redirect:login";
		Set<String> tables = em.getTables();
		for(String table : tables) {
			Table<?> t = em.get(table);
			Iterator<?> it = t.iterator();
			StringBuffer sb = new StringBuffer();
			while(it.hasNext()) {
				Object obj = it.next();
				sb.append(ObjectBuilder.buildGroup(obj));
			}
			mdl.setAttribute(table, sb.toString());
		}
		mdl.setAttribute("usernb", em.get("User").size());
		mdl.setAttribute("paniernb", em.get("Panier").size());
		mdl.setAttribute("commercantnb", em.get("Commercant").size());
		mdl.setAttribute("result", "cette page affiche les statisiques");
		return "stats.jsp";
	}
	
	@Method(value="/panier",method = Method.GET)
	public String panier(Model mdl) {
		HttpSession session = mdl.getRequest().getSession(false);
		if(!login.hasSession(session))
			return "redirect:login";
		mdl.setAttribute("paniers", em.get("Panier"));
		mdl.setAttribute("panier_group", new Panier());
		return "panier.jsp";
	}
	@Method(value="/panier",method = Method.POST)
	public String panierQuery(Model mdl) {
		HttpSession session = mdl.getRequest().getSession(false);
		if(!login.hasSession(session))
			return "redirect:login";
		String operation = mdl.getAttributeAsString("operation");
		
		System.out.println(operation);
		switch(operation) {
			case "ADD":
				panier.add(mdl);
				break;
			case "DELETE":
				String[] ids = (String[]) mdl.getAttribute("ids");
				for(String id : ids) {
					panier.delete(Integer.parseInt(id));
				}
				break;
		}
		mdl.setAttribute("paniers", em.get("Panier"));
		mdl.setAttribute("panier_group", new Panier());
		return "panier.jsp";
	}
	
	@Method("/dashboard")
	public String dashboard(Model mdl) {
		HttpSession session = mdl.getRequest().getSession(false);
		if(!login.hasSession(session))
			return "redirect:login";
		return "dashboard.jsp";
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
}
