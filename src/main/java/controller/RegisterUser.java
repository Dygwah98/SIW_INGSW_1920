package controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import persistence.DBManager;
import persistence.DataSource;
import persistence.UserDaoJDBC;
import persistence.dao.UserDao;


@WebServlet("/RegisterUser")
public class RegisterUser extends HttpServlet {
	private UserDaoJDBC userdaojdbc;
	private DataSource dataSource = null;
	
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String cognome = request.getParameter("cognome");
        String data = request.getParameter("data");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
       
        User u=new User();
        u.SetName(name);
        u.SetSurname(cognome);
        u.SetNascita(data);
        u.setUsername(username);
        u.setPassword(password);
        u.setEmail(email);
        try {
        	
			userdaojdbc.save(u);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        response.sendRedirect("Loginform.jsp");
        }
    
    
}