package controller.user;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Prenotazione;
import model.ProdottoAggregato;
import model.Room;
import persistence.DBManager;

@WebServlet(value="/addcart",name="addcart")
public class AddCart extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		
//		DBManager.getInstance().getDAOFactory().getProdottoDao().connectByUserID(idUser, idProd);
		List<Prenotazione> p = DBManager.getInstance().getDAOFactory().getOrdineDao().retrievePrenotazioni((Integer)request.getSession().getAttribute("userId"));
		Integer idord=	DBManager.getInstance().getDAOFactory().getOrdineDao().retrieveidorder((Integer)request.getSession().getAttribute("userId"));
		List<ProdottoAggregato> prodc = DBManager.getInstance().getDAOFactory().getProdottoDao().showProductsForCart(idord);
		List<Integer> prezzi = DBManager.getInstance().getDAOFactory().getOrdineDao().retrieveprezzocamere((Integer)request.getSession().getAttribute("userId"));
		HttpSession session = request.getSession();
		session.setAttribute("prenotazione", p);
		request.setAttribute("prenotazione",p);
		session.setAttribute("prezziprenotazione", prezzi);
		request.setAttribute("prezziprenotazione",prezzi);
		session.setAttribute("prodc", prodc);
		request.setAttribute("prodc",prodc);
		request.getRequestDispatcher("cart.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
	}

}