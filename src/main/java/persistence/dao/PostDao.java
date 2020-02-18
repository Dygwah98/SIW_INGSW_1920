package persistence.dao;

import java.util.List;

import model.tables.Post;
import persistence.Dao;

public interface PostDao extends Dao<Post> {

	List<Post> retrieveByCategory(String tipo);

}
