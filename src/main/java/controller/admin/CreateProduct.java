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
import persistence.dao.ProdottoDao;

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
		
		try {
			Prodotto p = null;
			ProdottoDao P = DBManager.getInstance().getDAOFactory().getProdottoDao();
			
			String tipo = req.getParameter("Tipo");
			String descrizione = req.getParameter("Descrizione");
			String prezzo = req.getParameter("Prezzo");
			String immagine = "images/shop/";
			String img = req.getParameter("Img");
			
			immagine = immagine.concat(img);

			p = new Prodotto();

			tipo = tipo.toLowerCase();
			p.setTipo(tipo);

			p.setDescrizione(descrizione);

			String costo = prezzo;
			int intero = Integer.parseInt(costo);
			p.setPrezzo(intero);

			p.setDisponibile(true);

			p.setImg(immagine);

			P.save(p);
			resp.setStatus(201);
			
		} catch(Exception e) {
			
			resp.setStatus(401);
		}	
	}
}
