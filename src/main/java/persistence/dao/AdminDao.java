package persistence.dao;

import model.Admin;
import persistence.Dao;

public interface AdminDao extends Dao<Admin> {

	public Admin loginQuery(String username, String password);
}
