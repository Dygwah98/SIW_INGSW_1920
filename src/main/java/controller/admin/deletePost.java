package controller.admin;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.tables.Post;
import persistence.DBManager;
import persistence.Dao;

@WebServlet(value = "/deletepost", name = "deletepost")
public class deletePost extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6370703769581278837L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id = req.getParameter("Identificativo2");
		Post post = new Post();
        post.setidPost(Integer.parseInt(id));
    
		boolean ID = DBManager.getInstance().getDAOFactory().getPostDao().exists(post);
		
		if(!ID) {
        	 resp.setStatus(401);
        } else {
            DBManager.getInstance().getDAOFactory().getPostDao().delete(post);
       	 	resp.setStatus(201);    	
        }
    }
}
