package persistence.dao;

import java.sql.SQLException;

import model.User;

public interface UserDao {
	
	public void save(User utente) throws SQLException;
	public User findByEmail(String email) throws SQLException;
	
}
