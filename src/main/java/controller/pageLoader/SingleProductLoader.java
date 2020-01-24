package controller.pageLoader;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Prodotto;
import persistence.DBManager;

@WebServlet(value="/singolo",name="singolo")
public class SingleProductLoader extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public SingleProductLoader() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String tipo = request.getParameter("tipo");
		List<Prodotto> p = DBManager.getInstance().getDAOFactory().getProdottoDao().retrieveByType(tipo);
		request.setAttribute("prodotto",p);
		request.getRequestDispatcher("prodottoSingolo.jsp").forward(request, response);
		
		
	}
}
