package persistence.postgres.jdbc;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JoinRowSet;

import com.sun.rowset.CachedRowSetImpl;
import com.sun.rowset.JoinRowSetImpl;

import model.tables.Room;
import persistence.dao.RoomDao;

public class RoomDaoJDBC implements RoomDao {
	
	@Override
	public void save(Room Room) {
		
		String insert = "INSERT INTO room(idcamera,tipo,descrizione,maxpersone,occupata,prezzo,img) VALUES (?,?,?,?,?,?,?)";
		
		try(JDBCQueryHandler handler = new JDBCQueryHandler(insert)) {
		
			PreparedStatement smt = handler.getStatement();
			smt.setInt(1, Room.getId());
			smt.setString(2,Room.getTipo());
			smt.setString(3, Room.getDescrizione());
			smt.setInt(4,Room.getMaxpersone());
			smt.setBoolean(5,Room.isOccupata());
			smt.setInt(6,Room.getPrezzo());
			smt.setString(7,Room.getImg());
			
			handler.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public Room retrieve(Room object) {
		
		String find="SELECT * FROM room WHERE idcamera=?";
		Room r = null;
		
		try(JDBCQueryHandler handler = new JDBCQueryHandler(find)) {
			handler.getStatement().setInt(1, object.getId());
			handler.executeQuery();
			if(handler.existsResultSet()) {
				handler.getResultSet().next();
				r = new Room();
				r.setId(handler.getResultSet().getInt("idcamera"));		
				r.setTipo(handler.getResultSet().getString("tipo"));
				r.setDescrizione(handler.getResultSet().getString("descrizione"));
				r.setMaxpersone(handler.getResultSet().getInt("maxpersone"));
				r.setOccupata(handler.getResultSet().getBoolean("occupata"));
				r.setPrezzo(handler.getResultSet().getInt("prezzo"));
				r.setImg(handler.getResultSet().getString("img"));
			}
		}
		catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
	
		return r;
	}
	
	@Override
	public List<Room> retrieveAll() {
		
		String query = "SELECT * FROM room where occupata=false";
		List<Room> rooms = null;
		Room room = null;
		
		try(JDBCQueryHandler handler = new JDBCQueryHandler(query)) {
		
			handler.executeQuery();
			
			if(handler.existsResultSet()) {
				rooms = new ArrayList<Room>();
				ResultSet result = handler.getResultSet();
				
				while (result.next()) {
					room = new Room();
					room.setId(result.getInt("idcamera"));		
					room.setTipo(result.getString("tipo"));
					room.setDescrizione(result.getString("descrizione"));
					room.setMaxpersone(result.getInt("maxpersone"));
					room.setOccupata(result.getBoolean("occupata"));
					room.setPrezzo(result.getInt("prezzo"));
					room.setImg(result.getString("img"));
					rooms.add(room);
				}
			}
			
			return rooms;
		
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public void update(Room Room) {
		
		String update = "UPDATE Room SET tipo = ?, descrizione = ?, maxpersone = ?,occupata = ?,prezzo = ?,img = ? WHERE idcamera = ?";
		
		try(JDBCQueryHandler handler = new JDBCQueryHandler(update)) {
	
			PreparedStatement smt = handler.getStatement();
			smt.setString(1, Room.getTipo());
			smt.setString(2, Room.getDescrizione());
			smt.setInt(3, Room.getMaxpersone());
			smt.setBoolean(4, Room.isOccupata());
			smt.setInt(5, Room.getPrezzo());
			smt.setString(6, Room.getImg());
			smt.setInt(7, Room.getId());
			smt.executeUpdate();
		
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public void delete(Room Room) {
		
		String delete = "DELETE FROM room WHERE idcamera = ? ";
		
		try(JDBCQueryHandler handler = new JDBCQueryHandler(delete)) {
			
			handler.getStatement().setInt(1,Room.getId());
			handler.getStatement().executeUpdate();
		
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
	@Override
	public boolean exists(Room object) {
	
		return retrieve(object) != null;
	}
	
	@Override
	public void updateOccupata(Integer idRoom, Boolean value) {
		String update = "UPDATE Room SET occupata = ? WHERE idcamera = ?";
		
		try(JDBCQueryHandler handler = new JDBCQueryHandler(update)) {
	
			PreparedStatement smt = handler.getStatement();
			smt.setBoolean(1, value);
			smt.setInt(2, idRoom);
			smt.executeUpdate();
		
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
	}
/*
	@Override
	public ArrayList<Room> retrieve(Integer nRoom, Integer maxRoom) {
		
		try(Connection connection = this.dataSource.getConnection()) {
		
			ArrayList<Room> result = null;
			PreparedStatement maxpost = connection.prepareStatement("SELECT max(id) AS max FROM room");
			ResultSet rsMax = maxpost.executeQuery();
			rsMax.next();
			Integer idMax = (int) rsMax.getLong("max");
			if ((maxRoom + nRoom) == idMax)
				return null;

			Integer from = idMax - maxRoom; //maxPost + nPost - maxPost => nPost
			Integer to = from - nRoom;      //nPost - nPost             => 0

			PreparedStatement create = connection.prepareStatement("SELECT * FROM room WHERE id <= ? and id > ?");
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

				Room room = new Room(); // Creating a user object to fill with
				// user data
				
				room.setId(rs.getInt("id"));				
				room.setTipo(rs.getString("tipo"));
				room.setDescrizione(rs.getString("descrizione"));
				room.setMaxPersoneStanza(rs.getInt("maxpersonestanza"));
				room.setOccupata(rs.getBoolean("occupata"));
				room.setPrezzo(rs.getInt("prezzo"));
				room.setImg(rs.getString("img"));
				
				// Add the retrived user to the list
				result.add(room);
			}

			if (result != null) {

				ArrayList<Room> orderedRoom = new ArrayList<Room>();
				for (int i = result.size() - 1; i >= 0; i--) {
					orderedRoom.add(result.get(i));
				}
				return orderedRoom;
			}
			return null;
			
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		}
	}
*/

/*
	@Override
	public List<Room> retrieveByDate(Date checkin, Date checkout) {
		
		String query = "SELECT r.* FROM room AS r, prenotazioni AS pr WHERE pr.id_room = r.idcamera AND (pr.checkin NOT BETWEEN SYMMETRIC ? AND ?) AND (pr.checkout NOT BETWEEN SYMMETRIC ? AND ?)";
		List<Room> ret = null;
		
		try(JDBCQueryHandler handler = new JDBCQueryHandler(query)) {
		
			handler.getStatement().setDate(1, checkin);
			handler.getStatement().setDate(2, checkout);
			handler.getStatement().setDate(3, checkin);
			handler.getStatement().setDate(4, checkout);
			handler.executeQuery();
			
			if(handler.existsResultSet()) {
				ret = new ArrayList<Room>();
				ResultSet result = handler.getResultSet();
				
				Room room = null;
				while (result.next()) {
					room = new Room();
					room.setId(result.getInt("idcamera"));		
					room.setTipo(result.getString("tipo"));
					room.setDescrizione(result.getString("descrizione"));
					room.setMaxpersone(result.getInt("maxpersone"));
					room.setOccupata(result.getBoolean("occupata"));
					room.setPrezzo(result.getInt("prezzo"));
					room.setImg(result.getString("img"));
					ret.add(room);
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		return ret;
	}
*/
}
