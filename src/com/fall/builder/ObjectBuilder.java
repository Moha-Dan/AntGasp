package com.fall.builder;

import java.util.List;

import com.fall.persistence.ParseClass;

public class ObjectBuilder{
	public static String buildGroup(Object obj){
		return buildGroup(obj,"col-10 col-lg-6 centred row");
	}
	public static String buildGroup(Object obj,String clazz){
		List<String> ls = ParseClass.getProprietyNames(obj);
		StringBuffer form = new StringBuffer();
		//System.out.print("11"+ls);
		form.append("<div class=\""+clazz+"\">");
		for(String prop : ls) {
			form.append("<div class=\"col-lg-10 row centred\">");
			Object value = ParseClass.getPropriety(obj, prop);
			String STRvalue = "";
			form.append("<label class=\"form-label\">"+prop+"</label>");
			if(value!=null)
				STRvalue = value.toString();
			form.append("<p class=\"form-control\" >"+STRvalue+"</p>");
			form.append("</div>");
		}
		form.append("</div>");
		//System.out.println(form);
		return form.toString();
	}
}
