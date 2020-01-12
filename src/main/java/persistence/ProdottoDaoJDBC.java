package persistence;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.Prodotto;
import persistence.dao.ProdottoDao;
import persistence.DataSource;



public class ProdottoDaoJDBC implements ProdottoDao {
	private DataSource dataSource;

	public ProdottoDaoJDBC(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public void save(Prodotto prodotto) {
		Connection connection = null;
		try {
			connection = this.dataSource.getConnection();
			String insert = "insert into Prodotto(id, nome, prezzo,descrizione,img,idordine) values (?,?,?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setInt(1, prodotto.getId());
			statement.setString(2, prodotto.getNome());
			statement.setString(3, prodotto.getDescrizione());
			statement.setInt(4, prodotto.getPrezzo());
			statement.setString(5, prodotto.getImg());
			statement.setInt(6, prodotto.getIdordine());
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
	public Prodotto findByPrimaryKey(int id) {
		Connection connection = null;
		Prodotto prodotto = null;
		try {
			connection = this.dataSource.getConnection();
			PreparedStatement statement;
			String query = "select * from Prodotto where id = ?";
			statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				prodotto = new Prodotto();
				prodotto.setId(result.getInt("id"));				
				prodotto.setNome(result.getString("nome"));
				prodotto.setDescrizione(result.getString("descrizione"));
				prodotto.setPrezzo(result.getInt("prezzo"));
				prodotto.setImg(result.getString("img"));
				prodotto.setIdordine(result.getInt("idordine"));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}	
		return prodotto;
	}
	
	@Override
	public List<Prodotto> findAll() {
		Connection connection = null;
		List<Prodotto> prodotti = new LinkedList<>();
		try {
			connection = this.dataSource.getConnection();
			Prodotto prodotto;
			PreparedStatement statement;
			String query = "select * from Prodotto";
			statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				prodotto = new Prodotto();
				prodotto.setId(result.getInt("id"));				
				prodotto.setNome(result.getString("nome"));
				prodotto.setDescrizione(result.getString("descrizione"));
				prodotto.setPrezzo(result.getInt("prezzo"));
				prodotto.setImg(result.getString("img"));
				prodotto.setIdordine(result.getInt("idordine"));
				
				prodotti.add(prodotto);
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
		return prodotti;
	}
	@Override
	public void update(Prodotto prodotto) {
		Connection connection = null;
		try {
			connection = this.dataSource.getConnection();
			String update = "update Prodotto SET nome = ?, descrizione=?,prezzo=?,img=? idordine=? WHERE id=?";
			PreparedStatement statement = connection.prepareStatement(update);
			statement.setString(2, prodotto.getNome());
			statement.setString(3, prodotto.getDescrizione());
			statement.setInt(4, prodotto.getPrezzo());
			statement.setString(5, prodotto.getImg());
			statement.setInt(6, prodotto.getIdordine());
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
	public void delete(Prodotto prodotto) {
		Connection connection = null;
		try {
			connection = this.dataSource.getConnection();
			String delete = "delete FROM Prodotto WHERE id = ? ";
			PreparedStatement statement = connection.prepareStatement(delete);
			statement.setInt(1, prodotto.getId());
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
