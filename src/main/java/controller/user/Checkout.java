package controller.user;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.nonTables.ProdottoAggregato;
import model.tables.Post;
import persistence.DBManager;
import persistence.Dao;

@WebServlet(value="/checkout",name="checkout")
public class Checkout extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//TODO
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	boolean exist=false;
    	HttpSession session = request.getSession();
    	List<ProdottoAggregato> prodc = DBManager.getInstance().getDAOFactory().getProdottoDao().showProductsForCart((Integer)request.getSession().getAttribute("idordine"));
		List<Integer> prezzi = DBManager.getInstance().getDAOFactory().getOrdineDao().retrievePrezzoCamere((Integer)request.getSession().getAttribute("userId"));
		/*if(exist==true) {
			//qui va la condizione per qui e falsa ad esempio non ci sono prenotazioni e prodotti purtroppo non mi funziona ho scritto prezzi.isempty() && prodc.isempty() ma non va
			response.setStatus(401);
			
		}*/
		
		session.setAttribute("metodp", true);
		Integer s=0;
		if(!prodc.isEmpty()) {
		for(int i=0;i<prodc.size();i++)
		{
			s+=prodc.get(i).getPrezzo();
		}
		}
		if(!prezzi.isEmpty()) {
		for(int j=0;j<prezzi.size();j++) {
			s+=prezzi.get(j);
		}
		}
    		session.setAttribute("totp",s);
    		response.setStatus(201);
		
    	
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
   
    }
}