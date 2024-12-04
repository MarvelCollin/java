package utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connect {
	private final String username = "root";
	private final String password = "";
	private final String host = "localhost:3306";
	private final String database = "javah1";
	private final String connection = String.format("jdbc:mysql://%s/%s", host, database);
	
	private Connection conn;
	private static Connect instance;
	
	public static Connect getInstance() {
		if(instance == null) {
			instance = new Connect();
		}
		return instance;
	}
	
	public Connection getConn() {
		return conn;
	}
	
	private Connect() {
		try {
			conn = DriverManager.getConnection(connection, username, password);
		} catch (Exception e) {
			System.out.println("Salah kak");
		}
	}
	
}
