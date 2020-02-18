package controller.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.tables.Commento;
import persistence.DBManager;
import persistence.dao.CommentoDao;

@WebServlet(value = "/commenta", name = "commenta")
public class Commenta extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8438202137830147228L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setStatus(405);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
			Commento c = null;
			CommentoDao C = DBManager.getInstance().getDAOFactory().getCommentoDao();
			
			String testo = req.getParameter("recensione");
			String username = (String) req.getSession().getAttribute("username");
			String idPost = req.getParameter("ID");
			
			String id = idPost;
			int intero = Integer.parseInt(id);
			c = new Commento();

			c.setTesto(testo);
			c.setUsername_cliente(username);
			c.setIdpost(intero);

			C.save(c);
			resp.sendRedirect("viewpost");
		
	}
}
