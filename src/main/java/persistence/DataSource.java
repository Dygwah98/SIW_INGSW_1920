package persistence;

import java.sql.*;

public class DataSource {
	private String dbURL; // = "jdbc:postgresql://sarella.cqenbowd50kg.eu-central-1.rds.amazonaws.com";
	private String userName; // = "riuzaki9797";
	private String password; // = "*Francesco1.,";
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
