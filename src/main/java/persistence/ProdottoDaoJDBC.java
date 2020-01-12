package persistence;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import model.Post;
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

	@Override
	public ArrayList<Prodotto> retrieve(Integer nProd, Integer maxProd) {
		
		ArrayList<Prodotto> result = null;
		Connection connection = null;
		try {
			connection = this.dataSource.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			PreparedStatement maxpost = connection.prepareStatement("SELECT max(id) AS max FROM prodotto");
			ResultSet rsMax = maxpost.executeQuery();
			rsMax.next();
			Integer idMax = (int) rsMax.getLong("max");
			if ((maxProd + nProd) == idMax)
				return null;

			Integer from = idMax - maxProd; //maxPost + nPost - maxPost => nPost
			Integer to = from - nProd;      //nPost - nPost             => 0

			PreparedStatement create = connection.prepareStatement("SELECT * FROM prodotto WHERE id <= ? and id > ?");
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

				Prodotto prodotto = new Prodotto();
				
				prodotto.setId(rs.getInt("id"));				
				prodotto.setNome(rs.getString("nome"));
				prodotto.setDescrizione(rs.getString("descrizione"));
				prodotto.setPrezzo(rs.getInt("prezzo"));
				prodotto.setImg(rs.getString("img"));
				prodotto.setIdordine(rs.getInt("idordine"));
				
				result.add(prodotto);
			}

			if (result != null) {

				ArrayList<Prodotto> orderedPost = new ArrayList<Prodotto>();
				for (int i = result.size() - 1; i >= 0; i--) {
					orderedPost.add(result.get(i));
				}
				return orderedPost;
			}
			return null;
			
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}
	}
}
