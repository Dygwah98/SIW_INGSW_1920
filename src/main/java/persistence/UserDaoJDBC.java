package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.Prenotazione;
import model.User;

import persistence.dao.UserDao;

public class UserDaoJDBC implements UserDao{
	
	private DataSource dataSource;
	
	public UserDaoJDBC(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	@Override
	public void save(User utente) throws SQLException {
		Connection connection = this.dataSource.getConnection();
		try {
			String insert = "insert into utente(nome, cognome,datadinascita, username,password,image,email) values (?,?,?,?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setString(1, utente.getName());
			statement.setString(2, utente.getSurname());
			statement.setString(3,utente.getNascita());
			statement.setString(4, utente.getUsername());
			statement.setString(5, utente.getPassword());
			statement.setString(6, null);
			statement.setString(7, utente.getEmail());

			statement.executeUpdate();
			
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
	/** 
	 * 	This method is used to generate next user ID
	 */
	private final int getNextId(final Connection connection){
		try {
			PreparedStatement statement;
			final String query = "select id from user;";
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
	public User findByEmail(String username) throws SQLException {
		System.out.println(username);
		Connection connection = dataSource.getConnection() ;
		try {
			//query che mi trova l'ultente con l'email corrispondente a quella ricercata
			String query = " select * "
							+ "from utente as u "
							+ "where u.username=?";
			
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, username);
			ResultSet result = statement.executeQuery();
			
			User u = null;
			if (result.next()) {
				u  = new User();
				
				u.SetName(result.getString("nome"));
				u.SetSurname(result.getString("cognome"));
				u.SetNascita(result.getString("datadinascita"));
				u.setUsername(result.getString("username"));
				u.setPassword(result.getString("password"));
				u.setImage(result.getString("image"));
				u.setEmail(result.getString("email"));
			}
			return u;
			
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		}
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		} 
	}
	@Override
	public List<User> findAll()  {
			//Connection connection = this.dataSource.getConnection();
			try(Connection connection = this.dataSource.getConnection()){
			
			List<User> utenti = new LinkedList<>();
			
			User utente;
			PreparedStatement statement;
			String query = "select * from utente";
			statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				utente = new User();		
				utente.SetName(result.getString("nome"));
				utente.SetSurname(result.getString("cognome"));
				utente.SetNascita(result.getString("datadinascita"));
				utente.setUsername(result.getString("username"));
				utente.setPassword(result.getString("password"));
				utente.setImage(result.getString("image"));
				utente.setEmail(result.getString("email"));
				utenti.add(utente);
			}
			
			return utenti;
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
			
	}
	@Override
	public void update(User Utente) {
		try(Connection connection = this.dataSource.getConnection()) {
			
			String update = "update utente SET  nome=?,cognome=?,datadinascita=?,username=?,password=?,image=?,email=? WHERE username=?";
			PreparedStatement statement = connection.prepareStatement(update);
			statement.setString(2, Utente.getName());
			statement.setString(3, Utente.getSurname());
			statement.setString(4, Utente.getNascita());
			statement.setString(5, Utente.getUsername());
			statement.setString(6, Utente.getPassword());
			statement.setString(7, Utente.getImage());
			statement.setString(8, Utente.getImage());
			statement.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}		
	}
	@Override
	public void delete(String username) {
	try(Connection connection = this.dataSource.getConnection()) {
			
			String delete = "delete FROM utente WHERE username = ? ";
			PreparedStatement statement = connection.prepareStatement(delete);
			statement.setString(1,username);
			statement.executeUpdate();
		
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
		
	}
	
}
