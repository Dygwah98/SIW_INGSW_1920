package persistence.postgres.jdbc;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.tables.Pagamento;
import persistence.dao.PagamentoDao;

public class PagamentoDaoJDBC implements PagamentoDao {

	@Override
	public void save(Pagamento object) {

		String query = "INSERT INTO pagamento(importo, id_ordine, data_pagamento) VALUES(?,?,?)";

		try (JDBCQueryHandler handler = new JDBCQueryHandler(query)) {

			handler.getStatement().setInt(1, object.getImporto());
			handler.getStatement().setInt(2, object.getid_ordine());
			handler.getStatement().setDate(3, object.getdata_pagamento());
			
			handler.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Pagamento retrieve(Pagamento object) {

		String query = "SELECT * FROM pagamento WHERE id_pagamento = ?";
		Pagamento p = null;

		try (JDBCQueryHandler handler = new JDBCQueryHandler(query)) {

			handler.getStatement().setInt(1, object.getid_pagamento());
			handler.executeQuery();

			if (handler.existsResultSet()) {

				handler.getResultSet().next();
				p = new Pagamento();
				p.setid_pagamento(handler.getResultSet().getInt("id_pagamento"));
				p.setImporto(handler.getResultSet().getInt("importo"));
				p.setid_ordine(handler.getResultSet().getInt("id_ordine"));

				p.setdata_pagamento(handler.getResultSet().getDate("data_pagamento"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return p;
	}

	@Override
	public List<Pagamento> retrieveAll() {

		String query = "SELECT * FROM pagamento";
		ArrayList<Pagamento> P = null;

		try (JDBCQueryHandler handler = new JDBCQueryHandler(query)) {

			handler.executeQuery();
			if (handler.existsResultSet()) {

				P = new ArrayList<Pagamento>();
				Pagamento p = null;
				while (handler.getResultSet().next()) {
					p = new Pagamento();
					p.setid_pagamento(handler.getResultSet().getInt("id_pagamento"));
					p.setImporto(handler.getResultSet().getInt("importo"));
					p.setid_ordine(handler.getResultSet().getInt("id_ordine"));
					p.setdata_pagamento(handler.getResultSet().getDate("data_pagamento"));
					P.add(p);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return P;
	}

	@Override
	public void update(Pagamento object) {

	}

	@Override
	public void delete(Pagamento object) {

		String query = "DELETE FROM pagamento WHERE id_pagamento = ?";

		try (JDBCQueryHandler handler = new JDBCQueryHandler(query)) {

			handler.getStatement().setInt(1, object.getid_pagamento());
			handler.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean exists(Pagamento object) {

		return retrieve(object) != null;
	}

}
