package persistence.dao;

import model.User;
import persistence.Dao;

public interface UserDao extends Dao<User> {
	
	public User loginQuery(String username, String password);
}
