package persistence.postgres.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;


import model.Ordine;
import persistence.DBManager;
import persistence.Dao;

public class OrdineDaoJDBC implements Dao<Ordine>{

	@Override
	public void save(Ordine ordine) {
		
		try(Connection connection = DBManager.getInstance().getDataSource().getConnection()) {
			
			String insert = "insert into ordine(idordine,idutente) values (?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setInt(1,ordine.getIdOrdine());
			statement.setInt(2, ordine.getIdUtente());
			
			statement.executeUpdate();
		
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public void update(Ordine ordine) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Ordine ordine) {
		// TODO Auto-generated method stub
		
	}
/*
	@Override
	public ArrayList<Ordine> retrieve(Integer nOrdine, Integer maxOrdine) throws SQLException {
		
		try(Connection connection = this.dataSource.getConnection()) {
			
			ArrayList<Ordine> result = null;
			
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
		}
	}

	@Override
	public ArrayList<Prenotazione> retrieve1(Integer nOrdine, Integer maxOrdine) throws SQLException {
		
		try(Connection connection = this.dataSource.getConnection()) {
			
			ArrayList<Prenotazione> result = null;
			
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
		}
	}
*/
	@Override
	public List<Ordine> retrieve(Ordine object) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Ordine> retrieveBy(String column, Object value) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Ordine> retrieveAll() {
		// TODO Auto-generated method stub
		return null;
	}
}