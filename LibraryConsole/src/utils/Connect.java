package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
	// build path -> masukin external jar si mysql connector
	private final String USERNAME = "root";
	private final String PASSWORD = "";
	private final String HOST = "localhost:3306"; // bisa liat di xampp
	private final String DATABASE = "library";
	private final String CONNECTION = String.format("jdbc:mysql://%s/%s", HOST, DATABASE);

	private Connection conn;
	
	private static volatile Connect instance;
	
	public static Connect getInstance() {
		// mungkin bakalan ada beberapa thread yang bakalan mengakses instance
		// dan bakalan membuat beberapa instance
		// makanya harus menggunakan synchronized

		// dan supaya ga kedelay harus pake double check locking (jadi kasi check instance == null 2x)
//		if(instance == null) { // biar ga waiting ke semua threadnya
//			synchronized (Connect.class) { // make sure satu thread lewat baru giliran yang lain
				if(instance == null) {
					instance = new Connect();
				}
//			}
//		}
		return instance;
	}
	
	public Connection getConn() {
		return conn;
	}

	private Connect() {
		try {
			conn = DriverManager.getConnection(CONNECTION, USERNAME, PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
