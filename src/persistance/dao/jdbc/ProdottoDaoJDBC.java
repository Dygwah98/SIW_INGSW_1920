package persistance.dao.jdbc;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.Prodotto;
import persistance.dao.ProdottoDao;
import persistence.DataSource;



public class ProdottoDaoJDBC implements ProdottoDao {
	private DataSource dataSource;

	public ProdottoDaoJDBC(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void Save(Prodotto prodotto) {
		Connection connection = null;
		try {
			connection = this.dataSource.getConnection();
			String insert = "insert into prodotto(matricola, nome, cognome,"
					+ " datanascita, scuola, corsodilaurea) values (?,?,?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setInt(1, prodotto.getId());
			statement.setString(2, prodotto.getNome());
			statement.setString(3, prodotto.getDescrizione());
			statement.setInt(4, prodotto.getPrezzo());
			statement.setString(5, prodotto.getImg());
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

	public Prodotto findByPrimaryKey(int id) {
		Connection connection = null;
		Prodotto prodotto = null;
		try {
			connection = this.dataSource.getConnection();
			PreparedStatement statement;
			String query = "select * from prodotto where matricola = ?";
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
	

	public List<Prodotto> findAll() {
		Connection connection = null;
		List<Prodotto> prodotti = new LinkedList<>();
		try {
			connection = this.dataSource.getConnection();
			Prodotto prodotto;
			PreparedStatement statement;
			String query = "select * from prodotto";
			statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				prodotto = new Prodotto();
				prodotto.setId(result.getInt("id"));				
				prodotto.setNome(result.getString("nome"));
				prodotto.setDescrizione(result.getString("descrizione"));
				prodotto.setPrezzo(result.getInt("prezzo"));
				prodotto.setImg(result.getString("img"));
				
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

	public void update(Prodotto prodotto) {
		Connection connection = null;
		try {
			connection = this.dataSource.getConnection();
			String update = "update prodotto SET nome = ?, cognome = ?, data_nascita = ?, scuola = ?, corsodilaurea = ? WHERE matricola=?";
			PreparedStatement statement = connection.prepareStatement(update);
			statement.setInt(1, prodotto.getId());
			statement.setString(2, prodotto.getNome());
			statement.setString(3, prodotto.getDescrizione());
			statement.setInt(4, prodotto.getPrezzo());
			statement.setString(5, prodotto.getImg());
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

	public void delete(Prodotto prodotto) {
		Connection connection = null;
		try {
			connection = this.dataSource.getConnection();
			String delete = "delete FROM prodotto WHERE matricola = ? ";
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


	@Override
	public model.Prodotto findByPrimaryKey(String matricola) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Prodotto Prodotto) {
		// TODO Auto-generated method stub
		
	}
	
}
