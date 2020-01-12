package persistence.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Prodotto;

public interface ProdottoDao {
	
	public void save(Prodotto Prodotto);  // Create
	public Prodotto findByPrimaryKey(int Id);     // Retrieve
	public List<Prodotto> findAll();       
	public void update(Prodotto Prodotto); //Update
	public void delete(Prodotto Prodotto); //Delete	
	public ArrayList<Prodotto> retrieve(Integer nProd, Integer maxProd) throws SQLException;
}
