package controller.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.tables.Prodotto;
import persistence.DBManager;

@WebServlet(value = "/deleteprodottotocart", name = "deleteprodottotocart")
public class deleteprodottotocart extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2483267051461964626L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer idord = (Integer) req.getSession().getAttribute("idordine");
		String tipo = req.getParameter("tipo");

		// set idordine null dato idord e tipo(faccio la query)

		java.util.List<Prodotto> p = DBManager.getInstance().getDAOFactory().getProdottoDao().retrieveAll();
		Integer idprod = null;
		// System.out.println(idord+ " "+ tipo);
		// System.out.println(p.size()+" "+ p.get(0).getIdordine()+ " "+
		// p.get(1).getIdordine());
		for (int i = 0; i < p.size(); i++) {
			if (p.get(i).getIdordine().equals(idord) && p.get(i).getTipo().equals(tipo)) {
				idprod = p.get(i).getIdprodotto();

				break;
			}
		}
		DBManager.getInstance().getDAOFactory().getProdottoDao().updatesetdisponibile(idprod, true);

		DBManager.getInstance().getDAOFactory().getProdottoDao().prodottoCartRemove(idprod);

		resp.sendRedirect("addcart");

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
}
