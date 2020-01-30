package controller.logging;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.tables.User;
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
		if(username.equals("puzza")  && password.equals("ricca")) {
			
			req.getSession().setAttribute("admin",true);
	        resp.addCookie(new Cookie("admin", "true"));
	        resp.setStatus(201);
		}
		else {
		User utente = DBManager.getInstance().getDAOFactory().getUtenteDao().loginQuery(username, password);
		
		
		if (utente != null) {
			
			req.getSession().setAttribute("logged",true);
	        resp.addCookie(new Cookie("logged", "true"));
			session.setAttribute("username", username);

			
			session.setAttribute("email", utente.getEmail());
			session.setAttribute("nome", utente.getName());
			session.setAttribute("cognome", utente.getSurname());
			
		
			req.getSession().setAttribute("userId", utente.getId());
			resp.setStatus(201);
		} 
		else {
			resp.setStatus(401);
		}
		}
	}

}