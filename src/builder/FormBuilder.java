package builder;

import java.util.List;

import com.fall.persistence.ParseClass;

public class FormBuilder {
	public FormBuilder() {
		
	}
	public String buildGroup(Object obj){
		List<String> ls = ParseClass.getProprietyNames(obj);
		StringBuffer form = new StringBuffer();
		System.out.print(ls);
		form.append("<div class=\"col-10 col-lg-6 centred col\">");
		for(String prop : ls) {
			form.append("<div class=\"col-lg-10 col centred\">");
			Object value = ParseClass.getPropriety(obj, prop);
			String STRvalue = "";
			form.append("<label class=\"form-label\">"+prop+"</label>");
			if(value!=null)
				STRvalue = value.toString();
			form.append("<input class=\"form-control\" name=\""+prop+"\" value=\""+STRvalue+"\" />");
			form.append("</div>");
		}
		form.append("</div>");
		System.out.println(form);
		return form.toString();
	}
	
}
