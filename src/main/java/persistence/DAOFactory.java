package persistence;

import persistence.postgres.jdbc.PostgresDAOFactory;
import persistence.dao.*;

public abstract class DAOFactory {

	/**
	 * Numeric constant '1' corresponds to explicit Hsqldb choice
	 */
	public static final int HSQLDB = 1;

	/**
	 * Numeric constant '2' corresponds to explicit Postgres choice
	 */
	public static final int POSTGRESQL = 2;

	public static DAOFactory getDAOFactory(int whichFactory) {
		switch (whichFactory) {

		case HSQLDB:
			return null;
		case POSTGRESQL:
			return new PostgresDAOFactory();
		default:
			return null;
		}
	}

	// --- Factory specification: concrete factories implementing this spec must
	// provide this methods! ---

	public abstract UserDao getUtenteDao();

	public abstract PostDao getPostDao();

	public abstract PrenotazioneDao getPrenotazioneDao();

	public abstract RoomDao getRoomDao();

	public abstract ProdottoDao getProdottoDao();

	public abstract OrdineDao getOrdineDao();

	public abstract PagamentoDao getPagamentoDao();

	public abstract NewsletterDao getNewsletterDao();

}
