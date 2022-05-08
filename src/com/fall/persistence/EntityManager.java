package com.fall.persistence;

import java.util.HashMap;
import java.util.Set;

import com.reflections.Reflections;


public class EntityManager {
	private static Reflections reflections = new Reflections("entities");
	private HashMap<String, Table> tables = new HashMap<String, Table>();
	public Table get(String string) {
		return tables.get(string);
	}
	public EntityManager() {
		Set<Class<?>> entities = reflections.getTypesAnnotatedWith(Entity.class);
		for(Class<?> entity : entities) {
			addEntity(entity.getSimpleName(), entity);
		}
	}
	public void addEntity(String name,Class<?> clazz) {
		Table<?> t = new Table<>();
		tables.put(name, t);
	}
	private static EntityManager instance = new EntityManager();
	public static EntityManager createInstance() {
		return instance;
	}

}
