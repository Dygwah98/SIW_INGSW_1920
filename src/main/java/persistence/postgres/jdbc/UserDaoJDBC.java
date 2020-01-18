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
			final String query = "SELECT id FROM utente;";
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
		
		String insert = "INSERT INTO utente(nome,cognome,datadinascita,username,password,image,email) VALUES (?,?,?,?,?,?,?)";
		
		try(JDBCQueryHandler handler = new JDBCQueryHandler(insert)) {

			PreparedStatement smt = handler.getStatement();
			smt.setString(1, utente.getName());
			smt.setString(2, utente.getSurname());
			smt.setString(3,utente.getNascita());
			smt.setString(4, utente.getUsername());
			smt.setString(5, utente.getPassword());
			smt.setString(6, null);
			smt.setString(7, utente.getEmail());

			handler.executeUpdate();
			
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		}
	}

	@Override
	public void update(User Utente) {
		
		String update = "UPDATE utente SET nome=?,cognome=?,datadinascita=?,username=?,password=?,image=?,email=? WHERE username=?";
		
		try(JDBCQueryHandler handler = new JDBCQueryHandler(update)) {
			
			PreparedStatement smt = handler.getStatement();
			smt.setString(1, Utente.getName());
			smt.setString(2, Utente.getSurname());
			smt.setString(3, Utente.getNascita());
			smt.setString(4, Utente.getUsername());
			smt.setString(5, Utente.getPassword());
			smt.setString(6, Utente.getImage());
			smt.setString(7, Utente.getImage());
			smt.setInt(8, Utente.getId());
			
			handler.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}		
	}
	
	@Override
	public User retrieve(User object) {

		String query = "SELECT * FROM utente AS u WHERE u.id = ?";
		User u = null;
		
		try(JDBCQueryHandler handler = new JDBCQueryHandler(query)) {
			
			handler.getStatement().setInt(1, object.getId());
			handler.executeQuery();
		
			if(handler.existsResultSet()) {
				ResultSet result = handler.getResultSet();
				result.next();
				u = new User();
				u.SetName(result.getString("nome"));
				u.SetSurname(result.getString("cognome"));
				u.SetNascita(result.getString("datadinascita"));
				u.setUsername(result.getString("username"));
				u.setPassword(result.getString("password"));
				u.setImage(result.getString("image"));
				u.setEmail(result.getString("email"));
			}
			
			return u;
			
		} catch(SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
	@Override
	public List<User> retrieveBy(String column, Object value) {
		
		String query = "SELECT * FROM utente AS u WHERE u." + column + "=?";
		List<User> ret = null;
		User u = null;
		
		try(JDBCQueryHandler handler = new JDBCQueryHandler(query)) {
			
			handler.getStatement().setString(1, (String) value);
			handler.executeQuery();
			
			if(handler.existsResultSet()) {
				
				ResultSet result = handler.getResultSet();
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
		
		String query = "SELECT * FROM utente";
		List<User> utenti = null;
		User utente = null;
		
		try(JDBCQueryHandler handler = new JDBCQueryHandler(query)) {
		
			handler.executeQuery();
			
			if(handler.existsResultSet()) {
				
				ResultSet result = handler.getResultSet();
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

		String delete = "DELEtE FROM utente WHERE username = ? ";
		
		try(JDBCQueryHandler handler = new JDBCQueryHandler(delete)) {
			
			handler.getStatement().setString(1, object.getUsername());
			handler.executeUpdate();
		
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
}
