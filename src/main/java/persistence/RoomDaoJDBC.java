package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import model.Room;
import persistence.dao.RoomDao;

public class RoomDaoJDBC implements RoomDao{
private DataSource dataSource;
	
	public RoomDaoJDBC(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	@Override
	public void save(Room Room) {
		Connection connection = null;
		try {
			connection = this.dataSource.getConnection();
			String insert = "insert into stanza(id, tipo, descrizione,maxpersonestanze,occupata,prezzo,img) values (?,?,?,?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setInt(1,Room.getId());
			statement.setString(2,Room.getTipo());
			statement.setString(3, Room.getDescrizione());
			statement.setInt(4,Room.getMaxPersoneStanza());
			statement.setBoolean(5,Room.isOccupata());
			statement.setInt(6,Room.getPrezzo());
			statement.setString(7,Room.getImg());
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		
	}


	@Override
	public List<Room> findAll() {
		Connection connection = null;
		List<Room> rooms = new LinkedList<>();
		try {
			connection = this.dataSource.getConnection();
			Room room;
			PreparedStatement statement;
			String query = "select * from Room";
			statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
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
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}	 finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		return rooms;
	}

	@Override
	public void update(Room Room) {
		Connection connection = null;
		try {
			connection = this.dataSource.getConnection();
			String update = "update Room SET  tipo = ?, descrizione = ?,maxpersonestanza= ?,occupata= ?,prezzo=?,img=? WHERE id=?";
			PreparedStatement statement = connection.prepareStatement(update);
			statement.setString(2, Room.getTipo());
			statement.setString(3, Room.getDescrizione());
			statement.setInt(4, Room.getMaxPersoneStanza());
			statement.setBoolean(5, Room.isOccupata());
			statement.setInt(6, Room.getPrezzo());
			statement.setString(7, Room.getImg());
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		
	}

	@Override
	public void delete(Room Room) {
		Connection connection = null;
		try {
			connection = this.dataSource.getConnection();
			String delete = "delete FROM Room WHERE id = ? ";
			PreparedStatement statement = connection.prepareStatement(delete);
			statement.setInt(1,Room.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		
	}
	
	
}
