package controller.logging;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.nonTables.ProdottoAggregato;
import model.tables.Prenotazione;
import model.tables.User;
import persistence.DAOFactory;
import persistence.DBManager;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(value = "/login", name = "login")
public class Login extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = -3085554283911985689L;

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setStatus(403); // Permission danied, only POST here
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
        resp.setContentType("text/jsp");
    	String username = req.getParameter("username");
		String password = req.getParameter("password");
		HttpSession session =  req.getSession();
		if(username.equals("admin")  && password.equals("admin")) {
			
			req.getSession().setAttribute("admin",true);
	        resp.addCookie(new Cookie("admin", "true"));
	        resp.setStatus(201);
		}
		else {
		
			User utente = DBManager.getInstance().getDAOFactory().getUtenteDao().loginQuery(username, password);
			
			if (utente != null) {
				
//				DAOFactory f = DBManager.getInstance().getDAOFactory();
//				Integer idord = f.getOrdineDao().retrieveIdOrder(utente.getId());
//				List<Prenotazione> p = f.getOrdineDao().retrievePrenotazioni(utente.getId());
//				List<ProdottoAggregato> prodc = f.getProdottoDao().showProductsForCart(idord);
//				List<Integer> prezzi = f.getOrdineDao().retrievePrezzoCamere(utente.getId());
//				
//				session.setAttribute("idordine", idord);
//				session.setAttribute("prenotazione", p);
//				req.setAttribute("prenotazione", p);
//				session.setAttribute("prezziprenotazione", prezzi);
//				req.setAttribute("prezziprenotazione", prezzi);
//				session.setAttribute("prodc", prodc);
//				req.setAttribute("prodc", prodc);
				
				req.getSession().setAttribute("logged",true);
				resp.addCookie(new Cookie("logged", "true"));
				session.setAttribute("username", username);

				session.setAttribute("email", utente.getEmail());
				session.setAttribute("nome", utente.getName());
				session.setAttribute("cognome", utente.getSurname());
			
				req.getSession().setAttribute("userId", utente.getId());
				resp.setStatus(201);
			
			} else {
				resp.setStatus(401);
			}
		}
	}

}