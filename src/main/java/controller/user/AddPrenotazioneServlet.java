package controller.user;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.tables.Prenotazione;
import persistence.DBManager;
@WebServlet(value="/addprenotazione",name="addprenotazione")
public class AddPrenotazioneServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -727101467915246978L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Prenotazione p = new Prenotazione();
		p.setCheckin(Date.valueOf(req.getParameter("checkin")));
		p.setCheckout(Date.valueOf(req.getParameter("checkout")));
		p.setIdcamera(Integer.parseInt(req.getParameter("n_camera")));

		boolean trovata = false;
		
		
		List<Prenotazione> prenotazioni = DBManager.getInstance().getDAOFactory().getPrenotazioneDao().retrieveAll();
		
		for (int i = 0; i < prenotazioni.size(); i++) {
			if(p.getIdcamera() == prenotazioni.get(i).getIdcamera()){
				if((((p.getCheckin().compareTo(prenotazioni.get(i).getCheckout()) > 0) && (p.getCheckout().compareTo(prenotazioni.get(i).getCheckout()) > 0)) ||
						((p.getCheckin().compareTo(prenotazioni.get(i).getCheckin()) < 0) && (p.getCheckout().compareTo(prenotazioni.get(i).getCheckin()) < 0))) &&
							((p.getCheckin().compareTo(prenotazioni.get(i).getCheckin()) > 0) && (p.getCheckout().compareTo(prenotazioni.get(i).getCheckin()) < 0))) {
								Integer idUser = (Integer)req.getSession().getAttribute("userId");
								DBManager.getInstance().getDAOFactory().getPrenotazioneDao().saveAndLink(p, idUser);
								resp.setStatus(201);
								break;
				}
				trovata = true;
			}
		}	
		
		if(trovata==false) {
			Integer idUser = (Integer)req.getSession().getAttribute("userId");
			DBManager.getInstance().getDAOFactory().getPrenotazioneDao().saveAndLink(p, idUser);
			resp.setStatus(201);
		}
		resp.setStatus(401);
	}
	
}
