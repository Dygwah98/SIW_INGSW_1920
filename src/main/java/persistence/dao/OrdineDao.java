package persistence.dao;

import java.util.List;

import model.Ordine;
import model.Prenotazione;
import model.Prodotto;
import persistence.Dao;

public interface OrdineDao extends Dao<Ordine> {
	public List<Prodotto> retrieveProdotti(Integer idcliente);
	public List<Prenotazione> retrievePrenotazioni(Integer idcliente);
	public void pay(Integer userId);
	public List<Integer> retrieveprezzocamere(Integer id);
	Integer retrieveidorder(Integer idclient);
}