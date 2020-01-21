package persistence.postgres.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.Admin;
import persistence.PersistenceException;
import persistence.dao.AdminDao;

public class AdminDaoJDBC implements AdminDao {

	@Override
	public void save(Admin object) {
		// TODO Auto-generated method stub

	}

	@Override
	public Admin retrieve(Admin object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Admin> retrieveAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Admin object) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Admin object) {
		// TODO Auto-generated method stub

	}

	@Override
	public Admin loginQuery(String username, String password) {
		
		String query = "SELECT * FROM admin WHERE username=? AND password=?";
		Admin a = null;
		
		try(JDBCQueryHandler handler = new JDBCQueryHandler(query)) {
			
			PreparedStatement smt = handler.getStatement();
			smt.setString(1, username);
			smt.setString(2, password);
			handler.executeQuery();
			
			if(handler.existsResultSet()) {
				
				ResultSet result = handler.getResultSet();
				result.next();
				
				a  = new Admin();
				a.setUsername(result.getString("username"));
				a.setPassword(result.getString("password"));
				
			}
			
			return a;
			
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		}
	}

}
