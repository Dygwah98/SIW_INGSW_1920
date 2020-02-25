package persistence.dao;

import java.util.List;

import model.tables.Commento;
import persistence.Dao;

public interface CommentoDao extends Dao<Commento> {
	public List<Commento> commentiPerPost(Integer idPost);
}
