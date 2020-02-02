package controller.logging;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.tables.Prodotto;
import persistence.DAOFactory;
import persistence.DBManager;
import persistence.dao.ProdottoDao;

import java.io.IOException;
import java.util.List;

//FIXME: davvero dobbiamo fare così per ogni link?
@WebServlet("/logout")
public class Logout extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3499056463190953357L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getSession().setAttribute("logged", false);
		req.getSession().removeAttribute("userId");
		req.getSession().removeAttribute("admin");
		req.getSession().removeAttribute("idordine");
		req.getSession().removeAttribute("prenotazione");
		req.getSession().removeAttribute("prezziprenotazione");
		req.getSession().removeAttribute("prodc");
		req.getSession().removeAttribute("totp");
		req.getSession().removeAttribute("prodotto");
		req.getSession().removeAttribute("post");
		req.getSession().removeAttribute("room");
		
		resp.addCookie(new Cookie("logged", "false"));
		resp.addCookie(new Cookie("admin", "false"));
		
		
		req.getRequestDispatcher("index.jsp").forward(req, resp);
		// resp.sendRedirect(req.getHeader("referer"));
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setStatus(405); // Permission denied, only GET here
	}
}
