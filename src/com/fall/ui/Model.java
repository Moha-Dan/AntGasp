package com.fall.ui;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

public interface Model{
	public Object getAttribute(String name);
	public void setAttribute(String name,Object value);
	public Object removeAttribute(String name);
	public Enumeration<String> getAttributeNames();
	public String getAttributeAsString(String name);
	public HttpServletRequest getRequest();
	public double getAttributeAsNumber(String string);

}
