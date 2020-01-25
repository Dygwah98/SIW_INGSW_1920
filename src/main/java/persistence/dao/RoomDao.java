package persistence.dao;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import model.Room;
import persistence.Dao;

public interface RoomDao extends Dao<Room>{
	
	public void updateOccupata(Integer idRoom, Boolean value);
//	public List<Room> retrieveByDate(Date checkin, Date checkout);
}