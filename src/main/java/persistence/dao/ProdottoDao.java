package persistence.dao;

import java.sql.SQLException;
import java.util.List;

import model.Prodotto;
import model.ProdottoAggregato;
import persistence.Dao;
import persistence.postgres.jdbc.JDBCQueryHandler;

public interface ProdottoDao extends Dao<Prodotto> {
	
	public List<Prodotto> retrieveByUserID(Integer ID);
	public void connectByUserID(Integer id, Integer idProd);
	public List<Prodotto> retrieveByType(String tipo);
	public List<ProdottoAggregato> showProductsForShop();
	public List<ProdottoAggregato> showProductsForCart(Integer id);
	void updatesetordine(Integer idp,Integer ido);
	public void deletep(Integer id);
	public void prodottoCartRemove(Integer idprodotto);
}
