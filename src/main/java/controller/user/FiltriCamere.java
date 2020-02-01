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
import model.tables.Room;
import persistence.DBManager;

@WebServlet(value="/vedifiltricamere",name="vedifiltricamere")
public class FiltriCamere extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public FiltriCamere() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<Room> l = DBManager.getInstance().getDAOFactory().getRoomDao().retrieveAll();
		String tipo = request.getParameter("filtrocamere");
		tipo = tipo.toLowerCase();
		PrintWriter out = response.getWriter();
		boolean entro =false;
		
		switch (tipo) {
		case "prezzo": sortaPrezzo(l); break;
		case "alfabetico": sortaNome(l); break;
		
		case "singola": case "doppia": case "tripla": 
			l = DBManager.getInstance().getDAOFactory().getRoomDao().retrieveByCategory(tipo);
		break;
		
		case "all": 
			l = DBManager.getInstance().getDAOFactory().getRoomDao().retrieveAll();
		break;

		default:
			   
			   out.println("<script type=\"text/javascript\">");
			   out.println("alert('Nessuna stanza  trovata');");
			   out.println("location='booking.jsp';");
			   out.println("</script>");
			   entro = true;
			
			break;
		
		}
		   
		if(entro == false) {
		HttpSession session = request.getSession();
		session.setAttribute("room", l);
		request.setAttribute("room",l);
		response.sendRedirect("booking.jsp");
		}
		
	}
	
	
	public List<Room> reset(List<Room> r){
		r = DBManager.getInstance().getDAOFactory().getRoomDao().retrieveAll();
		return r;
	}
	
	public void sortaPrezzo(List<Room> r) {
		
		Collections.sort(r, new Comparator<Room>() {
			public int compare(Room o1, Room o2) {
				if(o1.getPrezzo() > o2.getPrezzo())
					return 1;
				else if(o1.getPrezzo() < o2.getPrezzo())
					return -1;
				return 0;
			}
		});
	}
	
	public void sortaNome(List<Room> r) {
		
		Collections.sort(r, new Comparator<Room>() {
			public int compare(Room o1, Room o2) {
				return o1.getTipo().compareTo(o2.getTipo());
			}
		});
	}

	
	
}