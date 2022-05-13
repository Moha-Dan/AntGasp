package com.fall.persistence;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import entities.Panier;


public class SQLTable<E> implements Table<E>{
	private Object clazz;
	private Object name;
	private List<Field> attrs;
	private HashMap<String, String> types = new HashMap<String, String>();

	private void createTable() {
		if(!isConnected())
			connect();
		System.out.println(jdbcConnection);
		String sql = "DROP TABLE IF EXISTS `"+name+"`;"
				+ "CREATE TABLE `"+name+"` ("
				+ "`"+name+"_id` INTEGER NOT NULL ,";
		attrs = Arrays.asList(((Class) clazz).getDeclaredFields());
		for(Field attr : attrs) {
			String key = attr.getName();
			String type ="TEXT";
			boolean isNullable = true;
			String defaultValue = null;
			types.put(key, type);
			sql+= "`"+key+"` "+type+" "+(defaultValue!=null?("DEFAULT"+defaultValue):"")+" "+(isNullable?"":"NOT NULL")+",";
		}
		sql += "PRIMARY KEY (`"+name+"_id`));";
		sql += "INSERT INTO `"+name+"` VALUES (null,null);";
		System.out.println(sql);
		try {
			Statement tables = jdbcConnection.createStatement();
			tables.execute(sql);
			System.out.println("success");
		}catch(SQLException e){
			e.printStackTrace();
		}
		disconnect();
	}
	
	public SQLTable(Object TableName, Object clazz) {
		this.name = TableName;
		this.clazz = clazz;
		createTable();
	}

	public SQLTable(Object clazz) {
		this(clazz.getClass().getName(),clazz);
	}

	@Override
	public Iterator<E> iterator() {
		String sql = "SELECT * FROM `"+name+"`";
		connect();	
		try {
			Statement statement = jdbcConnection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			return new Iterator<E>() {

				@Override
				public boolean hasNext() {
					boolean hasNext;
					try {
						hasNext = resultSet.next();
						if(hasNext)
							return true;
						resultSet.close();
						statement.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					return false;
				}

				@Override
				public E next() {
					E clazz = createObject();
					Set<String> fields = types.keySet();
					for (String field : fields) {
						String type = types.get(field);
						Object value = null;
						try {
							switch (type) {
							case "INTEGER": {
									value = resultSet.getInt(field);
								}
								default:{
									value = resultSet.getString(field);
								}
							}
						} catch (SQLException e) {
							e.printStackTrace();
						}
						ParseClass.setPropriety(clazz, field, value);
					}
					return clazz;
				}
				
			};
		} catch (SQLException e) {
			e.printStackTrace();
			return new Iterator<E>() {
				@Override
				public boolean hasNext() {return false;}
				@Override
				public E next() {return null;}
			};
		}
	}

	protected E createObject() {
		try {
			return (E) clazz.getClass().getConstructor().newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
			return (E)(new Object());
		}
	}

	@Override
	public void add(E object) {
		System.out.println("insert value");
		String sql = "INSERT INTO "+name+" VALUES (null";
		Set<String> fields = types.keySet();
		for (String field : fields) {
			Object value = ParseClass.getPropriety(object, field);
			sql+=","+value.toString();
		}
		sql += ");";
		System.out.println(sql);
		connect();			
		PreparedStatement statement;
		try {
			statement = jdbcConnection.prepareStatement(sql);
			statement.executeUpdate();
			statement.close();
			disconnect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void remove(E object) {
		
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Set<E> find(E entity) {
		// TODO Auto-generated method stub
		return null;
	}
	private static Connection jdbcConnection = null;
	public static String jdbcURL = "jdbc:sqlite::memory:";
	public static void setJdbcURL(String jdbcURL) {
		SQLTable.jdbcURL = jdbcURL;
	}
	public static boolean connect() {
		return connect(jdbcURL);
	}
	public static boolean connect(String jdbcURL) { 
		try {
			if (jdbcConnection == null || jdbcConnection.isClosed()) {
				  try {
					  Class.forName("org.sqlite.JDBC");
				} catch (Exception e) {
					e.printStackTrace();
					return false;
				}
				jdbcConnection = DriverManager.getConnection(jdbcURL);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public static boolean disconnect() {
		try {
			if (jdbcConnection != null && !jdbcConnection.isClosed()) {
				jdbcConnection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public static boolean isConnected() {
		try {
			return jdbcConnection != null && !jdbcConnection.isClosed();
		} catch (SQLException e) {
			e.printStackTrace();
			return jdbcConnection != null;
		}
	}

	@Override
	public E get(UUID uuid) {
		return null;
	}
}
