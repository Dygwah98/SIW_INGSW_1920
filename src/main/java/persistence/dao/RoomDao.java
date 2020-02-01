package persistence.dao;

import model.tables.Room;
import persistence.Dao;

public interface RoomDao extends Dao<Room> {

	public void updateOccupata(Integer idRoom, Boolean value);
//	public List<Room> retrieveByDate(Date checkin, Date checkout);
}