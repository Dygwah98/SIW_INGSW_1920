package controller.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.tables.Prodotto;
import persistence.DBManager;

@WebServlet(value = "/addpcart", name = "addpcart")
public class AddProdottoToCart extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2057028487817650409L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer idord = DBManager.getInstance().getDAOFactory().getOrdineDao()
				.retrieveIdOrder((Integer) request.getSession().getAttribute("userId"));
		// DBManager.getInstance().getDAOFactory().getProdottoDao().updatesetdisponibile(Integer.parseInt(request.getParameter("idp")),false);

		String tipo = request.getParameter("tip");
		Integer idprod = null;
		java.util.List<Prodotto> p = DBManager.getInstance().getDAOFactory().getProdottoDao().retrieveAll();
		for (int i = 0; i < p.size(); i++) {
			if (p.get(i).getTipo().equals(tipo) && p.get(i).getDisponibile().equals(true)) {
				idprod = p.get(i).getIdprodotto();
				// System.out.println(idprod);
				break;
			}
		}
		DBManager.getInstance().getDAOFactory().getProdottoDao().updatesetdisponibile(idprod, false);
		DBManager.getInstance().getDAOFactory().getProdottoDao().updatesetordine(idprod, idord);

		request.getRequestDispatcher("vediprodotti").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}