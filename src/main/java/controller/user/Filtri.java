package controller.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Comparator;
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

@WebServlet(value = "/vedifiltri", name = "vedifiltri")
public class Filtri extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public Filtri() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Prodotto> l = DBManager.getInstance().getDAOFactory().getProdottoDao().showProductsForShop();
		String tipo = request.getParameter("filtro");
		tipo = tipo.toLowerCase();
		PrintWriter out = response.getWriter();
		boolean entro = false;

		switch (tipo) {
		case "prezzo":
			sortaPrezzo(l);
			break;
		case "prezzo2":
			sortaPrezzo2(l);
			break;
		case "alfabetico":
			sortaNome(l);
			break;

		case "verdura":
		case "ortaggio":
		case "carne":
		case "formaggi":
		case "frutta":
		case "altro":
			l = DBManager.getInstance().getDAOFactory().getProdottoDao().retrieveByCategory(tipo);
			break;

		case "pomodori":
		case "latte":
		case "broccoli":
		case "maiale":
		case "fagiolini":
		case "vitello":
		case "mele":
		case "uova":
			l = DBManager.getInstance().getDAOFactory().getProdottoDao().retrieveByType(tipo);
			break;

		case "all":
			l = DBManager.getInstance().getDAOFactory().getProdottoDao().showProductsForShop();
			break;

		default:

			out.println("<script type=\"text/javascript\">");
			out.println("alert('Nessun prodotto trovato');");
			out.println("location='negozio.jsp#piu';");
			out.println("</script>");
			entro = true;

			break;

		}

		if (entro == false) {
			HttpSession session = request.getSession();
			session.setAttribute("prodotto", l);
			request.setAttribute("prodotto", l);
			response.sendRedirect("negozio.jsp#cate");
		}

	}

	public List<Prodotto> reset(List<Prodotto> l) {
		l = DBManager.getInstance().getDAOFactory().getProdottoDao().showProductsForShop();
		return l;
	}

	public void sortaPrezzo(List<Prodotto> l) {

		Collections.sort(l, new Comparator<Prodotto>() {
			@Override
			public int compare(Prodotto o1, Prodotto o2) {
				if (o1.getPrezzo() > o2.getPrezzo())
					return 1;
				else if (o1.getPrezzo() < o2.getPrezzo())
					return -1;
				return 0;
			}
		});
	}
	
	public void sortaPrezzo2(List<Prodotto> l) {

		Collections.sort(l, new Comparator<Prodotto>() {
			@Override
			public int compare(Prodotto o1, Prodotto o2) {
				if (o1.getPrezzo() < o2.getPrezzo())
					return 1;
				else if (o1.getPrezzo() > o2.getPrezzo())
					return -1;
				return 0;
			}
		});
	}

	public void sortaNome(List<Prodotto> l) {

		Collections.sort(l, new Comparator<Prodotto>() {
			@Override
			public int compare(Prodotto o1, Prodotto o2) {
				return o1.getTipo().compareTo(o2.getTipo());
			}
		});
	}

}