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
import persistence.DAOFactory;
import persistence.DBManager;

@WebServlet(value = "/checkout", name = "checkout")
public class Checkout extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// TODO
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		DAOFactory f = DBManager.getInstance().getDAOFactory();

		try {

			List<ProdottoAggregato> prodc = f.getProdottoDao()
					.showProductsForCart((Integer) request.getSession().getAttribute("idordine"));
			List<Integer> prezzi = f.getOrdineDao()
					.retrievePrezzoCamere((Integer) request.getSession().getAttribute("userId"));

			if (prezzi.isEmpty() && prodc.isEmpty()) {
				response.setStatus(412);
			} else {
				session.setAttribute("metodp", true);
				Integer s = 0;
				if (!prodc.isEmpty())
					for (int i = 0; i < prodc.size(); i++)
						s += prodc.get(i).getPrezzo();

				if (!prezzi.isEmpty())
					for (int j = 0; j < prezzi.size(); j++)
						s += prezzi.get(j);

				session.setAttribute("totp", s);
				response.setStatus(201);
			}

		} catch (NullPointerException e) {
			response.setStatus(404);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
}