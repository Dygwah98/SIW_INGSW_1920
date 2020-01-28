package controller.user;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ProdottoAggregato;
import persistence.DBManager;

@WebServlet(value="/vedifiltri",name="vedifiltri")
public class Filtri extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public Filtri() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<ProdottoAggregato> l = DBManager.getInstance().getDAOFactory().getProdottoDao().showProductsForShop();
		String tipo = request.getParameter("filtro");
		
		switch (tipo) {
		case "prezzo":
			sortaPrezzo(l);
			break;
		case "alfabetico":
			sortaNome(l);
			break;
		case "verdura":
			l = DBManager.getInstance().getDAOFactory().getProdottoDao().retrieveByType(tipo);
			break;
		case "ortaggio":
			l = DBManager.getInstance().getDAOFactory().getProdottoDao().retrieveByType(tipo);
			break;

		default:
			break;
		
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("prodotto", l);
		request.setAttribute("prodotto",l);
		response.sendRedirect("negozio.jsp#testo");
		
	}
	
	
	public List<ProdottoAggregato> reset(List<ProdottoAggregato> l){
		l = DBManager.getInstance().getDAOFactory().getProdottoDao().showProductsForShop();
		return l;
	}
	
	public void sortaPrezzo(List<ProdottoAggregato> l) {
		
		Collections.sort(l, new Comparator<ProdottoAggregato>() {
			public int compare(ProdottoAggregato o1, ProdottoAggregato o2) {
				if(o1.getPrezzo() > o2.getPrezzo())
					return 1;
				else if(o1.getPrezzo() < o2.getPrezzo())
					return -1;
				return 0;
			}
		});
	}
	
public void sortaNome(List<ProdottoAggregato> l) {
		
		Collections.sort(l, new Comparator<ProdottoAggregato>() {
			public int compare(ProdottoAggregato o1, ProdottoAggregato o2) {
				int valore = o1.getTipo().compareTo(o2.getTipo());
					return valore;
			}
		});
	}
	
	
}