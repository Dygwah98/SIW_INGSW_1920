package persistence.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Prenotazione;
import persistence.Dao;

public interface PrenotazioneDao extends Dao<Prenotazione> {
	
	public void saveAndLink(Prenotazione input, Integer idUtente);
}