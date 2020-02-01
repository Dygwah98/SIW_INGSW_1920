package controller.pageLoader;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.nonTables.ProdottoAggregato;
import persistence.DAOFactory;
import persistence.DBManager;

@WebServlet(value = "/singolo", name = "singolo")
public class SingleProductLoader extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public SingleProductLoader() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		DAOFactory f = DBManager.getInstance().getDAOFactory();

		String tipo = request.getParameter("tipo");
		List<ProdottoAggregato> p = f.getProdottoDao().singoloProdotto(tipo);
		request.setAttribute("prodotto", p);

		String categoria = request.getParameter("category");
		List<ProdottoAggregato> simili = f.getProdottoDao().retrieveByCategory(categoria);
		request.setAttribute("simili", simili);

		request.getRequestDispatcher("prodottoSingolo.jsp").forward(request, response);
	}
}
