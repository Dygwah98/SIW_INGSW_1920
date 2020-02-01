package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.tables.Newsletter;
import persistence.DBManager;
import persistence.Dao;

@WebServlet(value = "/addemail", name = "addemail")
public class AddEmail extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setStatus(405);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String email = req.getParameter("email");

		Newsletter p = new Newsletter();

		p.setEmail(email);
		Dao<Newsletter> newsletterDao = DBManager.getInstance().getDAOFactory().getNewsletterDao();
		newsletterDao.save(p);
		resp.setStatus(201);
		req.getRequestDispatcher("index.jsp").include(req, resp);

	}
}
