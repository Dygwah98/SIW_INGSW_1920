package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import model.Prenotazione;
import persistence.dao.PrenotazioneDao;

public class PrenotazioneDaoJDBC implements PrenotazioneDao{

private DataSource dataSource;
	
	public PrenotazioneDaoJDBC(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	@Override
	public void save(Prenotazione book) {
		Connection connection = null;
		try {
			connection = this.dataSource.getConnection();
			String insert = "insert into Prenotazione(idprenotazione,checkin,checkout,idcamera,idcliente,idordine) values (?,?,?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setInt(1,book.getIdPrenotazione());
			statement.setDate(2,book.getCheckin());
			statement.setDate(3, book.getCheckout());
			statement.setInt(4,book.getIdCamera());
			statement.setInt(5, book.getIdordine());
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
	public List<Prenotazione> findAll() {
		Connection connection = null;
		List<Prenotazione> books = new LinkedList<>();
		try {
			connection = this.dataSource.getConnection();
			Prenotazione book;
			PreparedStatement statement;
			String query = "select * from Prenotazione";
			statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				book = new Prenotazione();
				book.setIdPrenotazione(result.getInt("idprenotazione"));				
				book.setCheckin(result.getDate("checkin"));
				book.setCheckout(result.getDate("checkout"));
				book.setIdCamera(result.getInt("idcamera"));
				book.setIdordine(result.getInt("idordine"));
				books.add(book);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}	 finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		return books;
	}

	@Override
	public void update(Prenotazione book) {
		Connection connection = null;
		try {
			connection = this.dataSource.getConnection();
			String update = "update Prenotazione SET , checkin = ?,checkout= ?,idcamera= ?,idcliente=? idordine=? WHERE idprenotazione=?";
			PreparedStatement statement = connection.prepareStatement(update);
			statement.setDate(2, book.getCheckin());
			statement.setDate(3, book.getCheckout());
			statement.setInt(4, book.getIdCamera());
			statement.setInt(5, book.getIdordine());
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
	public void delete(Prenotazione book) {
		Connection connection = null;
		try {
			connection = this.dataSource.getConnection();
			String delete = "delete FROM Prenotazione WHERE idprenotazione = ? ";
			PreparedStatement statement = connection.prepareStatement(delete);
			statement.setInt(1,book.getIdPrenotazione());
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
	public ArrayList<Prenotazione> retrieve(Integer nPren, Integer maxPren) throws SQLException {
		
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
			if ((maxPren + nPren) == idMax)
				return null;

			Integer from = idMax - maxPren; //maxPost + nPost - maxPost => nPost
			Integer to = from - nPren;      //nPost - nPost             => 0

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