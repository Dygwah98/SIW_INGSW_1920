package controller.admin;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.tables.Room;
import persistence.DBManager;
import persistence.Dao;

@WebServlet(value = "/deleterooms_servlet", name = "deleterooms_servlet")
public class deleteroom extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("Id3");
		boolean ID = DBManager.getInstance().getDAOFactory().getRoomDao().findidproductbyid(Integer.parseInt(id));
        if(ID==false) {
        	 resp.setStatus(401);
        }
        Room r=new Room();
        String numero2 =id;
        int intero2 = Integer.parseInt(numero2);
        r.setId(intero2);
        Dao<Room> roomdao = DBManager.getInstance().getDAOFactory().getRoomDao();
        roomdao.delete(r);
   	 	resp.setStatus(201);
	}
}
