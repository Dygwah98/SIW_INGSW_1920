package persistence.postgres.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.User;
import persistence.DBManager;
import persistence.Dao;
import persistence.PersistenceException;

public class UserDaoJDBC implements Dao<User>{
		
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
	public void save(User utente) {
		
		try(Connection connection = DBManager.getInstance().getDataSource().getConnection()) {
		
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
		}
	}

	@Override
	public void update(User Utente) {
		try(Connection connection = DBManager.getInstance().getDataSource().getConnection()) {
			
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
	public List<User> retrieve(User object) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<User> retrieveBy(String column, Object value) {
		
		try(Connection connection = DBManager.getInstance().getDataSource().getConnection()) {
		
			List<User> ret = null;
			User u = null;
			
			String query = "SELECT * FROM utente AS u WHERE u." + column + "=?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, (String) value);
			ResultSet result = statement.executeQuery();
			
			if(result.isBeforeFirst()) {
				ret = new ArrayList<User>();
				while(result.next()) {
					u  = new User();
					u.SetName(result.getString("nome"));
					u.SetSurname(result.getString("cognome"));
					u.SetNascita(result.getString("datadinascita"));
					u.setUsername(result.getString("username"));
					u.setPassword(result.getString("password"));
					u.setImage(result.getString("image"));
					u.setEmail(result.getString("email"));
					ret.add(u);
				}
			}
			
			return ret;
			
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		}
	}
	
	@Override
	public List<User> retrieveAll() {
		
		try(Connection connection = DBManager.getInstance().getDataSource().getConnection()){
		
			List<User> utenti = null;
			User utente = null;
		
			PreparedStatement statement;
			String query = "select * from utente";
			statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
		
			if(result.isBeforeFirst()) {
				utenti = new ArrayList<User>();
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
			}
		
			return utenti;
		
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public void delete(User object) {
		
		try(Connection connection = DBManager.getInstance().getDataSource().getConnection()) {
			
			String delete = "delete FROM utente WHERE username = ? ";
			PreparedStatement statement = connection.prepareStatement(delete);
			statement.setString(1, object.getUsername());
			statement.executeUpdate();
		
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
}
