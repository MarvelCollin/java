package utils;

import java.awt.dnd.DragGestureEvent;
import java.sql.Connection;
import java.sql.DriverManager;

public class Connect {
	// build path -> masukin external jar si mysql connector
	private final String USERNAME = "root";
	private final String PASSWORD = "";
	private final String HOST = "localhost:3306"; // bisa liat di xampp
	private final String DATABASE = "library";
	private final String CONNECTION = String.format("jbdc:mysql://%s/%s", HOST, DATABASE);
	
	private Connection conn;
	
	private static volatile Connect instance;
	
	public static Connect getInstance() {
		if(instance == null) {
			instance = new Connect();
		}
		return instance;
	}
	
	private Connect() {
		conn = DriverManager.getConnection(CONNECTION, USERNAME, PASSWORD);
	}
}
