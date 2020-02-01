package persistence.postgres.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import persistence.DBManager;

public class JDBCQueryHandler implements AutoCloseable {

	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;

	public JDBCQueryHandler(String query) throws SQLException {

		connection = DBManager.getInstance().getDataSource().getConnection();
		preparedStatement = connection.prepareStatement(query);
	}

	@Override
	public void close() {

		try {

			if (connection != null) {
				connection.close();
				connection = null;
			}

		} catch (SQLException e1) {
			e1.printStackTrace();

		} finally {
			try {

				if (preparedStatement != null) {
					preparedStatement.close();
					preparedStatement = null;
				}

			} catch (SQLException e2) {
				e2.printStackTrace();

			} finally {
				try {

					if (resultSet != null) {
						resultSet.close();
						resultSet = null;
					}

				} catch (SQLException e3) {
					e3.printStackTrace();
				}
			}
		}
	}

	public Connection getConnection() {
		return connection;
	}

	public PreparedStatement getStatement() {
		return preparedStatement;
	}

	public ResultSet getResultSet() {
		return resultSet;
	}

	public boolean existsResultSet() throws SQLException {
		return resultSet != null && resultSet.isBeforeFirst();
	}

	public void executeQuery() throws SQLException {
		resultSet = preparedStatement.executeQuery();
	}

	public void executeUpdate() throws SQLException {
		preparedStatement.executeUpdate();
	}

}
