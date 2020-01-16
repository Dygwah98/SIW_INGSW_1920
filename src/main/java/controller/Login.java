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
import persistence.DataSource;
import persistence.UserDaoJDBC;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/login")
public class Login extends HttpServlet {
	private UserDaoJDBC userdaojdbc;
	private DataSource dataSource = null;
	String password;
	User utente;
	private static DBManager instance = null;
	public void init() {
		
		try {
			Class.forName("org.postgresql.Driver").newInstance();
			dataSource = new DataSource(
					"jdbc:postgresql://sarella.cqenbowd50kg.eu-central-1.rds.amazonaws.com:5050/sarella",
					"riuzaki9797",
					"*Francesco1.,");
		
		} catch (Exception e) {
			System.err.println("PostgresDAOFactory.class: failed to load MySQL JDBC driver\n"+e);
			e.printStackTrace();
		}
		userdaojdbc=new UserDaoJDBC(dataSource);
	}
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setStatus(403); // Permission danied, only POST here
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	PrintWriter o = resp.getWriter();
        resp.setContentType("text/jsp");
    	String userid = req.getParameter("username");
		password = req.getParameter("password");
		HttpSession session =  req.getSession();
		try {
			utente = userdaojdbc.findByEmail(userid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (utente != null) {
			
				req.getSession().setAttribute("logged",true);
	            resp.addCookie(new Cookie("logged", "true"));
			session.setAttribute("username", userid);
			session.setAttribute("loggato", utente.getEmail());
			
			session.setAttribute("email", utente.getEmail());
			session.setAttribute("nome", utente.getName());
			session.setAttribute("cognome", utente.getSurname());
			RequestDispatcher rd=req.getRequestDispatcher("index.jsp");
            rd.forward(req, resp);
			}
		}
		

}
