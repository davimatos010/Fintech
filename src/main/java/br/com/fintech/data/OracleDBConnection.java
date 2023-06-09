package br.com.fintech.data;

import java.sql.Connection;
import java.sql.DriverManager;

public class OracleDBConnection {
	
	static String driver;
	static String url;
	static String user;
	static String password;
	private static OracleDBConnection instance;
	
	private OracleDBConnection() {
		driver = DataSource.getDriver();
		url = DataSource.getUrl();
		user = DataSource.getUser();
		password = DataSource.getPwd();
	}
	
	public static OracleDBConnection getInstance() {
		if(instance == null) {
			instance = new OracleDBConnection();
		}
		return instance;
	}
	
	public Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName(driver);

			connection = DriverManager.getConnection(url, user, password);

			System.out.println("Connected to Oracle Database");
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return connection;
  }
	
}