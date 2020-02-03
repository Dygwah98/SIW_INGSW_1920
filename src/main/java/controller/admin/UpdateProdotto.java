package controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.tables.Prodotto;
import persistence.DBManager;

@WebServlet(value = "/updateprodotto", name = "updateprodotto")
public class UpdateProdotto extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6441792516917803239L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setStatus(405);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
        	String id = req.getParameter("Pr1");
    		String tipo = req.getParameter("Tipo1");
            String descrizione = req.getParameter("Descrizione1");
            String prezzo= req.getParameter("Prezzo1");
            String immagine = ("images/shop/").concat(req.getParameter("Img1"));
        
            Prodotto p = new Prodotto();
            p.setIdprodotto(Integer.parseInt(id));
            
            boolean ID = DBManager.getInstance().getDAOFactory().getProdottoDao().exists(p);
            if(!ID) {
            	 resp.setStatus(401);
            
            } else {
            	tipo = tipo.toLowerCase();
            	p.setTipo(tipo);    
            	p.setDescrizione(descrizione);
            	p.setPrezzo(Integer.parseInt(prezzo));
            	p.setDisponibile(true);
            	p.setImg(immagine);
            
            	DBManager.getInstance().getDAOFactory().getProdottoDao().update(p);
            	resp.setStatus(201);
            }
            
        } catch(Exception e) {
        	resp.setStatus(401);
        }
	}
}
