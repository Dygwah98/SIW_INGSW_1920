package persistence.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Prenotazione;

public interface PrenotazioneDao {
	
	public void save(Prenotazione book);  // Create
	public List<Prenotazione> findAll();       
	public void update(Prenotazione book); //Update
	public void delete(Prenotazione book); //Delete	
	public ArrayList<Prenotazione> retrieve(Integer nPren, Integer maxPren) throws SQLException;

}