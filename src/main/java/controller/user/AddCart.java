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
		
		List<Prodotto> p = DBManager.getInstance().getDAOFactory().getProdottoDao().showProductsForShop();
		HttpSession session = request.getSession();
		session.setAttribute("prodotto", p);
		request.setAttribute("prodotto", p);
		
		DAOFactory f = DBManager.getInstance().getDAOFactory();
		
		Integer loggato =(Integer) request.getSession().getAttribute("userId");
		if(loggato!=null) {
			Integer idord = f.getOrdineDao().retrieveIdOrder((Integer) request.getSession().getAttribute("userId"));
			session = request.getSession();
			if(idord!=null) {
				List<Prodotto> prodc = f.getProdottoDao().showProductsForCart(idord);
				Integer totale = 0;
				if(prodc==null) {
					session.setAttribute("idordine", idord);
					session.setAttribute("prodc", prodc);
					request.setAttribute("prodc", prodc);
					session.setAttribute("totale", 0);
				}
				else {
					for (int i = 0; i < prodc.size(); i++) {
						totale = totale + prodc.get(i).getPrezzo();
					}
					session.setAttribute("idordine", idord);
					session.setAttribute("prodc", prodc);
					request.setAttribute("prodc", prodc);
					session.setAttribute("totale", totale.intValue());
				}
			}
			else {
				List<Prodotto> prodc = f.getProdottoDao().carrelloVuoto();
				session.setAttribute("prodc", prodc);
				request.setAttribute("prodc", prodc);
				session.setAttribute("idordine", null);
				session.setAttribute("totale", 0);
			}
			response.sendRedirect("negozio.jsp");
		}
		else {
			session.setAttribute("totale", 0);
			response.sendRedirect("negozio.jsp");
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}