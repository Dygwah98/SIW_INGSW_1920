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
		
		//   12>  11 22  <15
		Prenotazione p = new Prenotazione();
		p.setCheckin(Date.valueOf(req.getParameter("checkin")));
		p.setCheckout(Date.valueOf(req.getParameter("checkout")));
		p.setIdcamera(Integer.parseInt(req.getParameter("n_camera")));
		boolean funziono = true;
		
		List<Prenotazione> prenotazioni = DBManager.getInstance().getDAOFactory().getPrenotazioneDao().retrieveAll();
		if(prenotazioni!=null) {
		//so che è bruttino ma funge LOL
		for (int i = 0; i < prenotazioni.size(); i++) {
			if(p.getIdcamera() == prenotazioni.get(i).getIdcamera()){
				if((prenotazioni.get(i).getCheckin().compareTo(p.getCheckin()) < 0)&&(prenotazioni.get(i).getCheckout().compareTo(p.getCheckin()) > 0)) {
					funziono = false; 
					break;	// p(2,5,gennaio) list(1,5,gennaio) 1<2 && 5>2
				}
				else if((prenotazioni.get(i).getCheckin().compareTo(p.getCheckout()) < 0) && (prenotazioni.get(i).getCheckout().compareTo(p.getCheckout()) > 0)) {
					funziono = false; 
					break;	//p(2,5,gennaio) list(1,6) 1<5 && 6>5
				}
				else if((prenotazioni.get(i).getCheckin().compareTo(p.getCheckin()) > 0) && (prenotazioni.get(i).getCheckin().compareTo(p.getCheckout()) < 0)) {
					funziono = false;
					
					break;	//p(1-5) list(2-4) 
				}
				else if (prenotazioni.get(i).getCheckin().compareTo(p.getCheckout()) == 0) {
					funziono = false;
					break; 
				}
				else if (prenotazioni.get(i).getCheckin().compareTo(p.getCheckin()) == 0) {
					funziono = false;
					break;
				}
				else if (prenotazioni.get(i).getCheckout().compareTo(p.getCheckout()) == 0) {
					funziono = false;
					break;
				}
				else if (prenotazioni.get(i).getCheckout().compareTo(p.getCheckin()) == 0) {
					funziono = false;
					break;
				}				
			}
		}	
		}
		if(funziono) {
			Integer idUser = (Integer)req.getSession().getAttribute("userId");
			DBManager.getInstance().getDAOFactory().getPrenotazioneDao().saveAndLink(p, idUser);
			resp.setStatus(201);
		}
		else {
			resp.setStatus(401);
		}
	}
	
}
