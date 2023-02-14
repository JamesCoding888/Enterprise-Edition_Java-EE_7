package javaWebEE.test;

import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestConnection4MySQL {

	static Connection getDB() {
		// Following information shall NOT be uploaded to Github  !!!
		// If so, plz encoded as credential key
		String url = "jdbc:mysql://localhost:xxxxx/xxxxx?useUnicode=true&characterEncoding=utf-8";
		String user = "xxxxx";
		String password = "xxxxx";

		Connection connection = null;
		try {			
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, user, password);		
			System.out.println("Connection successfully, because receive instance of Connection: " + connection);			
			String sql4update = "update SQL4javaWebEE.SQL4javaWebEE set name = 'James' where badge = 1";
			PreparedStatement preparedStatement = connection.prepareStatement(sql4update);					
			preparedStatement.executeUpdate();			
			
		} catch (ClassNotFoundException e) {
			System.out.println("No driver");
			e.printStackTrace();
		
		} catch (SQLException e) {
			System.out.println("No Connection");
			e.printStackTrace();
		}
		return connection;
	}
	
	public static void main(String[] args) {
		System.out.println("Start test");
		TestConnection4MySQL.getDB();
	}
}
