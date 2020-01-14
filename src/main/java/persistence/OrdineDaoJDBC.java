package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


import model.Ordine;
import model.Prenotazione;
import persistence.dao.OrdineDao;
import persistence.dao.PrenotazioneDao;
public class OrdineDaoJDBC implements OrdineDao{
private DataSource dataSource;
	
	public OrdineDaoJDBC(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	@Override
	public void save(Ordine ordine) {
		Connection connection = null;
		try {
			connection = this.dataSource.getConnection();
			String insert = "insert into ordine(idordine,idutente) values (?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setInt(1,ordine.getIdOrdine());
			statement.setInt(2, ordine.getIdUtente());
			
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		
	}

	@Override
	public List<Ordine> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Ordine ordine) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Ordine ordine) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Ordine> retrieve(Integer nOrdine, Integer maxOrdine) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Prenotazione> retrieve1(Integer nOrdine, Integer maxOrdine) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
}