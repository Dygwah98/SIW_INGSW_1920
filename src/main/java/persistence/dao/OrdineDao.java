package persistence.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Ordine;
import model.Prenotazione;

public interface OrdineDao {
	
	public void save(Ordine ordine);  // Create
	public List<Ordine> findAll();       
	public void update(Ordine ordine); //Update
	public void delete(Ordine ordine); //Delete	
	public ArrayList<Ordine> retrieve(Integer nOrdine, Integer maxOrdine) throws SQLException;
	public ArrayList<Prenotazione> retrieve1(Integer nOrdine, Integer maxOrdine) throws SQLException;
}