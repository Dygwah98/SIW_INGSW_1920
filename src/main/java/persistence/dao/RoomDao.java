package persistence.dao;

import java.sql.SQLException;
import java.util.List;

import model.Room;
import persistence.Dao;

public interface RoomDao extends Dao<Room>{
	public List<Room> retrievefilter(String tipo, Integer maxpersone, Integer minprezzo , Integer maxprezzo) ;
}