package persistence.postgres.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Prodotto;
import persistence.DBManager;
import persistence.Dao;

public class ProdottoDaoJDBC implements Dao<Prodotto> {
	
	public void save(Prodotto prodotto) {

		try(Connection connection = DBManager.getInstance().getDataSource().getConnection()) {
			
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
		}
	}  
	
	@Override
	public List<Prodotto> retrieveBy(String column, Object value) {

		try(Connection connection = DBManager.getInstance().getDataSource().getConnection()) {

			List<Prodotto> prodotto = null;
			Prodotto temp = null;
			
			PreparedStatement statement;
			String query = "select * from Prodotto where ? = ?";
			statement = connection.prepareStatement(query);
			statement.setString(1, column);
			statement.setObject(2, value);
			
			ResultSet result = statement.executeQuery();
			
			if(result.isBeforeFirst()) {
				prodotto = new ArrayList<Prodotto>();
				
					while(result.next()) {
						temp = new Prodotto();
						temp.setId(result.getInt("id"));				
						temp.setNome(result.getString("nome"));
						temp.setDescrizione(result.getString("descrizione"));
						temp.setPrezzo(result.getInt("prezzo"));
						temp.setImg(result.getString("img"));
						temp.setIdordine(result.getInt("idordine"));
						prodotto.add(temp);
					}
			}
			return prodotto;
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
	@Override
	public List<Prodotto> retrieveAll() {
		
		try(Connection connection = DBManager.getInstance().getDataSource().getConnection()) {
		
			List<Prodotto> prodotti = null;
			Prodotto prodotto = null;
			
			PreparedStatement statement;
			String query = "select * from Prodotto";
			statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			
			if(result.isBeforeFirst()) {
				prodotti = new ArrayList<Prodotto>();
			
				while(result.next()) {
					prodotto = new Prodotto();
					prodotto.setId(result.getInt("id"));				
					prodotto.setNome(result.getString("nome"));
					prodotto.setDescrizione(result.getString("descrizione"));
					prodotto.setPrezzo(result.getInt("prezzo"));
					prodotto.setImg(result.getString("img"));
					prodotto.setIdordine(result.getInt("idordine"));
					prodotti.add(prodotto);
				}
			}
		
			return prodotti;
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
	@Override
	public void update(Prodotto prodotto) {
		
		try(Connection connection = DBManager.getInstance().getDataSource().getConnection()) {
			
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
		}
	}
	
	@Override
	public void delete(Prodotto prodotto) {

		try(Connection connection = DBManager.getInstance().getDataSource().getConnection()) {
			
			String delete = "delete FROM Prodotto WHERE id = ? ";
			PreparedStatement statement = connection.prepareStatement(delete);
			statement.setInt(1, prodotto.getId());
			statement.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
	}
/*
	@Override
	public ArrayList<Prodotto> retrieve(Integer nProd, Integer maxProd) {
		
		try(Connection connection = this.dataSource.getConnection()) {
		
			ArrayList<Prodotto> result = null;
			
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
		}
	}
*/
	@Override
	public List<Prodotto> retrieve(Prodotto object) {
		// TODO Auto-generated method stub
		return null;
	}
}
