package javaWebEE.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnection4MySQL {

	static Connection getDB() {
		// Following information shall NOT be uploaded to Github  !!!
		// If so, plz encoded as credential key
		String url = "";
		String user = "";
		String password = "";
		
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);		
		} catch (SQLException e) {
			System.out.println("No Connection");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			
		}
		return conn;
	}
	
	public static void main(String[] args) {
		System.out.println("Start test");

	}

}
