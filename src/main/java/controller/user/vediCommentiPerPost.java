package controller.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.tables.Commento;
import persistence.DBManager;

@WebServlet(value = "/viewcomment", name = "viewcomment")
public class vediCommentiPerPost extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String tipo = request.getParameter("identificativo");
		String id = tipo;
		int intero = Integer.parseInt(id);
		List<Commento> c = DBManager.getInstance().getDAOFactory().getCommentoDao().commentiPerPost(intero);
		request.setAttribute("commento", c);
		request.getRequestDispatcher("vediCommenti.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}