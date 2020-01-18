package persistence.dao;

import java.sql.SQLException;
import java.util.List;

import model.User;
import persistence.Dao;

public interface UserDao extends Dao<User> {
	
	public User loginQuery(String username, String password);
}
