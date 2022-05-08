package web;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class SQLTable {
	private Connection jdbcConnection;
	private Object clazz;
	private Object name;
	private List<Field> attrs;
	private HashMap<String, String> types;

	public SQLTable(String name, Object TableName, Object clazz, Connection jdbcConnection) {
		this.name = TableName;
		this.clazz = clazz;
		this.jdbcConnection = jdbcConnection;
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
		System.out.println(sql);
		try {
			Statement tables = jdbcConnection.createStatement();
			tables.execute(sql);				
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
}
