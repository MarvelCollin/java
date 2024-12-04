package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
	private final String USERNAME = "root";
	private final String PASSWORD = "";
	private final String DATABASE = "auto_pets";
	private final String PORT = "3306";
	private final String CONNECTION = String.format("jdbc:mysql:"
						+ "//localhost:%s/%s", PORT, DATABASE);
	
	public static Connection conn;
	public static Connect instance;
	
	public static Connect getInstance() {
		if(instance == null) {
			instance = new Connect();
		}
		return instance;
	}
	
	public static Connection getConn() {
		return conn;
	}
	
	public Connect() {
		try {
//			System.out.println("Berhasil");
			conn = DriverManager.getConnection(CONNECTION, USERNAME, PASSWORD);
		} catch (SQLException e) {
			System.out.println("Tidak Berhasil");
			e.printStackTrace();
		}
	}

}
