package persistence.dao;

import java.util.List;

import model.Prodotto;

public interface ProdottoDao {
	
	public void save(Prodotto Prodotto);  // Create
	public Prodotto findByPrimaryKey(int Id);     // Retrieve
	public List<Prodotto> findAll();       
	public void update(Prodotto Prodotto); //Update
	public void delete(Prodotto Prodotto); //Delete	
}
