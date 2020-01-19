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

import model.Prodotto;
import model.Room;
import persistence.DBManager;


@WebServlet(value="/viewcart",name="viewcart")
public class ViewCart extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public ViewCart() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Room> r = DBManager.getInstance().getDAOFactory().getRoomDao().retrieveAll();
		
		request.setAttribute("roomutente",r);
		List<Prodotto> p = DBManager.getInstance().getDAOFactory().getProdottoDao().retrieveAll();
		
		request.setAttribute("prodottoutente", p);
		
		request.getRequestDispatcher("booking.jsp").forward(request, response);
	}
	

	

	

	 
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
	}

}