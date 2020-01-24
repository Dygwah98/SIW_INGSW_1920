package controller.user;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Prodotto;
import persistence.DBManager;
import persistence.Dao;

@WebServlet(value = "/deleteprenotazione", name = "deleteprenotazione")
public class deleteprenotazionetocart extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer idp=Integer.parseInt(req.getParameter("idp"));
		Integer idc=Integer.parseInt(req.getParameter("idc"));

		DBManager.getInstance().getDAOFactory().getPrenotazioneDao().deletep(idp);
		DBManager.getInstance().getDAOFactory().getRoomDao().roomoccupatafalse(idc);
        resp.sendRedirect("addcart");

		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		

	}
}
