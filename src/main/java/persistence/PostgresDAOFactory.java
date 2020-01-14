package persistence;

import persistence.dao.PostDao;
import persistence.dao.PrenotazioneDao;
import persistence.dao.ProdottoDao;
import persistence.dao.RoomDao;
import persistence.dao.UserDao;

public class PostgresDAOFactory extends DAOFactory {

	private static DataSource dataSource;

	static {
		
		try {
			Class.forName("org.postgresql.Driver").newInstance();
			dataSource = new DataSource("jdbc:postgresql://sarella.cqenbowd50kg.eu-central-1.rds.amazonaws.com:5050/sarella", "riuzaki9797", "*Francesco1.,");
//			dataSource = new DataSource("jdbc:postgresql://stampy.db.elephantsql.com:5432/imdyiyek", "imdyiyek", "5v4DWc03gjBVZ2NEV9RdZKM4T7Wwch3w");
		} catch (Exception e) {
			System.err.println("PostgresDAOFactory.class: failed to load MySQL JDBC driver\n" + e);
			e.printStackTrace();
		}
	}


	@Override
	public UserDao getUtenteDAO() {
		return new UserDaoJDBC(dataSource);
	}

	@Override
	public ProdottoDao getProdottoDao() {
		return new ProdottoDaoJDBC(dataSource);
	}

	@Override
	public PostDao getPostDao() {
		return new PostDaoJDBC(dataSource);
	}

	@Override
	public PrenotazioneDao getPrenotazioneDao() {
		return new PrenotazioneDaoJDBC(dataSource);
	}

	@Override
	public RoomDao getRoomDao() {
		return new RoomDaoJDBC(dataSource);
	}

}
