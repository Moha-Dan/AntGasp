package com.fall.boot;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.http.HttpRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.reflections.Reflections;
import com.fall.ui.Model;
import com.fall.persistence.EntityManager;
import com.fall.stereotype.Controler;

/**
 * Servlet implementation class ServletManager
 */
@WebServlet("/")
public class ServletManager extends HttpServlet {
	private static EntityManager em = EntityManager.createInstance();
	private static Reflections reflections = new Reflections("controlers");
	private HashMap<String, Object> controlers = new HashMap<String, Object>();
	private String errorPage = null;
	
	private static final long serialVersionUID = 1L;
	/**
	 * @param mdl 
	 * @param url 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	private String matcher(HttpServletRequest request,Model mdl) {
		String url = request.getRequestURI();
		url = url.replaceFirst("/[^/]*", "");
		String method = request.getMethod();
		Set<Class<?>> controlers = reflections.getTypesAnnotatedWith(Controler.class);
		
		StringBuffer logs = new StringBuffer();
		logs.append(url+"\n");
		logs.append(method+"\n");
		
		String view = errorPage;
		String lastChoice = "";
		for(Class<?> controler : controlers) {
			Controler c = controler.getAnnotation(Controler.class);
			if(c!=null) {
				String value = c.value();
				logs.append(value+"\n");
				if(url.startsWith(value)) {
					logs.append("URL : "+url+";Controler : "+value);
					for (Method method_controler : controler.getDeclaredMethods()) {
			            if (method_controler.isAnnotationPresent(com.fall.web.bind.annotation.Method.class)) {
			                method_controler.setAccessible(true);
			                com.fall.web.bind.annotation.Method mt = method_controler.getAnnotation(com.fall.web.bind.annotation.Method.class);
			                logs.append(value+mt.value()+"\n");
			                logs.append(mt.method()+"\n");
			                String page = (value+mt.value()).replaceAll("//", "/");
			                logs.append("URL : "+url+";Page : "+page);
			                if(method.equals(mt.method()) && url.startsWith(page) && page.length()>lastChoice.length()) {
			                	lastChoice = page;
			                	try {
			                		Object control_obj = this.controlers.get(value);
			                		if(control_obj==null) {
			                			control_obj = controler.getConstructor().newInstance();
			                			this.controlers.put(value,control_obj);
			                		}
			                		view = (String) method_controler.invoke(control_obj,mdl);
								} catch (IllegalAccessException | IllegalArgumentException
										| InvocationTargetException | InstantiationException | NoSuchMethodException | SecurityException e) {
									e.printStackTrace();
								}
			                }
			            }
			        }
				}
			}
		}
		System.out.println(view);
		return view;
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getRequestURI());
		Model mdl = new ConcretModel(request);
		Map<String, String[]> rmp = request.getParameterMap();

		for( String parm : rmp.keySet()) {
			mdl.setAttribute(parm, rmp.get(parm));
		}
		
		String view = matcher(request, mdl);

		if(view==null) return;
		
		if(!view.startsWith("redirect:")) {
			request.getRequestDispatcher("/WEB-INF/view/"+view).forward(request, response);
			return;
		}else {			
			String url = view.replaceFirst("redirect:", "");
			response.sendRedirect(url);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Model mdl = new ConcretModel(request);
		Map<String, String[]> rmp = request.getParameterMap();

		for( String parm : rmp.keySet()) {
			mdl.setAttribute(parm, rmp.get(parm));
		}
		
		String view = matcher(request, mdl);
		
		if(view==null) return;
		
		if(!view.startsWith("redirect:")) {
			request.getRequestDispatcher("/WEB-INF/view/"+view).forward(request, response);
			return;
		}else {			
			String url = view.replaceFirst("redirect:", "");
			response.sendRedirect(url);
		}
	}
	private class ConcretModel implements Model{
		private HttpServletRequest request;
		ConcretModel (HttpServletRequest request){
			this.request = request;
		}
		@Override
		public Object getAttribute(String name) {
			return request.getAttribute(name);
		}

		@Override
		public void setAttribute(String name, Object value) {
			request.setAttribute(name,value);
		}

		@Override
		public Object removeAttribute(String name) {
			Object value = request.getAttribute(name);
			request.removeAttribute(name);
			return value;
		}

		@Override
		public Enumeration<String> getAttributeNames() {
			return request.getAttributeNames();
		}
		@Override
		public String getAttributeAsString(String name) {
			Object obj = request.getAttribute(name);
			if(obj==null)return null;
			try {
				String[] strs = (String[]) obj;				
				return strs[0];
			}catch(Exception e){
				return null;
			}
		}
		@Override
		public HttpServletRequest getRequest() {
			return (HttpServletRequest) request;
		}
		@Override
		public double getAttributeAsNumber(String string) {
			String str = getAttributeAsString(string);
			Double d = Double.parseDouble(str);
			return d;
		}
		@Override
		public boolean hasAttribute(String string) {
			return getAttribute(string)!=null;
		}
		
	}

}
