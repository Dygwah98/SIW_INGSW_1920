package controller.admin;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.tables.Prodotto;
import model.tables.Room;
import persistence.DBManager;
import persistence.Dao;

@WebServlet(value = "/updateprodotto", name = "updateprodotto")
public class UpdateProdotto extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id = req.getParameter("Pr1");
		String tipo = req.getParameter("Tipo1");
        String descrizione = req.getParameter("Descrizione1");
        String prezzo= req.getParameter("Prezzo1");
        Prodotto p = new Prodotto();
        p.setIdprodotto(Integer.parseInt(id));
        
        boolean ID = DBManager.getInstance().getDAOFactory().getProdottoDao().exists(p);
        if(!ID) {
        	 resp.setStatus(401);
        
        } else {
        	p.setTipo(tipo);    
        	p.setDescrizione(descrizione);
        	p.setPrezzo(Integer.parseInt(prezzo));
        	p.setDisponibile(true);
        	if(descrizione.equals("ortaggio")) {
        		p.setImg("images/product-5");
        	}
        	if(descrizione.equals("verdura")) {
        		p.setImg("images/product-3");
        	}
        
        	DBManager.getInstance().getDAOFactory().getProdottoDao().update(p);
        	resp.setStatus(201);
        }
	}
}
