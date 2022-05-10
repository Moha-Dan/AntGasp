package com.fall.persistence;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ParseClass {
	public static HashMap<String,Object> parse(Object obj){
		return parse(obj.getClass());
	}
	public static HashMap<String,Object> parse(Class<?> clazz){
		HashMap<String,Object> map = new HashMap<String,Object>();
		List<Field> lsf = Arrays.asList(clazz.getFields());
		List<Method> lsm = Arrays.asList(clazz.getDeclaredMethods());
		for( Field field : lsf) {
			String fn = field.getName();
			String fl = (fn.charAt(0)+"").toUpperCase();
			String method = "get"+fl+fn.substring(1);
			Method gm = lsm.stream().filter((Method m)->{
				return m.getName() == method;
			}).findFirst().get();
			if(gm!=null)
				try {
					map.put(fn, gm.invoke(clazz));
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
					e.printStackTrace();
				}
		}
		return map;
	}
	public static boolean Equal(Class<?> clazz1,Class<?> clazz2) {
		boolean isequal = false;
		HashMap<String,Object> map1 = ParseClass.parse(clazz1);
		HashMap<String,Object> map2 = ParseClass.parse(clazz2);
		Set<String> set1 = map1.keySet();
		if(set1.size() != map2.size())return isequal;
		Iterator<String> it1 = set1.iterator();
		String key = null;
		do {
			key = it1.next();
			isequal = map1.get(key).equals(map2.get(key));
		}
		while(it1.hasNext() && isequal);
		return isequal;
	}
	public Object assign(Class<?> target,Class<?> source){
		HashMap<String,Object> sourceMap = ParseClass.parse(source);
		Object c = null; 
		try {
			c = target.getConstructor().newInstance();
			List<Field> lsf = Arrays.asList(target.getFields());
			List<Method> lsm = Arrays.asList(target.getDeclaredMethods());
			for( Field field : lsf) {
				String fn = field.getName();
				String fl = (fn.charAt(0)+"").toUpperCase();
				String method = "set"+fl+fn.substring(1);
				Method gm = lsm.stream().filter((Method m)->{
					return m.getName() == method;
				}).findFirst().get();
			}
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
		return c;
	}
	public static Object getPropriety(Object obj,String field) {
		Object value = null;
		try {
			Method m = obj.getClass().getDeclaredMethod("get"+field);
			m.invoke(obj);
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return value;
	}
	public static void setPropriety(Object obj,String field,Object value) {
		try {
			Method m = obj.getClass().getDeclaredMethod("set"+field, value.getClass());
			m.invoke(obj, value);
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}
}
