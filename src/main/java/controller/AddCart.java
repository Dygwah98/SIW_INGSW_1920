package controller;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Prenotazione;
import model.Prodotto;
import model.Room;
import persistence.DBManager;


@WebServlet(value="/addcart",name="addcart")
public class AddCart extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Integer idUser = (Integer)request.getSession().getAttribute("userId");
		Integer idProd = (Integer)request.getSession().getAttribute(request.getParameter("prodToAdd"));
		
		DBManager.getInstance().getDAOFactory().getProdottoDao().connectByUserID(idUser, idProd);
		
		request.getRequestDispatcher("cart.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
	}

}