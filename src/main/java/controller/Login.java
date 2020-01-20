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
import java.util.List;

@WebServlet(value = "/login", name = "login")
public class Login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setStatus(403); // Permission danied, only POST here
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
        String userid =   req.getParameter("username") == null ? (String)req.getAttribute("username") : req.getParameter("username");
		String password = req.getParameter("password") == null ? (String)req.getAttribute("password") : req.getParameter("password");
		HttpSession session =  req.getSession();

		User utente = DBManager.getInstance().getDAOFactory().getUtenteDAO().loginQuery(userid, password);
		
		if (utente != null) {
			
			session.setAttribute("logged",true);
	        resp.addCookie(new Cookie("logged", "true"));
			session.setAttribute("username", userid);
			session.setAttribute("loggato", utente.getUsername());
			
			session.setAttribute("email", utente.getEmail());
			session.setAttribute("nome", utente.getName());
			session.setAttribute("cognome", utente.getSurname());
			resp.setStatus(201);
			
			req.getRequestDispatcher("/home").forward(req, resp);
			
		} else {
			resp.setStatus(401);
		}
	}

}