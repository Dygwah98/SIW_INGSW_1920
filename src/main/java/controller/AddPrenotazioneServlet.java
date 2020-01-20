package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Prenotazione;
import persistence.DBManager;

public class AddPrenotazioneServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Prenotazione p = new Prenotazione();
		p.setCheckin(req.getParameter("checkin"));
		p.setCheckout(req.getParameter("checkout"));
		p.setIdCamera(Integer.parseInt(req.getParameter("n_camera")));
	
		Integer idUser = (Integer)req.getSession().getAttribute("userId");
		
		DBManager.getInstance().getDAOFactory().getPrenotazioneDao().saveAndLink(p, idUser);
	}
	
}
