package persistence.dao;

import java.sql.SQLException;
import java.util.List;

import model.Room;
import persistence.Dao;

public interface RoomDao extends Dao<Room>{
	public void roomoccupata(Integer idcamera);
	public void roomoccupatafalse(Integer idcamera);
}