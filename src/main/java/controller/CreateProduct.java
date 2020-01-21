package controller;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Prodotto;
import persistence.DBManager;
import persistence.Dao;

@WebServlet(value = "/product_servlet", name = "product_servlet")
public class CreateProduct extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id = req.getParameter("Id");
		String tipo = req.getParameter("Tipo");
        String descrizione = req.getParameter("Descrizione");
        String prezzo= req.getParameter("Prezzo");
        
        Prodotto p = new Prodotto();
        
        String ID = id;
        int intero1 = Integer.parseInt(ID);
        p.setIdprodotto(intero1);
       
        p.setTipo(tipo);
        
        p.setDescrizione(descrizione);
        
        String costo = prezzo;
        int intero = Integer.parseInt(costo);
        p.setPrezzo(intero);
        
        p.setDisponibile(true);
        
        if(tipo.equals("ortaggio")) {
        	p.setImg("images/product-5");
        }
        if(tipo.equals("verdura")) {
        	p.setImg("/images/product-3");
        }
        
        Dao<Prodotto> prodottoDao = DBManager.getInstance().getDAOFactory().getProdottoDao();
        prodottoDao.save(p);
        resp.sendRedirect("createProduct.jsp");

	}
}
