package persistence;

import java.sql.*;

public class DataSource {
	private String dbURL; 
	private String userName; 
	private String password; 
	private Connection connection;

	public DataSource(String dbURI, String userName, String password) {
		this.dbURL = dbURI;
		this.userName = userName;
		this.password = password;
		this.connection = null;
	}

	public Connection getConnection() throws SQLException {
		if (connection == null || connection.isClosed()) {
			connection = DriverManager.getConnection(dbURL, userName, password);
			connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
		}
		return connection;
	}
}
