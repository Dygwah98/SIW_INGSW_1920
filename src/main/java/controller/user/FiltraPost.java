package controller.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.nonTables.ProdottoAggregato;
import model.tables.Post;
import persistence.DBManager;

@WebServlet(value="/vedifiltripost",name="vedifiltripost")
public class FiltraPost extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public FiltraPost() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<Post> l = DBManager.getInstance().getDAOFactory().getPostDao().retrieveAll();
		String tipo = request.getParameter("filtro");
		tipo = tipo.toLowerCase();
		PrintWriter out = response.getWriter();
		boolean entro =false;
		
		switch (tipo) {
		
		case "shop": case "servizi": case "ristorante": case "stanze":
			l = DBManager.getInstance().getDAOFactory().getPostDao().retrieveByCategory(tipo);
		break;
		
		case "all": 
			l = DBManager.getInstance().getDAOFactory().getPostDao().retrieveAll();
		break;

		default:
			   
			   out.println("<script type=\"text/javascript\">");
			   out.println("alert('Nessun Post trovato');");
			   out.println("location='blog.jsp';");
			   out.println("</script>");
			   entro = true;
			
			break;
		
		}
		   
		if(entro == false) {
		HttpSession session = request.getSession();
		session.setAttribute("post", l);
		request.setAttribute("post",l);
		response.sendRedirect("blog.jsp#posto");
		}
		
	}	
}