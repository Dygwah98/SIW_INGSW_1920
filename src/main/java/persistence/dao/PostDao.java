package persistence.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import model.Post;

public interface PostDao {
	public void save(Post post) throws SQLException;
	public void delete(Long idPost) throws SQLException;
	public ArrayList<Post> retrieve(Integer nPost, Integer maxPost) throws SQLException;

	

}
