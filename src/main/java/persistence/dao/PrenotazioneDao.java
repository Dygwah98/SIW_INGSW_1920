package persistence.dao;

import java.util.List;

import model.Prenotazione;
import model.Room;

public interface PrenotazioneDao {
	
	public void save(Prenotazione book);  // Create
	public List<Prenotazione> findAll();       
	public void update(Prenotazione book); //Update
	public void delete(Prenotazione book); //Delete	
}