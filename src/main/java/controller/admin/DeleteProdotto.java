package controller.admin;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Prodotto;
import persistence.DBManager;
import persistence.Dao;

@WebServlet(value = "/deleteprodotto", name = "deleteprodotto")
public class DeleteProdotto extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("Id");
		
        Prodotto p = new Prodotto();
        String numero1 =id;
        int intero1 = Integer.parseInt(numero1);
        p.setIdprodotto(intero1);
        Dao<Prodotto> prodottoDao = DBManager.getInstance().getDAOFactory().getProdottoDao();
        prodottoDao.delete(p);
        resp.sendRedirect("gestioneProdotti.jsp");

	}
}
