package persistence.postgres.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.Post;
import persistence.PersistenceException;
import persistence.dao.PostDao;

public class PostDaoJDBC implements PostDao {

	private final int getNextId(final Connection connection) {
		try {
			PreparedStatement statement;
			final String query = "select id_post from post;";
			statement = connection.prepareStatement(query, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet result = statement.executeQuery();

			if (result.last()) {
				int tmp = result.getInt("id_post");
				return ++tmp;
			}
			return 0;

		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}
	}
	
	@Override
	public void save(Post post) {

		String insert = "insert into post(id_post, title, messaggio, id_utente, imgsrc, date) values (?,?,?,?,?,?)";
		
		try(JDBCQueryHandler handler = new JDBCQueryHandler(insert)) {
			
			int id = getNextId(handler.getConnection());
			PreparedStatement smt = handler.getStatement();
			smt.setLong(1, id);
			smt.setString(2, post.getTitle());
			smt.setString(3, post.getMessaggio());
			smt.setString(4, post.getUtente());
			smt.setString(5, post.getImgname());
			smt.setDate(6, post.getData());
			handler.executeUpdate();
			
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		}

	}

	@Override
	public void delete(Post object) {
		
		String delete = "delete from post where id_post = " + object.getIdPost();
		
		try(JDBCQueryHandler handler = new JDBCQueryHandler(delete)) {

			handler.getStatement().executeUpdate();
		
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		}
	}
/*
	@Override
	public ArrayList<Post> retrieve(Integer nPost, Integer maxPost) throws SQLException {
		
		ArrayList<Post> result = null;
		Connection connection = null;
		try {
			connection = this.dataSource.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			PreparedStatement maxpost = connection.prepareStatement("SELECT max(id_post) from post");
			ResultSet rsMax = maxpost.executeQuery();
			rsMax.next();
			Integer idMax = (int) rsMax.getLong("max");
			if ((maxPost + nPost) == idMax)
				return null;

			Integer from = idMax - maxPost; //maxPost + nPost - maxPost => nPost
			Integer to = from - nPost;      //nPost - nPost             => 0

			PreparedStatement create = connection.prepareStatement("SELECT * FROM post WHERE id_post <= ? and id_post > ?");
			create.setInt(1, from);
			create.setInt(2, to);
			ResultSet rs;
			rs = create.executeQuery();
			boolean found = true;

			while (rs.next()) {
				if (found) {
					result = new ArrayList<>();
					found = false;
				}

				Long id = rs.getLong("id_post");
				String title = rs.getString("title");
				String message = rs.getString("messaggio");
				String idUtente = rs.getString("id_utente");
				String imgsrc = rs.getString("imgsrc");
				Date data = rs.getDate("date");

				Post post = new Post(); // Creating a user object to fill with
										// user data
				post.setIdPost(id);
				post.setTitle(title);
				post.setMessaggio(message);
				post.setUtente(idUtente);
				post.setImgname(imgsrc);
				post.setData(data);
				// Add the retrived user to the list
				result.add(post);
			}

			if (result != null) {

				ArrayList<Post> orderedPost = new ArrayList<Post>();
				for (int i = result.size() - 1; i >= 0; i--) {
					orderedPost.add(result.get(i));
				}
				return orderedPost;
			}
			return null;
			
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}
	}
*/
	@Override
	public Post retrieve(Post object) {
		return null;
	}


	@Override
	public List<Post> retrieveAll() {
		return null;
	}

	@Override
	public void update(Post object) {
		
	}
}
