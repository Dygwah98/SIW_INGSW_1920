package persistence.postgres.jdbc;

import java.sql.SQLException;
import java.util.List;

import model.tables.MetodoPagamento;
import persistence.dao.MetodoPagamentoDao;

public class MetodoPagamentoDaoJDBC implements MetodoPagamentoDao {

	@Override
	public void save(MetodoPagamento object) {
		
		String query = "INSERT INTO metodo_pagamento(ccv, numero_carta, data_scadenza, id_cliente, scelta) VALUES(?, ?, ?, ?, ?)";
		
		try(JDBCQueryHandler handler = new JDBCQueryHandler(query)) {
			
			handler.getStatement().setInt(1, object.getCcv());
			handler.getStatement().setInt(2, object.getNumeroCarta());
			handler.getStatement().setDate(3, object.getDataScadenza());
			handler.getStatement().setInt(4, object.getIdCliente());
			handler.getStatement().setBoolean(5, object.isMetodoDiDefault());
			handler.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public MetodoPagamento retrieve(MetodoPagamento object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MetodoPagamento> retrieveAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(MetodoPagamento object) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(MetodoPagamento object) {

		String query = "DELETE FROM metodo_pagamento WHERE id_metodo = ?";
		
		try(JDBCQueryHandler handler = new JDBCQueryHandler(query)) {
			
			handler.getStatement().setInt(1, object.getIdMetodoPagamento());
			handler.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean findidproductbyid(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

}
