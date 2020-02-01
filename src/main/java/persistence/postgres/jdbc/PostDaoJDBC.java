package persistence.postgres.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.tables.Post;
import persistence.PersistenceException;
import persistence.dao.PostDao;

public class PostDaoJDBC implements PostDao {

	@Override
	public void save(Post post) {

		String insert = "insert into post(titolo, messaggio, img, data_post) values (?,?,?,?)";

		try (JDBCQueryHandler handler = new JDBCQueryHandler(insert)) {

			PreparedStatement smt = handler.getStatement();
			smt.setString(1, post.getTitolo());
			smt.setString(2, post.getMessaggio());
			smt.setString(3, post.getImg());
			smt.setDate(4, post.getData());
			handler.executeUpdate();

		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		}

	}

	@Override
	public Post retrieve(Post object) {

		String find = "SELECT * FROM post WHERE idpost=?";
		Post p = null;

		try (JDBCQueryHandler handler = new JDBCQueryHandler(find)) {
			handler.getStatement().setInt(1, object.getidPost());
			handler.executeQuery();
			if (handler.existsResultSet()) {
				p = new Post();
				handler.getResultSet().next();
				p.setidPost(handler.getResultSet().getInt("idpost"));
				p.setTitolo(handler.getResultSet().getString("titolo"));
				p.setMessaggio(handler.getResultSet().getString("messaggio"));
				p.setImg(handler.getResultSet().getString("img"));
				p.setData(handler.getResultSet().getDate("data_post"));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}

		return p;
	}

	@Override
	public List<Post> retrieveAll() {

		String query = "SELECT * FROM post";
		List<Post> posts = null;
		Post post = null;

		try (JDBCQueryHandler handler = new JDBCQueryHandler(query)) {

			handler.executeQuery();

			if (handler.existsResultSet()) {
				posts = new ArrayList<Post>();
				ResultSet result = handler.getResultSet();

				while (result.next()) {
					post = new Post();
					post.setidPost(result.getInt("idPost"));
					post.setImg(result.getString("img"));
					post.setMessaggio(result.getString("messaggio"));
					post.setTitolo(result.getString("titolo"));
					post.setData(result.getDate("data_post"));
					posts.add(post);
				}
			}

			return posts;

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public void update(Post post) {

		String update = "UPDATE post SET titolo = ?, messaggio = ?, img = ?, data_post = ? WHERE idpost = ?";

		try (JDBCQueryHandler handler = new JDBCQueryHandler(update)) {

			PreparedStatement smt = handler.getStatement();
			smt.setString(1, post.getTitolo());
			smt.setString(2, post.getMessaggio());
			smt.setString(3, post.getImg());
			smt.setDate(4, post.getData());
			smt.setInt(5, post.getidPost());
			smt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public void delete(Post post) {

		String delete = "DELETE FROM post WHERE idpost = ? ";

		try (JDBCQueryHandler handler = new JDBCQueryHandler(delete)) {

			handler.getStatement().setInt(1, post.getidPost());
			handler.getStatement().executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public boolean exists(Post object) {

		return retrieve(object) != null;
	}
	/*
	 * @Override public ArrayList<Post> retrieve(Integer nPost, Integer maxPost)
	 * throws SQLException {
	 * 
	 * ArrayList<Post> result = null; Connection connection = null; try { connection
	 * = this.dataSource.getConnection(); } catch (SQLException e1) { // TODO
	 * Auto-generated catch block e1.printStackTrace(); } try { PreparedStatement
	 * maxpost = connection.prepareStatement("SELECT max(id_post) from post");
	 * ResultSet rsMax = maxpost.executeQuery(); rsMax.next(); Integer idMax = (int)
	 * rsMax.getLong("max"); if ((maxPost + nPost) == idMax) return null;
	 * 
	 * Integer from = idMax - maxPost; //maxPost + nPost - maxPost => nPost Integer
	 * to = from - nPost; //nPost - nPost => 0
	 * 
	 * PreparedStatement create = connection.
	 * prepareStatement("SELECT * FROM post WHERE id_post <= ? and id_post > ?");
	 * create.setInt(1, from); create.setInt(2, to); ResultSet rs; rs =
	 * create.executeQuery(); boolean found = true;
	 * 
	 * while (rs.next()) { if (found) { result = new ArrayList<>(); found = false; }
	 * 
	 * Long id = rs.getLong("id_post"); String title = rs.getString("title"); String
	 * message = rs.getString("messaggio"); String idUtente =
	 * rs.getString("id_utente"); String imgsrc = rs.getString("imgsrc"); Date data
	 * = rs.getDate("date");
	 * 
	 * Post post = new Post(); // Creating a user object to fill with // user data
	 * post.setIdPost(id); post.setTitle(title); post.setMessaggio(message);
	 * post.setUtente(idUtente); post.setImgname(imgsrc); post.setData(data); // Add
	 * the retrived user to the list result.add(post); }
	 * 
	 * if (result != null) {
	 * 
	 * ArrayList<Post> orderedPost = new ArrayList<Post>(); for (int i =
	 * result.size() - 1; i >= 0; i--) { orderedPost.add(result.get(i)); } return
	 * orderedPost; } return null;
	 * 
	 * } catch (SQLException e) { throw new PersistenceException(e.getMessage()); }
	 * finally { try { connection.close(); } catch (SQLException e) { throw new
	 * PersistenceException(e.getMessage()); } } }
	 */
}
