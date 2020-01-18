package persistence.postgres.jdbc;

import model.*;
import persistence.DAOFactory;
import persistence.Dao;
import persistence.dao.*;

public class PostgresDAOFactory extends DAOFactory {

	@Override
	public UserDao getUtenteDAO() {
		return new UserDaoJDBC();
	}

	@Override
	public ProdottoDao getProdottoDao() {
		return new ProdottoDaoJDBC();
	}

	@Override
	public PostDao getPostDao() {
		return new PostDaoJDBC();
	}

	@Override
	public PrenotazioneDao getPrenotazioneDao() {
		return new PrenotazioneDaoJDBC();
	}

	@Override
	public RoomDao getRoomDao() {
		return new RoomDaoJDBC();
	}
}
