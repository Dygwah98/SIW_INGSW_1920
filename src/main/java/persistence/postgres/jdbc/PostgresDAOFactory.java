package persistence.postgres.jdbc;

import persistence.DAOFactory;
import persistence.dao.*;

public class PostgresDAOFactory extends DAOFactory {

	@Override
	public UserDao getUtenteDao() {
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

	@Override
	public OrdineDao getOrdineDao() {
		return new OrdineDaoJDBC();
	}

	@Override
	public PagamentoDao getPagamentoDao() {
		return new PagamentoDaoJDBC();
	}

	@Override
	public NewsletterDao getNewsletterDao() {
		return new NewsletterDaoJDBC();
	}
}
