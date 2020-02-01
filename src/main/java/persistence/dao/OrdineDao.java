package persistence.dao;

import java.util.List;

import model.nonTables.OrdineConPrezzo;
import model.tables.Ordine;
import model.tables.Prenotazione;
import model.tables.Prodotto;
import persistence.Dao;

public interface OrdineDao extends Dao<Ordine> {
	public List<Prodotto> retrieveProdotti(Integer idcliente);

	public List<Prenotazione> retrievePrenotazioni(Integer idcliente);

	public void pay(Integer userId);

	public List<Integer> retrievePrezzoCamere(Integer id);

	Integer retrieveIdOrder(Integer idclient);

	public List<OrdineConPrezzo> getOrderHistory(Integer idCliente);
}