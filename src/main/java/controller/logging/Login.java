package controller.logging;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Admin;
import model.User;

import persistence.DBManager;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/login", name = "login")
public class Login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setStatus(403); // Permission danied, only POST here
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
        resp.setContentType("text/jsp");
    	String username = req.getParameter("username");
		String password = req.getParameter("password");
		HttpSession session =  req.getSession();

		User utente = DBManager.getInstance().getDAOFactory().getUtenteDAO().loginQuery(username, password);
		Admin admin = DBManager.getInstance().getDAOFactory().getAdminDAO().loginQuery(username, password);
		
		if (admin != null) {
			
			req.getSession().setAttribute("AdminLogged",true);
	        resp.addCookie(new Cookie("AdminLogged", "true"));
			session.setAttribute("username", username);
			session.setAttribute("loggato", admin.getUsername());	
			
		} 
		
		else if (utente != null) {
			
			req.getSession().setAttribute("logged",true);
	        resp.addCookie(new Cookie("logged", "true"));
			session.setAttribute("username", username);
			session.setAttribute("loggato", utente.getUsername());
			
			session.setAttribute("email", utente.getEmail());
			session.setAttribute("nome", utente.getName());
			session.setAttribute("cognome", utente.getSurname());
			resp.setStatus(201);
		
			req.getSession().setAttribute("userId", utente.getId());
			
		} 
		else if(admin == null && utente == null) {
			resp.setStatus(401);
		}
	}

}