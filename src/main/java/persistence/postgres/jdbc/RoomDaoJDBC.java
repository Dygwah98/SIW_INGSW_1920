package persistence.postgres.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Room;
import persistence.Dao;
import persistence.dao.RoomDao;

public class RoomDaoJDBC implements RoomDao {
	
	@Override
	public void save(Room Room) {
		
		String insert = "INSERT INTO room(tipo,descrizione,maxpersone,occupata,prezzo,img) VALUES (?,?,?,?,?,?)";
		
		try(JDBCQueryHandler handler = new JDBCQueryHandler(insert)) {
		
			PreparedStatement smt = handler.getStatement();
			
			smt.setString(1,Room.getTipo());
			smt.setString(2, Room.getDescrizione());
			smt.setInt(3,Room.getMaxPersoneStanza());
			smt.setBoolean(4,Room.isOccupata());
			smt.setInt(5,Room.getPrezzo());
			smt.setString(6,Room.getImg());
			
			handler.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
	}


	@Override
	public List<Room> retrieveAll() {
		
		String query = "SELECT * FROM room";
		List<Room> rooms = null;
		Room room = null;
		
		try(JDBCQueryHandler handler = new JDBCQueryHandler(query)) {
		
			handler.executeQuery();
			
			if(handler.existsResultSet()) {
				rooms = new ArrayList<Room>();
				ResultSet result = handler.getResultSet();
				
				while (result.next()) {
					room = new Room();
					room.setId(result.getInt("id"));				
					room.setTipo(result.getString("tipo"));
					room.setDescrizione(result.getString("descrizione"));
					room.setMaxPersoneStanza(result.getInt("maxpersonestanza"));
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
		
		String update = "UPDATE Room SET tipo = ?, descrizione = ?, maxpersonestanza = ?,occupata = ?,prezzo = ?,img = ? WHERE id = ?";
		
		try(JDBCQueryHandler handler = new JDBCQueryHandler(update)) {
	
			PreparedStatement smt = handler.getStatement();
			smt.setString(1, Room.getTipo());
			smt.setString(2, Room.getDescrizione());
			smt.setInt(3, Room.getMaxPersoneStanza());
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
		
		String delete = "DELETE FROM room WHERE id = ? ";
		
		try(JDBCQueryHandler handler = new JDBCQueryHandler(delete)) {
			
			handler.getStatement().setInt(1,Room.getId());
			handler.getStatement().executeUpdate();
		
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
	@Override
	public Room retrieve(Room object) {
		// TODO Auto-generated method stub
		return null;
	}
}