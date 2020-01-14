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
		
		ArrayList<Ordine> result = null;
		Connection connection = null;
		try {
			connection = this.dataSource.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			PreparedStatement maxpost = connection.prepareStatement("SELECT max(idOrdine) AS max FROM ordine");
			ResultSet rsMax = maxpost.executeQuery();
			rsMax.next();
			Integer idMax = (int) rsMax.getLong("max");
			if ((maxOrdine + nOrdine) == idMax)
				return null;

			Integer from = idMax - maxOrdine; //maxPost + nPost - maxPost => nPost
			Integer to = from - nOrdine;      //nPost - nPost             => 0

			PreparedStatement create = connection.prepareStatement("SELECT * FROM ordine WHERE idOrdine <= ? and idOrdine > ?");
			create.setInt(1, from);
			create.setInt(2, to);
			ResultSet rs;
			rs = create.executeQuery();
			boolean found = true;

			while (rs.next()) {
				if (found) {
					result = new ArrayList<>();
					found = false;
				}

				Ordine ord = new Ordine();
				ord.setIdOrdine(rs.getInt("idOrdine"));				
				ord.setIdUtente(rs.getInt("idUtente"));
				result.add(ord);
			}

			if (result != null) {

				ArrayList<Ordine> orderedPost = new ArrayList<Ordine>();
				for (int i = result.size() - 1; i >= 0; i--) {
					orderedPost.add(result.get(i));
				}
				return orderedPost;
			}
			return null;
			
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
	public ArrayList<Prenotazione> retrieve1(Integer nOrdine, Integer maxOrdine) throws SQLException {
		
		ArrayList<Prenotazione> result = null;
		Connection connection = null;
		try {
			connection = this.dataSource.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			PreparedStatement maxpost = connection.prepareStatement("SELECT max(idprenotazione) AS max FROM prenotazione");
			ResultSet rsMax = maxpost.executeQuery();
			rsMax.next();
			Integer idMax = (int) rsMax.getLong("max");
			if ((maxOrdine + nOrdine) == idMax)
				return null;

			Integer from = idMax - maxOrdine; //maxPost + nPost - maxPost => nPost
			Integer to = from - nOrdine;      //nPost - nPost             => 0

			PreparedStatement create = connection.prepareStatement("SELECT * FROM prenotazione WHERE idprenotazione <= ? and idprenotazione > ?");
			create.setInt(1, from);
			create.setInt(2, to);
			ResultSet rs;
			rs = create.executeQuery();
			boolean found = true;

			while (rs.next()) {
				if (found) {
					result = new ArrayList<>();
					found = false;
				}

				Prenotazione book = new Prenotazione();
				book.setIdPrenotazione(rs.getInt("idprenotazione"));				
				book.setCheckin(rs.getDate("checkin"));
				book.setCheckout(rs.getDate("checkout"));
				book.setIdCamera(rs.getInt("idcamera"));
				book.setIdordine(rs.getInt("idordine"));
				result.add(book);
			}

			if (result != null) {

				ArrayList<Prenotazione> orderedPost = new ArrayList<Prenotazione>();
				for (int i = result.size() - 1; i >= 0; i--) {
					orderedPost.add(result.get(i));
				}
				return orderedPost;
			}
			return null;
			
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
}