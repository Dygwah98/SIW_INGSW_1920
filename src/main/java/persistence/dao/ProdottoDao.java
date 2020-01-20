package persistence.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Prenotazione;
import model.Prodotto;
import persistence.Dao;

public interface ProdottoDao extends Dao<Prodotto> {
	abstract public List<Prodotto> retrieveByUserID(Integer ID);
	abstract public void connectByUserID(Integer ID, Prodotto p);
}
