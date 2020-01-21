package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Prodotto;
import persistence.DBManager;


@WebServlet(value="/vediprodotti",name="vediprodotti")
public class VisualizzaProdotti extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public VisualizzaProdotti() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Prodotto> p = DBManager.getInstance().getDAOFactory().getProdottoDao().retrieveAll();
		request.setAttribute("prodotto",p);
		request.getRequestDispatcher("negozio.jsp").forward(request, response);
	}
}