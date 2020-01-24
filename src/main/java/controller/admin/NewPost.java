package controller.admin;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Post;
import model.Prodotto;
import model.User;
import persistence.DBManager;
import persistence.Dao;

@WebServlet("/NewPost")
public class NewPost extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//TODO
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    	String titolo = request.getParameter("titolo");
        String img = request.getParameter("img");
        String testo = request.getParameter("messaggio");
        java.util.Date uDate = new java.util.Date();
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        
        
        Post u=new Post();
        u.setTitolo(titolo);
        u.setImg(img);
        u.setMessaggio(testo);
        u.setData(sDate);
        
        Dao<Post> prodao = DBManager.getInstance().getDAOFactory().getPostDao();
        prodao.save(u);
        
        response.sendRedirect("blog.jsp");
    }
}