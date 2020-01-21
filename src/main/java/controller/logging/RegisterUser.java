package controller.logging;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import persistence.DBManager;
import persistence.Dao;

@WebServlet("/RegisterUser")
public class RegisterUser extends HttpServlet {
	
	//TODO
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
        
        Dao<User> userdao = DBManager.getInstance().getDAOFactory().getUtenteDAO();
        userdao.save(u);
        
        response.sendRedirect("Loginform.jsp");
    }
}