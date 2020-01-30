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

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("Identificativo2");
		boolean ID = DBManager.getInstance().getDAOFactory().getPostDao().findidproductbyid(Integer.parseInt(id));
        if(ID==false) {
        	 resp.setStatus(401);
        }
        Post post = new Post();
        String numero2 =id;
        int intero2 = Integer.parseInt(numero2);
        post.setidPost(intero2);
        Dao<Post> postdao = DBManager.getInstance().getDAOFactory().getPostDao();
        postdao.delete(post);
   	 	resp.setStatus(201);
	}
}
