package persistence.dao;

import java.util.List;

import model.nonTables.ProdottoAggregato;
import model.tables.Prodotto;
import persistence.Dao;

public interface ProdottoDao extends Dao<Prodotto> {

	public List<Prodotto> retrieveByUserID(Integer ID);

	public void connectByUserID(Integer id, Integer idProd);

	public List<Prodotto> retrieveByCategory(String descrizione);

	public List<Prodotto> retrieveByType(String tipo);

	public List<Prodotto> showProductsForShop();

	public List<ProdottoAggregato> singoloProdotto(String tipo);

	public List<Prodotto> showProductsForCart(Integer id);

	void updatesetordine(Integer idp, Integer ido);

	public void deletep(Integer id);

	public void prodottoCartRemove(Integer idprodotto);

	void updatesetdisponibile(Integer idp, Boolean val);
	
	void resetDisponibile(Integer id);
	
	public List<Prodotto> carrelloVuoto();
	
}
