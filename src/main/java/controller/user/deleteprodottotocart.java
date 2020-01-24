package controller.user;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;


import model.Prodotto;
import persistence.DBManager;
import persistence.Dao;

@WebServlet(value = "/deleteprodottotocart", name = "deleteprodottotocart")
public class deleteprodottotocart extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer idord=(Integer)req.getSession().getAttribute("idordine");
		String tipo=req.getParameter("tipo");
		
		//set idordine null dato idord e tipo(faccio la query)
		
		java.util.List<Prodotto> p = DBManager.getInstance().getDAOFactory().getProdottoDao().retrieveAll();
		Integer idprod=new Integer(0);
		//System.out.println(idord+ " "+ tipo);
		//System.out.println(p.size()+" "+ p.get(0).getIdordine()+ " "+ p.get(1).getIdordine()); 
		for(int i=0;i<p.size();i++) {
			if(p.get(i).getIdordine().equals(idord) && p.get(i).getTipo().equals(tipo)) {
				idprod = p.get(i).getIdprodotto();
				//System.out.println(idprod);
				i=p.size();
			}
		}
		DBManager.getInstance().getDAOFactory().getProdottoDao().prodottoCartRemove(idprod);
		
		resp.sendRedirect("addcart");

		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		

	}
}
