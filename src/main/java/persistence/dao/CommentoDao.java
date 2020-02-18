package persistence.dao;

import java.util.List;

import model.tables.Commento;
import model.tables.Prenotazione;
import persistence.Dao;

public interface CommentoDao extends Dao<Commento> {
	public List<Commento> commentiPerPost(Integer idPost);
}
