package persistence.dao;

import model.tables.Prenotazione;
import persistence.Dao;

public interface PrenotazioneDao extends Dao<Prenotazione> {

	public void saveAndLink(Prenotazione input, Integer idUtente);

	public void deletep(Integer id);
}