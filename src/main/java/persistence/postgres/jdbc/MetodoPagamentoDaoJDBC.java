package persistence.postgres.jdbc;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.tables.MetodoPagamento;
import persistence.dao.MetodoPagamentoDao;

public class MetodoPagamentoDaoJDBC implements MetodoPagamentoDao {

	@Override
	public void save(MetodoPagamento object) {
		
		String query = "INSERT INTO metodo_pagamento(ccv, numero_carta, data_scadenza, id_cliente, scelta) VALUES(?,?,?,?,?)";
		
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

		String query = "SELECT * FROM metodo_pagamento WHERE id_metodo = ?";
		MetodoPagamento p = null;
		
		try(JDBCQueryHandler handler = new JDBCQueryHandler(query)) {
		
			handler.getStatement().setInt(1, object.getIdMetodoPagamento());
			handler.executeQuery();
			
			if(handler.existsResultSet()) {
			
				handler.getResultSet().next();
				p = new MetodoPagamento();
				p.setIdMetodoPagamento(handler.getResultSet().getInt("id_metodo"));
				p.setCcv(handler.getResultSet().getInt("ccv"));
				p.setNumeroCarta(handler.getResultSet().getInt("numero_carta"));
				p.setDataScadenza(handler.getResultSet().getDate("data_scadenza"));
				p.setIdCliente(handler.getResultSet().getInt("id_cliente"));
				p.setMetodoDiDefault(handler.getResultSet().getBoolean("scelta"));
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return p;
	}

	@Override
	public List<MetodoPagamento> retrieveAll() {
		
		String query = "SELECT * FROM metodo_pagamento";
		ArrayList<MetodoPagamento> mp = null;
		
		try(JDBCQueryHandler handler = new JDBCQueryHandler(query)) {
		
			handler.executeQuery();
			
			if(handler.existsResultSet()) {
				
				mp = new ArrayList<MetodoPagamento>();
				MetodoPagamento p = null;
				
				while(handler.getResultSet().next()) {
					
					p = new MetodoPagamento();
					
					p.setIdMetodoPagamento(handler.getResultSet().getInt("id_metodo"));
					p.setCcv(handler.getResultSet().getInt("ccv"));
					p.setNumeroCarta(handler.getResultSet().getInt("numero_carta"));
					p.setDataScadenza(handler.getResultSet().getDate("data_scadenza"));
					p.setIdCliente(handler.getResultSet().getInt("id_cliente"));
					p.setMetodoDiDefault(handler.getResultSet().getBoolean("scelta"));
					
					mp.add(p);
				}
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mp;
	
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
	public boolean exists(MetodoPagamento object) {
		
		return retrieve(object) != null;
	}

}
