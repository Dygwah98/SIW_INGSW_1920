package controller.admin;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Prodotto;
import model.Room;
import persistence.DBManager;
import persistence.Dao;

@WebServlet(value = "/updateprodotto", name = "updateprodotto")
public class UpdateProdotto extends HttpServlet {

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
        
        p.setTipo(tipo);
        
        p.setDescrizione(descrizione);
        
        String numero2 =prezzo;
        int intero2 = Integer.parseInt(numero2);
        p.setPrezzo(intero2);
        
        p.setDisponibile(true);
        
        if(tipo.equals("ortaggio")) {
        	p.setImg("images/product-5");
        }
        if(tipo.equals("verdura")) {
        	p.setImg("/images/product-3");
        }
        
        String numero1 =id;
        int intero1 = Integer.parseInt(numero1);
        p.setIdprodotto(intero1);
        
        Dao<Prodotto> prodottoDao = DBManager.getInstance().getDAOFactory().getProdottoDao();
        prodottoDao.update(p);;
        resp.sendRedirect("gestioneProdotti.jsp");

	}
}
