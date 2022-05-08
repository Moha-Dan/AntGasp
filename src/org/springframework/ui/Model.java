package org.springframework.ui;

import java.util.Enumeration;

public interface Model{
	public Object getAttribute(String name);
	public void setAttribute(String name,Object value);
	public Object removeAttribute(String name);
	public Enumeration<String> getAttributeNames();
}
