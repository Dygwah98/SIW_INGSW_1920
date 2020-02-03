package controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.tables.Prodotto;
import persistence.DBManager;

@WebServlet(value = "/deleteprodotto", name = "deleteprodotto")
public class DeleteProdotto extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9004422281570454609L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setStatus(405);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			String id = req.getParameter("idprodo");
			Prodotto p = new Prodotto();
			p.setIdprodotto(Integer.parseInt(id));

			boolean ID = DBManager.getInstance().getDAOFactory().getProdottoDao().exists(p);

			if (!ID) {
				resp.setStatus(401);

			} else {
				DBManager.getInstance().getDAOFactory().getProdottoDao().delete(p);
				resp.setStatus(201);
			}

		} catch(Exception e) {
			resp.setStatus(401);
		}
	}
}
