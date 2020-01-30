package persistence.dao;

import java.sql.SQLException;
import java.util.List;

import model.nonTables.ProdottoAggregato;
import model.tables.Prodotto;
import persistence.Dao;
import persistence.postgres.jdbc.JDBCQueryHandler;

public interface ProdottoDao extends Dao<Prodotto> {
	
	public List<Prodotto> retrieveByUserID(Integer ID);
	public void connectByUserID(Integer id, Integer idProd);
	public List<ProdottoAggregato> retrieveByCategory(String descrizione);
	public List<ProdottoAggregato> retrieveByType(String tipo);
	public List<ProdottoAggregato> showProductsForShop();
	public List<ProdottoAggregato> singoloProdotto(String tipo);
	public List<ProdottoAggregato> showProductsForCart(Integer id);
	void updatesetordine(Integer idp,Integer ido);
	public void deletep(Integer id);
	public void prodottoCartRemove(Integer idprodotto);
	void updatesetdisponibile(Integer idp, Boolean val);
}
