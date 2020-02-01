package controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.tables.Prodotto;
import persistence.DBManager;
import persistence.Dao;

@WebServlet(value = "/addproduct", name = "addproduct")
public class CreateProduct extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8438202137830147228L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setStatus(405);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String tipo = req.getParameter("Tipo");
		String descrizione = req.getParameter("Descrizione");
		String prezzo = req.getParameter("Prezzo");
		String immagine = "images/shop/";
		String img = req.getParameter("Img");

		if (tipo == null || descrizione == null || prezzo == null || img == null) {
			resp.setStatus(401);
		} else {
			immagine = immagine.concat(img);

			Prodotto p = new Prodotto();

			tipo = tipo.toLowerCase();
			p.setTipo(tipo);

			p.setDescrizione(descrizione);

			String costo = prezzo;
			int intero = Integer.parseInt(costo);
			p.setPrezzo(intero);

			p.setDisponibile(true);

			p.setImg(immagine);

			Dao<Prodotto> prodottoDao = DBManager.getInstance().getDAOFactory().getProdottoDao();
			prodottoDao.save(p);
			resp.setStatus(201);

		}
	}
}
