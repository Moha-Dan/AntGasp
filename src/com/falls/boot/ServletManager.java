package com.falls.boot;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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
import com.falls.ui.Model;
import com.falls.persistence.EntityManager;
import com.falls.stereotype.Controler;

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
		System.out.println(url);
		url = url.replaceFirst("/[^/]*", "");
		String method = request.getMethod();
		Set<Class<?>> controlers = reflections.getTypesAnnotatedWith(Controler.class);
		
		StringBuffer logs = new StringBuffer();
		logs.append(url+"\n");
		logs.append(method+"\n");
		
		String view = errorPage;
		for(Class<?> controler : controlers) {
			Controler c = controler.getAnnotation(Controler.class);
			if(c!=null) {
				String value = c.value();
				logs.append(value+"\n");
				if(url.startsWith(value)) {
					for (Method method_controler : controler.getDeclaredMethods()) {
			            if (method_controler.isAnnotationPresent(com.falls.web.bind.annotation.Method.class)) {
			                method_controler.setAccessible(true);
			                com.falls.web.bind.annotation.Method mt = method_controler.getAnnotation(com.falls.web.bind.annotation.Method.class);
			                logs.append(value+mt.value()+"\n");
			                logs.append(mt.method()+"\n");
			                System.out.println(">>" + (method.equals(mt.method())) +" && "+ (url.startsWith(value+mt.value())));
			                if(method.equals(mt.method()) && url.startsWith(value+mt.value())) {
			                	try {
			                		Object control_obj = this.controlers.get(method_controler.getName());
			                		if(control_obj==null) {
			                			control_obj = controler.getConstructor().newInstance();
			                			this.controlers.put(method_controler.getName(),control_obj);
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
			//System.out.println(logs);
		return view;
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getRequestURI());
		Model mdl = new ConcretModel(request);

		String view = matcher(request, mdl);
		
		
		if(view!=null)
			request.getRequestDispatcher("/WEB-INF/view/"+view).forward(request, response);
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
		
		
		if(view!=null)
			request.getRequestDispatcher("/WEB-INF/view/"+view).forward(request, response);
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
		
	}

}
