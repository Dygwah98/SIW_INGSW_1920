package controller.admin;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.tables.Newsletter;
import model.tables.Post;
import persistence.DBManager;
import persistence.dao.PostDao;

import java.util.*;  
import javax.mail.*;  
import javax.mail.internet.*;  

@WebServlet("/NewPost")
public class NewPost extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private void emailSender(String title) {
    	
    	
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
        final String username = "agriturismoSIW2020@gmail.com";//
        final String password = "siw2020!!";
        try{
        	Session session = Session.getDefaultInstance(props, 
                                new Authenticator(){
                                   protected PasswordAuthentication getPasswordAuthentication() {
                                      return new PasswordAuthentication(username, password);
                                   }});
        	for(int i=0; i<newsletter.size();i++) {
        		Message msg = new MimeMessage(session);

        		msg.setFrom(new InternetAddress("agriturismoSIW2020@gmail.com"));
        		msg.setRecipients(Message.RecipientType.TO, 
                            InternetAddress.parse(newsletter.get(i).getEmail(),false));
        		msg.setSubject("Nuovo post  " +title +"  da Paradise :)");
        		msg.setText("Ciao, Siamo l'agriturismo Paradise, potrebbe interessarti il nostro nuovo post!");
        		msg.setSentDate(new Date());
        		Transport.send(msg);
        		System.out.println("Messaggio inviato correttamente.");
        	}
        }catch (MessagingException e){ System.out.println("Errore d'invio, causa:" + e);}
    }
	
	//TODO
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.setStatus(405);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
    	try {
    		Post  p = null;
			PostDao posts = DBManager.getInstance().getDAOFactory().getPostDao();
			
    		String titolo = request.getParameter("Titolo");
    		String testo = request.getParameter("Messaggio");
        	String img = request.getParameter("Immagine");
        	String immagine = "images/blog/";
        	java.util.Date uDate = new java.util.Date();
        	java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        	String categoria = request.getParameter("Categoria");
        	
        	if(titolo.equals("")||titolo==null||testo.equals("")||testo==null||img.equals("Immagine:")||img==null||categoria.equals("Categoria:")||categoria==null) {
        		response.setStatus(401);
        	}
        	else {
        		p=new Post();
     	        p.setTitolo(titolo);
     	        immagine = immagine.concat(img);
     	        p.setImg(immagine);
     	        p.setMessaggio(testo);
     	        p.setData(sDate);
     	        p.setCategoria(categoria);
     	    
     	        posts.save(p);
     	        
     	        emailSender(titolo); 
     	        response.setStatus(201);
        	}
       
    	} catch(Exception e) {
    		response.setStatus(401);
    	}
    
    }
}