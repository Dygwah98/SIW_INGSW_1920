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
import model.tables.Prodotto;
import persistence.DAOFactory;
import persistence.DBManager;
import persistence.dao.OrdineDao;
import persistence.dao.ProdottoDao;

@WebServlet(value = "/checkout", name = "checkout")
public class Checkout extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer processProducts(Integer id_ordine) {
		
		try {
			Integer s = 0;
			ProdottoDao f = DBManager.getInstance().getDAOFactory().getProdottoDao();
			List<Prodotto> prodc = f.showProductsForCart(id_ordine);
			for(Prodotto p : prodc)
				s += p.getPrezzo();
			
			return s;
		
		} catch(NullPointerException e) {
			return 0;
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		Integer total = 0;
		total += processProducts((Integer) request.getSession().getAttribute("idordine"));
		
		if (total <= 0) {
			response.setStatus(412);
		} else {
			session.setAttribute("totp", total.intValue());
			response.setStatus(201);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
}