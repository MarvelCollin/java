package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
	private final String USERNAME = "root";;
	private final String PASSWORD = "";
	private final String DATABASE = "javah1";
	private final String PORT = "3306";
	private final String CONNECTION = String.format("jdbc:mysql://localhost:%s/%s", PORT, DATABASE);
	
	private static Connect instance;
	private static Connection conn;
	
	public static Connect getInstance() {
		if(instance == null) {
			instance = new Connect();
		}
		return instance;
	}
	
	public Connection getConn() {
		return conn;
	}
	
	public Connect() {
		try {
			conn = DriverManager.getConnection(CONNECTION, USERNAME, PASSWORD);
		} catch (SQLException e) {
			System.out.println("Error kak");
		}
	}
	
	
}
