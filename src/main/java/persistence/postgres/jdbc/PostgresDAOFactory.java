package persistence.postgres.jdbc;

import model.*;
import persistence.DAOFactory;
import persistence.Dao;

public class PostgresDAOFactory extends DAOFactory {

	@Override
	public Dao<User> getUtenteDAO() {
		return new UserDaoJDBC();
	}

	@Override
	public Dao<Prodotto> getProdottoDao() {
		return new ProdottoDaoJDBC();
	}

	@Override
	public Dao<Post> getPostDao() {
		return new PostDaoJDBC();
	}

	@Override
	public Dao<Prenotazione> getPrenotazioneDao() {
		return new PrenotazioneDaoJDBC();
	}

	@Override
	public Dao<Room> getRoomDao() {
		return new RoomDaoJDBC();
	}
}
