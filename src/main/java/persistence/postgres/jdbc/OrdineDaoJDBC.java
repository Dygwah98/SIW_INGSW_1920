package persistence.postgres.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Ordine;
import model.Prenotazione;
import model.Prodotto;
import persistence.dao.OrdineDao;

public class OrdineDaoJDBC implements OrdineDao {

	@Override
	public void save(Ordine ordine) {
		
		String insert = "INSERT INTO order(idOrder,idClient) VALUES (?,?)";
		
		try(JDBCQueryHandler handler = new JDBCQueryHandler(insert)) {
			
			handler.getStatement().setInt(1,ordine.getIdOrdine());
			handler.getStatement().setInt(2, ordine.getIdUtente());
			
			handler.executeUpdate();
		
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
	public Ordine retrieve(Ordine object) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Ordine> retrieveAll() {
		// TODO Auto-generated method stub
		return null;
	}
	public List<Prenotazione> retrievePrenotazioni(Integer idcliente){
		String c="Select p.idprenotazione,p.checkin,p.checkout,p.idcamera,p.idordine from ordine as o,prenotazione as p where o.idOrder=p.idordine and o.idClient=? and o.pagato=false"; 
		List<Prenotazione> p = null;
		Prenotazione pre = null;
		
		try(JDBCQueryHandler handler = new JDBCQueryHandler(c)) {
			
			handler.getStatement().setInt(1, idcliente);
			handler.executeQuery();
			
			if(handler.existsResultSet()) {
				p = new ArrayList<Prenotazione>();
				ResultSet result = handler.getResultSet();
				while (result.next()) {
					pre = new Prenotazione();
					pre.setIdprenotazione(result.getInt("idprenotazione"));				
					pre.setCheckin(result.getString("checkin"));
					pre.setCheckout(result.getString("checkout"));
					pre.setIdcamera(result.getInt("idcamera"));
					pre.setIdordine(result.getInt("idordine"));
					p.add(pre);
				}
			}
			
			return p;
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}	
	}
	public List<Prodotto> retrieveProdotti(Integer idcliente){
		String c="Select p.idprodotto,p.tipo,p.descrizione,p.prezzo,p.disponibile,p.img,p.idordine from ordine as o,prenotazione as p where o.idOrder=p.idordine and o.idClient=? and o.pagato=false"; 
		List<Prodotto> books = null;
		Prodotto book = null;
		try(JDBCQueryHandler handler = new JDBCQueryHandler(c)) {
			handler.getStatement().setInt(1,idcliente);
			handler.executeQuery();
			
			if(handler.existsResultSet()) {
				books = new ArrayList<Prodotto>();
				ResultSet result = handler.getResultSet();
				while (result.next()) {
					book = new Prodotto();
					book.setIdprodotto(result.getInt("idprodotto"));				
					book.setTipo(result.getString("tipo"));
					book.setDescrizione(result.getString("descrizione"));
					book.setPrezzo(result.getInt("prezzo"));
					book.setDisponibile(result.getBoolean("disponibile"));
					book.setTipo(result.getString("img"));
					book.setIdordine(result.getInt("idordine"));
					books.add(book);
				}
			}
			
			return books;
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
		
	}
}

	