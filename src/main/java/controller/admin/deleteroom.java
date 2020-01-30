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
		Room r=new Room();
        r.setId(Integer.parseInt(id));
		
        boolean ID = DBManager.getInstance().getDAOFactory().getRoomDao().exists(r);
		
		if(!ID) {
        	 resp.setStatus(401);
        } else {
        	r.setId(Integer.parseInt(id));
        	DBManager.getInstance().getDAOFactory().getRoomDao().delete(r);
   	 		resp.setStatus(201);
        }
    }
}
