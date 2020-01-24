package controller;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Prenotazione;
import model.Room;
import persistence.DBManager;

@WebServlet(value="/addpcart",name="addpcart")
public class AddProdottoToCart extends HttpServlet {

	

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer idord=	DBManager.getInstance().getDAOFactory().getOrdineDao().retrieveidorder((Integer)request.getSession().getAttribute("userId"));
		Integer idp=Integer.parseInt(request.getParameter("idp"));
		System.out.println((Integer)request.getSession().getAttribute("userId"));
		System.out.println(idord);

		DBManager.getInstance().getDAOFactory().getProdottoDao().updatesetordine(idp,idord);
		
		HttpSession session = request.getSession();
		
		request.getRequestDispatcher("cart.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

}