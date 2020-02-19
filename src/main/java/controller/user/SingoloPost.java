package controller.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.tables.Commento;
import model.tables.Post;
import persistence.DBManager;

@WebServlet(value = "/singolopost", name = "singolopost")
public class SingoloPost extends HttpServlet {

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
		
		
		List<Post> r = DBManager.getInstance().getDAOFactory().getPostDao().singoloPost(intero);
		request.setAttribute("post", r);
		
		List<Commento> c = DBManager.getInstance().getDAOFactory().getCommentoDao().commentiPerPost(intero);
		request.setAttribute("commento", c);
		
		request.getRequestDispatcher("singoloPost.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}