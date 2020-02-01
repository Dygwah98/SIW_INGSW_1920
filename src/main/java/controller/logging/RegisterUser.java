package controller.logging;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.tables.User;
import persistence.DBManager;
import persistence.Dao;

@WebServlet("/RegisterUser")
public class RegisterUser extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6910811414241559167L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setStatus(405);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("name");
		String cognome = request.getParameter("cognome");
		String data = request.getParameter("data");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");

		User u = new User();
		u.SetName(name);
		u.SetSurname(cognome);
		u.SetNascita(data);
		u.setUsername(username);
		u.setPassword(password);
		u.setEmail(email);

		Dao<User> userdao = DBManager.getInstance().getDAOFactory().getUtenteDao();
		userdao.save(u);

		response.sendRedirect("Loginform.jsp");
	}
}