package controller;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Room;
import persistence.DBManager;
import persistence.Dao;

@WebServlet(value = "/deleterooms_servlet", name = "deleterooms_servlet")
public class deleteroom extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		
        Room r=new Room();
        String numero2 =id;
        int intero2 = Integer.parseInt(numero2);
        r.setId(intero2);
        Dao<Room> roomdao = DBManager.getInstance().getDAOFactory().getRoomDao();
        roomdao.delete(r);
        resp.sendRedirect("deleteroom.jsp");

	}
}
