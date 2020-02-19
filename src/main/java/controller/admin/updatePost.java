package controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.tables.Post;
import model.tables.Prodotto;
import persistence.DBManager;
import persistence.Dao;

@WebServlet("/updatepost")
public class updatePost extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// TODO
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setStatus(405);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			String id = request.getParameter("Identificativo");
			String titolo = request.getParameter("Titolo2");
			String testo = request.getParameter("Messaggio2");
			String img = request.getParameter("Immagine2");
			String immagine = "images/blog/";
			java.util.Date uDate = new java.util.Date();
			java.sql.Date sDate = new java.sql.Date(uDate.getTime());
			String categoria = request.getParameter("Categoria2");
			
			Post p = new Post();
            p.setidPost(Integer.parseInt(id));
		
			 boolean ID = DBManager.getInstance().getDAOFactory().getPostDao().exists(p);
	            if(!ID) {
	            	 response.setStatus(401);
	            
	            } else {
						p.setTitolo(titolo);
						immagine = immagine.concat(img);
						p.setImg(immagine);
						p.setMessaggio(testo);	
						p.setData(sDate);
						p.setCategoria(categoria);
		
						DBManager.getInstance().getDAOFactory().getPostDao().update(p);
		            	response.setStatus(201);
	            }
		} catch(Exception e) {
			response.setStatus(401);
		}
	}
}