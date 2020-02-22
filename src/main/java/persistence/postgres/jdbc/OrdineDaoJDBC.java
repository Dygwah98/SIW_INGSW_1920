package persistence.postgres.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.nonTables.OrdineConPrezzo;
import model.tables.Ordine;
import model.tables.Prenotazione;
import model.tables.Prodotto;
import persistence.dao.OrdineDao;

public class OrdineDaoJDBC implements OrdineDao {

	@Override
	public void save(Ordine ordine) {

		String insert = "INSERT INTO ordine(idclient,pagato) VALUES (?,?)";

		try (JDBCQueryHandler handler = new JDBCQueryHandler(insert)) {

			handler.getStatement().setInt(1, ordine.getIdUtente());
			handler.getStatement().setBoolean(2, ordine.getPagato());

			handler.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public Ordine retrieve(Ordine object) {

		String query = "SELECT idorder FROM ordine WHERE idorder = ?";
		Ordine ord = null;

		try (JDBCQueryHandler handler = new JDBCQueryHandler(query)) {

			handler.getStatement().setInt(1, object.getIdOrdine());
			handler.executeQuery();

			if (handler.existsResultSet()) {

				handler.getResultSet().next();
				ord = new Ordine();
				ord.setIdOrdine(handler.getResultSet().getInt("idorder"));
				ord.setIdUtente(handler.getResultSet().getInt("idclient"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ord;
	}

	@Override
	public List<Ordine> retrieveAll() {
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
	public void eliminaOrdine(Integer ID) {
		String delete = "delete FROM ordine WHERE idorder = ? ";

		try (JDBCQueryHandler handler = new JDBCQueryHandler(delete)) {

			handler.getStatement().setInt(1, ID);
			handler.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
	@Override
	public boolean exists(Ordine object) {

		return retrieve(object) != null;
	}

	@Override
	public List<Prodotto> retrieveProdotti(Integer idcliente) {
		String c = "Select p.idprodotto,p.tipo,p.descrizione,p.prezzo,p.disponibile,p.img,p.idordine from ordine as o,prenotazione as p where o.idorder=p.idordine and o.idclient=? and o.pagato=false";
		List<Prodotto> books = null;
		Prodotto book = null;
		try (JDBCQueryHandler handler = new JDBCQueryHandler(c)) {
			handler.getStatement().setInt(1, idcliente);
			handler.executeQuery();

			if (handler.existsResultSet()) {
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

	@Override
	public List<Prenotazione> retrievePrenotazioni(Integer idcliente) {
		String c = "Select p.id_prenotazione,p.checkin,p.checkout,p.id_room,p.id_order from ordine as o,prenotazioni as p where o.idorder=p.id_order and o.idclient=? and o.pagato=false";
		List<Prenotazione> p = null;
		Prenotazione pre = null;

		try (JDBCQueryHandler handler = new JDBCQueryHandler(c)) {

			handler.getStatement().setInt(1, idcliente);
			handler.executeQuery();

			if (handler.existsResultSet()) {
				p = new ArrayList<Prenotazione>();
				ResultSet result = handler.getResultSet();
				while (result.next()) {
					pre = new Prenotazione();
					pre.setIdprenotazione(result.getInt("id_prenotazione"));
					pre.setCheckin(result.getDate("checkin"));
					pre.setCheckout(result.getDate("checkout"));
					pre.setIdcamera(result.getInt("id_room"));
					pre.setIdordine(result.getInt("id_order"));
					p.add(pre);
				}
			}

			return p;

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public void pay(Integer userId) {

		String query = "UPDATE ordine SET pagato =true WHERE idclient = ? AND pagato=false";

		try (JDBCQueryHandler handler = new JDBCQueryHandler(query)) {

			handler.getStatement().setInt(1, userId);
			handler.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Integer> retrievePrezzoCamere(Integer id) {
		String prezzo = "Select r.prezzo as pre from room as r,prenotazioni as p,ordine as o where r.idcamera=p.id_room and p.id_order=o.idorder and o.pagato=false and o.idclient=? ";
		List<Integer> soldi = null;
		Integer soldo = null;
		try (JDBCQueryHandler handler = new JDBCQueryHandler(prezzo)) {
			handler.getStatement().setInt(1, id);
			handler.executeQuery();

			if (handler.existsResultSet()) {
				soldi = new ArrayList<Integer>();
				ResultSet result = handler.getResultSet();
				while (result.next()) {
					soldo = new Integer(result.getInt("pre"));
					soldi.add(soldo);
				}

			}
			return soldi;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Integer retrieveIdOrder(Integer idclient) {
		String ord = "select idorder from ordine where idclient=? and pagato=false";
		Integer idord = null;
		try (JDBCQueryHandler handler = new JDBCQueryHandler(ord)) {
			handler.getStatement().setInt(1, idclient);
			handler.executeQuery();

			if (handler.existsResultSet()) {
				ResultSet result = handler.getResultSet();
				result.next();
				return idord = new Integer(result.getInt("idorder"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public List<OrdineConPrezzo> getOrderHistory(Integer idCliente) {

		String query = "SELECT idorder, price FROM get_order_history WHERE idclient = ?";
		List<OrdineConPrezzo> ord = null;

		try (JDBCQueryHandler handler = new JDBCQueryHandler(query)) {

			handler.getStatement().setInt(1, idCliente);
			handler.executeQuery();

			if (handler.existsResultSet()) {

				ord = new ArrayList<OrdineConPrezzo>();
				ResultSet result = handler.getResultSet();
				OrdineConPrezzo temp;
				while (result.next()) {
					temp = new OrdineConPrezzo();
					temp.setIdOrdine(result.getInt("idorder"));
					temp.setPrice(result.getInt("price"));
					ord.add(temp);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ord;
	}
}
