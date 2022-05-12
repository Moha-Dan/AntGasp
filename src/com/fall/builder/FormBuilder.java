package com.fall.builder;

import java.util.List;

import com.fall.persistence.ParseClass;

/*extends SimpleTagSupport*/
public class FormBuilder{
	public FormBuilder() {
		
	}
	public static String buildGroup(Object obj){
		List<String> ls = ParseClass.getProprietyNames(obj);
		StringBuffer form = new StringBuffer();
		form.append("<div class=\"col-10 col-lg-6 centred col\">");
		for(String prop : ls) {
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
		form.append("</div>");
		//System.out.println(form);
		return form.toString();
	}
}
