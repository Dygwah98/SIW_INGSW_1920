package persistence.postgres.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.tables.Prenotazione;
import persistence.dao.PrenotazioneDao;

public class PrenotazioneDaoJDBC implements PrenotazioneDao {

	@Override
	public void save(Prenotazione book) {

		String insert = "INSERT INTO prenotazioni(id_prenotazione,checkin,checkout,id_room,id_order) VALUES (?,?,?,?,?)";

		try (JDBCQueryHandler handler = new JDBCQueryHandler(insert)) {

			PreparedStatement smt = handler.getStatement();
			smt.setInt(1, book.getIdprenotazione());
			smt.setDate(2, book.getCheckin());
			smt.setDate(3, book.getCheckout());
			smt.setInt(4, book.getIdcamera());
			smt.setInt(5, book.getIdordine());
			handler.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public Prenotazione retrieve(Prenotazione object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Prenotazione> retrieveAll() {

		String query = "SELECT * FROM prenotazioni";
		List<Prenotazione> books = null;
		Prenotazione book = null;

		try (JDBCQueryHandler handler = new JDBCQueryHandler(query)) {

			handler.executeQuery();

			if (handler.existsResultSet()) {
				books = new ArrayList<Prenotazione>();
				ResultSet result = handler.getResultSet();
				while (result.next()) {
					book = new Prenotazione();
					book.setIdprenotazione(result.getInt("id_prenotazione"));
					book.setCheckin(result.getDate("checkin"));
					book.setCheckout(result.getDate("checkout"));
					book.setIdcamera(result.getInt("id_room"));
					book.setIdordine(result.getInt("id_order"));
					books.add(book);
				}
			}

			return books;

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public void update(Prenotazione book) {

		String update = "UPDATE prenotazioni SET checkin = ?,checkout = ?,id_room = ?, id_order = ? WHERE id_prenotazione = ?";

		try (JDBCQueryHandler handler = new JDBCQueryHandler(update)) {

			PreparedStatement smt = handler.getStatement();
			smt.setDate(1, book.getCheckin());
			smt.setDate(2, book.getCheckout());
			smt.setInt(3, book.getIdcamera());
			smt.setInt(4, book.getIdordine());
			smt.setInt(5, book.getIdprenotazione());
			handler.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public void delete(Prenotazione book) {

		String delete = "DELETE FROM prenotazioni WHERE id_prenotazione = ? ";

		try (JDBCQueryHandler handler = new JDBCQueryHandler(delete)) {

			handler.getStatement().setInt(1, book.getIdprenotazione());
			handler.getStatement().executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public boolean exists(Prenotazione object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void saveAndLink(Prenotazione input, Integer idUtente) {

		String insert = "INSERT INTO prenotazioni(checkin,checkout,id_room,id_order) SELECT ? AS checkin, ? AS checkout, ? AS idcamera, o.idorder AS idordine FROM ordine AS o WHERE o.idclient = ? AND NOT o.pagato";

		try (JDBCQueryHandler handler = new JDBCQueryHandler(insert)) {

			PreparedStatement smt = handler.getStatement();
			smt.setDate(1, input.getCheckin());
			smt.setDate(2, input.getCheckout());
			smt.setInt(3, input.getIdcamera());
			smt.setInt(4, idUtente);
			handler.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public void deletep(Integer id) {

		String delete = "DELETE FROM prenotazioni WHERE id_prenotazione = ? ";

		try (JDBCQueryHandler handler = new JDBCQueryHandler(delete)) {

			handler.getStatement().setInt(1, id);
			handler.getStatement().executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	/*
	 * @Override public ArrayList<Prenotazione> retrieve(Integer nPren, Integer
	 * maxPren) throws SQLException {
	 * 
	 * try(Connection connection = this.dataSource.getConnection()) {
	 * 
	 * ArrayList<Prenotazione> result = null; PreparedStatement maxpost =
	 * connection.
	 * prepareStatement("SELECT max(idprenotazione) AS max FROM prenotazione");
	 * ResultSet rsMax = maxpost.executeQuery(); rsMax.next(); Integer idMax = (int)
	 * rsMax.getLong("max"); if ((maxPren + nPren) == idMax) return null;
	 * 
	 * Integer from = idMax - maxPren; //maxPost + nPost - maxPost => nPost Integer
	 * to = from - nPren; //nPost - nPost => 0
	 * 
	 * PreparedStatement create = connection.
	 * prepareStatement("SELECT * FROM prenotazione WHERE idprenotazione <= ? and idprenotazione > ?"
	 * ); create.setInt(1, from); create.setInt(2, to); ResultSet rs; rs =
	 * create.executeQuery(); boolean found = true;
	 * 
	 * while (rs.next()) { if (found) { result = new ArrayList<>(); found = false; }
	 * 
	 * Prenotazione book = new Prenotazione();
	 * book.setIdPrenotazione(rs.getInt("idprenotazione"));
	 * book.setCheckin(rs.getDate("checkin"));
	 * book.setCheckout(rs.getDate("checkout"));
	 * book.setIdCamera(rs.getInt("idcamera"));
	 * book.setIdordine(rs.getInt("idordine")); result.add(book); }
	 * 
	 * if (result != null) {
	 * 
	 * ArrayList<Prenotazione> orderedPost = new ArrayList<Prenotazione>(); for (int
	 * i = result.size() - 1; i >= 0; i--) { orderedPost.add(result.get(i)); }
	 * return orderedPost; } return null;
	 * 
	 * } catch (SQLException e) { throw new PersistenceException(e.getMessage()); }
	 * }
	 */
	@Override
	public boolean existprenotazioni() {
		
		String query = "select * from prenotazioni";
		
		try (JDBCQueryHandler handler = new JDBCQueryHandler(query)) {
			handler.getStatement().executeUpdate();
			if (handler.existsResultSet()) {
				return true;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
		return false;
	}
	@Override
	public void reset(Integer id) {
		
		String query = "DELETE FROM prenotazioni AS pp USING ordine AS oo WHERE pp.id_order = oo.idorder AND oo.idorder = ? AND NOT oo.pagato";
		
		try (JDBCQueryHandler handler = new JDBCQueryHandler(query)) {

			handler.getStatement().setInt(1, id);
			handler.getStatement().executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
	}	

}