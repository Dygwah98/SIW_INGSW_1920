package controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
    	PrintWriter o = resp.getWriter();
        resp.setContentType("text/jsp");
    	String userid = req.getParameter("username");
    	System.out.println("sesso");
		String password = req.getParameter("password");
		HttpSession session =  req.getSession();

		User utente = DBManager.getInstance().getDAOFactory().getUtenteDAO().retrieveBy("username", userid).get(0);
		
		if (utente != null) {
			
			req.getSession().setAttribute("logged",true);
	        resp.addCookie(new Cookie("logged", "true"));
			session.setAttribute("username", userid);
			session.setAttribute("loggato", utente.getUsername());
			
			session.setAttribute("email", utente.getEmail());
			session.setAttribute("nome", utente.getName());
			session.setAttribute("cognome", utente.getSurname());
			resp.setStatus(201);
			}
		else {
			resp.setStatus(401);
		}
	}
		

}