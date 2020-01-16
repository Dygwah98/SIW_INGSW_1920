package persistence;

import model.*;
import persistence.postgres.jdbc.PostgresDAOFactory;

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
		switch ( whichFactory ) {
		
		case HSQLDB:
			return null;
		case POSTGRESQL:
			return new PostgresDAOFactory();
		default:
			return null;
		}
	}
	
	
	
	// --- Factory specification: concrete factories implementing this spec must provide this methods! ---
		
	public abstract Dao<User> getUtenteDAO();
	
	public abstract Dao<Post> getPostDao();

	public abstract Dao<Prenotazione> getPrenotazioneDao();
	
	public abstract Dao<Room> getRoomDao();

	public abstract Dao<Prodotto> getProdottoDao();
	
}
