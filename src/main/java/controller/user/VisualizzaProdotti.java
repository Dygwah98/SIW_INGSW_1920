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
import persistence.DBManager;

@WebServlet(value = "/vediprodotti", name = "vediprodotti")
public class VisualizzaProdotti extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public VisualizzaProdotti() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<ProdottoAggregato> p = DBManager.getInstance().getDAOFactory().getProdottoDao().showProductsForShop();
		HttpSession session = request.getSession();
		session.setAttribute("prodotto", p);
		request.setAttribute("prodotto", p);
		request.getRequestDispatcher("negozio.jsp").forward(request, response);
	}
}