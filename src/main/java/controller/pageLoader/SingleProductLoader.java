package controller.pageLoader;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.nonTables.ProdottoAggregato;
import model.tables.Prodotto;
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
		List<ProdottoAggregato> p = DBManager.getInstance().getDAOFactory().getProdottoDao().singoloProdotto(tipo);
		request.setAttribute("prodotto",p);
		
		String categoria = request.getParameter("category");
		List <ProdottoAggregato> simili = DBManager.getInstance().getDAOFactory().getProdottoDao().retrieveByCategory(categoria);
		request.setAttribute("simili", simili);
		
		request.getRequestDispatcher("prodottoSingolo.jsp").forward(request, response);
	}
}
