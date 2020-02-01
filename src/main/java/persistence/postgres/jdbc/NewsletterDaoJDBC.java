package persistence.postgres.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.tables.Newsletter;
import persistence.PersistenceException;
import persistence.dao.NewsletterDao;

public class NewsletterDaoJDBC implements NewsletterDao {

	@Override
	public void save(Newsletter news) {

		String insert = "insert into newsletter(email) values (?)";

		try (JDBCQueryHandler handler = new JDBCQueryHandler(insert)) {

			PreparedStatement smt = handler.getStatement();
			smt.setString(1, news.getEmail());
			handler.executeUpdate();

		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		}

	}

	@Override
	public Newsletter retrieve(Newsletter object) {

		String find = "SELECT * FROM post WHERE id=?";
		Newsletter p = null;

		try (JDBCQueryHandler handler = new JDBCQueryHandler(find)) {
			handler.getStatement().setInt(1, object.getId());
			handler.executeQuery();
			if (handler.existsResultSet()) {
				p = new Newsletter();
				handler.getResultSet().next();
				p.setId(handler.getResultSet().getInt("id"));
				p.setEmail(handler.getResultSet().getString("email"));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}

		return p;
	}

	@Override
	public List<Newsletter> retrieveAll() {

		String query = "SELECT * FROM newsletter";
		List<Newsletter> newsletters = null;
		Newsletter newsletter = null;

		try (JDBCQueryHandler handler = new JDBCQueryHandler(query)) {

			handler.executeQuery();

			if (handler.existsResultSet()) {
				newsletters = new ArrayList<Newsletter>();
				ResultSet result = handler.getResultSet();

				while (result.next()) {
					newsletter = new Newsletter();
					newsletter.setId(result.getInt("id"));
					newsletter.setEmail(result.getString("email"));
					newsletters.add(newsletter);
				}
			}

			return newsletters;

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public void update(Newsletter newsletter) {

		String update = "UPDATE newsletter SET titolo = ? WHERE id = ?";

		try (JDBCQueryHandler handler = new JDBCQueryHandler(update)) {

			PreparedStatement smt = handler.getStatement();
			smt.setString(1, newsletter.getEmail());
			smt.setInt(2, newsletter.getId());
			smt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public void delete(Newsletter newsletter) {

		String delete = "DELETE FROM newsletter WHERE id = ? ";

		try (JDBCQueryHandler handler = new JDBCQueryHandler(delete)) {

			handler.getStatement().setInt(1, newsletter.getId());
			handler.getStatement().executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public boolean exists(Newsletter object) {

		return retrieve(object) != null;
	}

}
