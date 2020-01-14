package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;

import persistence.dao.UserDao;

public class UserDaoJDBC implements UserDao{
	
	private DataSource dataSource;
	
	public UserDaoJDBC(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	@Override
	public void save(User utente) throws SQLException {
		
		try(Connection connection = this.dataSource.getConnection()) {
			
			int id = getNextId(connection);
			
			String insert = "insert into User(id, nome, cognome,date, username,password,image,email) values (?,?,?,?,?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setInt(1, utente.getId());
			statement.setString(2, utente.getName());
			statement.setString(3, utente.getSurname());
			statement.setDate(4,utente.getNascita());
			statement.setString(5, utente.getUsername());
			statement.setString(6, utente.getPassword());
			statement.setString(7, null);
			statement.setString(8, utente.getEmail());

			statement.executeUpdate();
			
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		}
	}
	/** 
	 * 	This method is used to generate next user ID
	 */
	private final int getNextId(final Connection connection){
		try {
			PreparedStatement statement;
			final String query = "select id from User;";
			statement = connection.prepareStatement(query,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet result = statement.executeQuery();
			
			if(result.last()){
				int tmp = result.getInt("id");
				return ++tmp;
			}
			return 0;
				
			
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		} 
	}

	@Override
	public User findByEmail(String email) throws SQLException {

		try(Connection connection = dataSource.getConnection()) {
			//query che mi trova l'ultente con l'email corrispondente a quella ricercata
			String query = " select * "
							+ "from User as u "
							+ "where u.email=?";
			
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, email);
			ResultSet result = statement.executeQuery();
			
			User u = null;
			if (result.next()) {
				u  = new User();
				u.setId(result.getInt("id"));
				u.SetName(result.getString("nome"));
				u.SetSurname(result.getString("cognome"));
				u.SetNascita(result.getDate("Date"));
				u.setUsername(result.getString("username"));
				u.setPassword(result.getString("password"));
				u.setImage(result.getString("image"));
				u.setEmail(result.getString("email"));
			}
			return u;
			
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		}
	}
}
