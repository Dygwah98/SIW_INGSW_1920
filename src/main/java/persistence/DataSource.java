package persistence;

import java.sql.*;

public class DataSource {
	final private String dbURI;// = "jdbc:postgresql://localhost/test";
	final private String userName;// = "postgres";
	final private String password;// = "postgres";
	
	public DataSource(String dbURI, String userName, String password) {
		this.dbURI=dbURI;
		this.userName=userName;
		this.password=password;
	}

	public Connection getConnection() throws SQLException {
		Connection connection = DriverManager.getConnection(dbURI,userName, password);
		return connection;
	}
}
