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

@WebServlet(value = "/addproduct", name = "addproduct")
public class CreateProduct extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String tipo = req.getParameter("Tipo");
        String descrizione = req.getParameter("Descrizione");
        String prezzo= req.getParameter("Prezzo");
        if(tipo==null || descrizione==null || prezzo==null){
            resp.setStatus(401);
        }
        Prodotto p = new Prodotto();
       
        p.setTipo(tipo);
        
        p.setDescrizione(descrizione);
        
        String costo = prezzo;
        int intero = Integer.parseInt(costo);
        p.setPrezzo(intero);
        
        p.setDisponibile(true);
        
        if(descrizione.equals("ortaggio")) {
        	p.setImg("images/product-5");
        }
        if(descrizione.equals("verdura")) {
        	p.setImg("images/product-3");
        }
        
        if(descrizione.equals("ortaggio")==false|| descrizione.equals("verdura")==false) {
         	 resp.setStatus(401);
        }
        
        Dao<Prodotto> prodottoDao = DBManager.getInstance().getDAOFactory().getProdottoDao();
        prodottoDao.save(p);
        resp.setStatus(201);

	}
}