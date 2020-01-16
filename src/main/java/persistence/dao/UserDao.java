package persistence.dao;

import java.sql.SQLException;
import java.util.List;

import model.User;

public interface UserDao {
	
	public void save(User utente) throws SQLException;
	public User findByEmail(String email) throws SQLException;
	public List<User> findAll();

	public void update(User Utente); //Update
	public void delete(String username ); //Delete	
}
