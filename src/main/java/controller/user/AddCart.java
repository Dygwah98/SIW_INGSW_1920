package controller.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.nonTables.ProdottoAggregato;
import model.tables.Prenotazione;
import model.tables.Prodotto;
import persistence.DAOFactory;
import persistence.DBManager;

@WebServlet(value = "/addcart", name = "addcart")
public class AddCart extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6076714433930879204L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		DAOFactory f = DBManager.getInstance().getDAOFactory();

//		DBManager.getInstance().getDAOFactory().getProdottoDao().connectByUserID(idUser, idProd);
		//List<Prenotazione> p = f.getOrdineDao().retrievePrenotazioni((Integer) request.getSession().getAttribute("userId"));
		
		Integer idord = f.getOrdineDao().retrieveIdOrder((Integer) request.getSession().getAttribute("userId"));
		HttpSession session = request.getSession();
		if(idord!=null) {
			List<Prodotto> prodc = f.getProdottoDao().showProductsForCart(idord);
			//List<Integer> prezzi = f.getOrdineDao().retrievePrezzoCamere((Integer) request.getSession().getAttribute("userId"));
			session.setAttribute("idordine", idord);
			//session.setAttribute("prenotazione", p);
			//request.setAttribute("prenotazione", p);
			//session.setAttribute("prezziprenotazione", prezzi);
			//request.setAttribute("prezziprenotazione", prezzi);
			session.setAttribute("prodc", prodc);
			request.setAttribute("prodc", prodc);
			
		}
		else {
			List<Prodotto> prodc = f.getProdottoDao().carrelloVuoto();
			session.setAttribute("prodc", prodc);
			request.setAttribute("prodc", prodc);
			session.setAttribute("idordine", null);
		}
		request.getRequestDispatcher("cart.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}