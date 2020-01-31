package controller.admin;
import java.io.IOException;
import java.net.PasswordAuthentication;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import com.sun.net.httpserver.Authenticator;

import model.tables.Newsletter;
import model.tables.Post;
import model.tables.Prodotto;
import model.tables.User;
import persistence.DBManager;
import persistence.Dao;
import java.util.*;  

import javax.activation.*; 

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
        
    	String titolo = request.getParameter("Titolo");
    	String testo = request.getParameter("Messaggio");
        String img = request.getParameter("Immagine");
        java.util.Date uDate = new java.util.Date();
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        
        Post u=new Post();
        u.setTitolo(titolo);
        u.setImg(img);
        u.setMessaggio(testo);
        u.setData(sDate);
        
        Dao<Post> prodao = DBManager.getInstance().getDAOFactory().getPostDao();
        prodao.save(u);
        
        emailSender(titolo);
        
        response.setStatus(201);
    }

    
    void emailSender(String title) {
    	
    	
    	/*	importare mail.jar e activation.jar per farlo funzionare
         * 
         * 				SEND EMAIL IN JAVA BY Rocchicedo :D
         *  
         *  scaricabili dal sito di oracle o nel WEBBE in generale
         */
        
    	List<Newsletter> newsletter = DBManager.getInstance().getDAOFactory().getNewsletterDao().retrieveAll();
        
        final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
        Properties props = System.getProperties();
        props.setProperty("mail.smtp.host", "smtp.gmail.com");
        props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
        props.setProperty("mail.smtp.socketFactory.fallback", "false");
        props.setProperty("mail.smtp.port", "465");
        props.setProperty("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.auth", "true");
        props.put("mail.debug", "true");
        props.put("mail.store.protocol", "pop3");
        props.put("mail.transport.protocol", "smtp");
        final String username = "creareSarellaEmail@gmail.com";//
        final String password = "********";
        try{
        	Session session = Session.getDefaultInstance(props, 
                                new Authenticator(){
                                   protected PasswordAuthentication getPasswordAuthentication() {
                                      return new PasswordAuthentication(username, password);
                                   }});
        	for(int i=0; i<newsletter.size();i++) {
        		Message msg = new MimeMessage(session);

        		msg.setFrom(new InternetAddress("creareSarellaEmail@gmail.com"));
        		msg.setRecipients(Message.RecipientType.TO, 
                            InternetAddress.parse(newsletter.get(i).getEmail(),false));
        		msg.setSubject("Nuovo post " +title +" da Sarella :)");
        		msg.setText("Ciao, Siamo l'agriturismo Sarella, potrebbe interessarti il nostro nuovo post!");
        		msg.setSentDate(new Date());
        		Transport.send(msg);
        		System.out.println("Messaggio inviato correttamente.");
        	}
        }catch (MessagingException e){ System.out.println("Errore d'invio, causa:" + e);}
    }
}