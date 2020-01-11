package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.Prenotazione;
import model.Room;
import persistence.dao.PrenotazioneDao;
import persistence.dao.RoomDao;
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
			String insert = "insert into Prenotazione(idprenotazione,checkin,checkout,idcamera,idcliente) values (?,?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setInt(1,book.getIdPrenotazione());
			statement.setDate(2,book.getCheckin());
			statement.setDate(3, book.getCheckout());
			statement.setInt(4,book.getIdCamera());
			statement.setInt(5,book.getIdCliente());
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
				book.setIdCliente(result.getInt("idcliente"));
				
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
			String update = "update Prenotazione SET , checkin = ?,checkout= ?,idcamera= ?,idcliente=? WHERE idprenotazione=?";
			PreparedStatement statement = connection.prepareStatement(update);
			statement.setDate(2, book.getCheckin());
			statement.setDate(3, book.getCheckout());
			statement.setInt(4, book.getIdCamera());
			statement.setInt(5, book.getIdCliente());
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
	
	
	
	
	
	
}