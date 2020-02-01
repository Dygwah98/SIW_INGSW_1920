package controller.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistence.DBManager;

@WebServlet(value = "/deleteprenotazione", name = "deleteprenotazione")
public class deleteprenotazionetocart extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7832080643149925617L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer idp = Integer.parseInt(req.getParameter("idp"));
		Integer idc = Integer.parseInt(req.getParameter("idc"));

		DBManager.getInstance().getDAOFactory().getPrenotazioneDao().deletep(idp);
		DBManager.getInstance().getDAOFactory().getRoomDao().updateOccupata(idc, true);
		resp.sendRedirect("addcart");

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
}
