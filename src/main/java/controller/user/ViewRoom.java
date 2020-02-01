package controller.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.tables.Room;
import persistence.DBManager;

@WebServlet(value = "/viewroom", name = "viewroom")
public class ViewRoom extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5619180683813203673L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Room> r = DBManager.getInstance().getDAOFactory().getRoomDao().retrieveAll();
		if (r != null) {
			HttpSession session = request.getSession();
			session.setAttribute("room", r);
			request.setAttribute("room", r);
			request.getRequestDispatcher("booking.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("booking.jsp").forward(request, response);

		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}