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

@WebServlet(value = "/deleteprodotto", name = "deleteprodotto")
public class DeleteProdotto extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("idprodo");
		 boolean ID = DBManager.getInstance().getDAOFactory().getProdottoDao().findidproductbyid(Integer.parseInt(id));
	        if(ID==false) {
	        	
	        	 resp.setStatus(401);
	        }
	        else {
        Prodotto p = new Prodotto();
        String numero1 =id;
        int intero1 = Integer.parseInt(numero1);
        p.setIdprodotto(intero1);
         DBManager.getInstance().getDAOFactory().getProdottoDao().delete(p);
         resp.setStatus(201);}
	}
}
