package com.falls.persistence;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.reflections.Reflections;

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
