package persistence;

import java.util.List;

public interface Dao<T> {

	void save(T object);

	T retrieve(T object);

	List<T> retrieveAll();

	void update(T object);

	void delete(T object);

	boolean exists(T object);
}
