package controller.user;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Prenotazione;
import persistence.DBManager;
@WebServlet(value="/addprenotazione",name="addprenotazione")
public class AddPrenotazioneServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Prenotazione p = new Prenotazione();
		p.setCheckin(Date.valueOf(req.getParameter("checkin")));
		p.setCheckout(Date.valueOf(req.getParameter("checkout")));
		p.setIdcamera(Integer.parseInt(req.getParameter("n_camera")));
	
		Integer idUser = (Integer)req.getSession().getAttribute("userId");
		
		DBManager.getInstance().getDAOFactory().getPrenotazioneDao().saveAndLink(p, idUser);
		DBManager.getInstance().getDAOFactory().getRoomDao().updateOccupata(p.getIdcamera(), true);
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}
	
}