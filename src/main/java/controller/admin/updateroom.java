package controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.tables.Room;
import persistence.DBManager;
import persistence.Dao;

@WebServlet(value = "/updaterooms_servlet", name = "updaterooms_servlet")
public class updateroom extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9029975826495950394L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setStatus(405);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("Id2");
		String tipo = req.getParameter("Tipo2");
		String descrizione = req.getParameter("Descrizione2");
		String numMaxPersone = req.getParameter("numMaxPersone2");
		String img = req.getParameter("Img2");
	    String immagine = "images/";
	    immagine = immagine.concat(img);
		String prezzo = req.getParameter("Prezzo2");
		Room r = new Room();
		String numero2 = id;
		int intero2 = Integer.parseInt(numero2);
		r.setId(intero2);
		r.setTipo(tipo);
		r.setDescrizione(descrizione);
		String numero = numMaxPersone;
		int intero = Integer.parseInt(numero);
		r.setMaxpersone(intero);
		r.setOccupata(false);
		String numero1 = prezzo;
		int intero1 = Integer.parseInt(numero1);
		r.setPrezzo(intero1);
		r.setImg(immagine);
		Dao<Room> roomdao = DBManager.getInstance().getDAOFactory().getRoomDao();
		roomdao.update(r);
		resp.setStatus(201);

	}
}
