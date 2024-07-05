package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {

	private final String USERNAME = "root";
	private final String PASSWORD = "";
	private final String DATABASE = "todo";
	private final String HOST = "localhost:3306";
	private final String CONNECTION = String.format("jdbc:mysql://%s/%s", HOST, DATABASE);
	
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

	public Connect() {
		try {
			conn = DriverManager.getConnection(CONNECTION, USERNAME, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
