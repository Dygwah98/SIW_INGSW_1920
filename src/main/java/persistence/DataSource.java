package persistence;

import java.sql.*;

public class DataSource {
	private String dbURL; // = "jdbc:postgresql://sarella.cqenbowd50kg.eu-central-1.rds.amazonaws.com";
	private String userName; // = "riuzaki9797";
	private String password; // = "*Francesco1.,";

	public DataSource(String dbURI, String userName, String password) {
		this.dbURL = dbURI;
		this.userName = userName;
		this.password = password;
	}

	public Connection getConnection() throws SQLException {
		Connection connection = DriverManager.getConnection(dbURL, userName, password);
		return connection;
	}
}
