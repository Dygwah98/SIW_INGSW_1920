package persistence.postgres.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.nonTables.ProdottoAggregato;
import model.tables.Commento;
import model.tables.Post;
import model.tables.Prodotto;
import persistence.dao.CommentoDao;

public class CommentoDaoJDBC implements CommentoDao {

	@Override
	public void save(Commento c) {
		String insert = "INSERT INTO commento(testo,username_cliente,idpost,img_utente,valutazione) VALUES (?,?,?,?,?)";
		try (JDBCQueryHandler handler = new JDBCQueryHandler(insert)) {

			PreparedStatement smt = handler.getStatement();

			smt.setString(1, c.getTesto());
			smt.setString(2, c.getUsername_cliente());
			smt.setInt(3,  c.getIdpost());
			smt.setString(4, c.getImg_utente());
			smt.setString(5, c.getValutazione());

			handler.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public Commento retrieve(Commento object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Commento> retrieveAll() {
		String query = "SELECT * FROM commento";
		Commento c = null;
		List<Commento> commenti = null;

		try (JDBCQueryHandler handler = new JDBCQueryHandler(query)) {
			handler.executeQuery();

			if (handler.existsResultSet()) {
				commenti = new ArrayList<Commento>();
				ResultSet result = handler.getResultSet();

				while (result.next()) {
					c = new Commento();
					c.setIdcommento(result.getInt("idcommento"));
					c.setTesto(result.getString("testo"));
					c.setUsername_cliente(result.getString("username_cliente"));
					c.setIdpost(result.getInt("idpost"));
					c.setImg_utente(result.getString("img_utente"));
					c.setValutazione(result.getString("valutazione"));
					commenti.add(c);

				}
			}

			return commenti;

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}

	}

	@Override
	public void update(Commento object) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Commento object) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean exists(Commento object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Commento> commentiPerPost(Integer idPost) {
		
		String query = "SELECT * FROM commento where idpost = ?";
		Commento c = null;
		List<Commento> commenti = null;

		try (JDBCQueryHandler handler = new JDBCQueryHandler(query)) {

			handler.getStatement().setInt(1, idPost);
			handler.executeQuery();

			if (handler.existsResultSet()) {
				commenti = new ArrayList<Commento>();
				ResultSet result = handler.getResultSet();

				while (result.next()) {
					c = new Commento();
					c.setIdcommento(result.getInt("idcommento"));
					c.setTesto(result.getString("testo"));
					c.setUsername_cliente(result.getString("username_cliente"));
					c.setIdpost(result.getInt("idpost"));
					c.setImg_utente(result.getString("img_utente"));
					c.setValutazione(result.getString("valutazione"));
					commenti.add(c);

				}
			}

			return commenti;

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}

	}
}
