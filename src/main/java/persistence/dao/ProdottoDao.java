package persistence.dao;

import java.util.List;

import model.Prodotto;
import persistence.Dao;

public interface ProdottoDao extends Dao<Prodotto> {
	
	public List<Prodotto> retrieveByUserID(Integer ID);
	public void connectByUserID(Integer id, Integer idProd);
	public Prodotto retrieveByType(String tipo);
}
