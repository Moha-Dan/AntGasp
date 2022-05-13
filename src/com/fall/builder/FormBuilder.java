package com.fall.builder;

import java.lang.reflect.Field;
import java.util.List;

import com.fall.persistence.Id;
import com.fall.persistence.ParseClass;

/*extends SimpleTagSupport*/
public class FormBuilder{
	public FormBuilder() {
		
	}
	public static String buildGroup(Object obj){
		return buildGroup(obj,"col-10 col-lg-6 centred row");
	}
	public static String buildGroup(Object obj,String clazz){
		List<String> ls = ParseClass.getProprietyNames(obj);
		StringBuffer form = new StringBuffer();
		form.append("<div class=\""+clazz+"\">");
		for(String prop : ls) {
			Field f = null;
			try {
				f = obj.getClass().getDeclaredField(prop);
			}catch(Exception e) {
				e.printStackTrace();
			}
			if(f!=null && ! f.isAnnotationPresent(Id.class)) {
				form.append("<div class=\"col-lg-10 col centred\">");
				Object value = ParseClass.getPropriety(obj, prop);
				String STRvalue = "";
				form.append("<label class=\"form-label\">"+prop+"</label>");
				String type = "text";
				if(ParseClass.getProprietyType(obj,prop).isEnum()) {
					form.append("<select name=\""+prop+"\">");
					Object[] constants = ParseClass.getProprietyType(obj,prop).getEnumConstants();
					if(constants!=null) {
						for(Object constant : constants) {
							form.append("<option value=\""+constant+"\" >");
							form.append(constant);
							form.append("</option>");
						}
					}
					form.append("</select>");
					type = null;
				}else {
					if(value!=null) {
						STRvalue = value.toString();
						type = value.getClass().getTypeName();					
					}
					form.append("<input class=\"form-control\" type=\""+type+"\" name=\""+prop+"\" value=\""+STRvalue+"\" />");					
				}
				form.append("</div>");
			}
		}
		form.append("</div>");
		//System.out.println(form);
		return form.toString();
	}
}
