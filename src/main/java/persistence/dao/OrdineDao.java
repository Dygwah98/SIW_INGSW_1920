package persistence.dao;

import model.Ordine;
import persistence.Dao;

public interface OrdineDao extends Dao<Ordine> {
	
	public void pay(Integer userId);
}