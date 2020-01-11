package model;

public class Post {
	

	private String messaggio;

	private String title;
	private Long idPost;
	private String utente;
	private String imgname;
	private java.sql.Date data;
	
	public java.sql.Date getData() {
		return data;
	}


	public void setData(java.sql.Date data) {
		this.data = data;
	}


	public Post() {}
	
	
	public Post(long i, String t, String messaggio, String l, String strimg, java.sql.Date date) {
		this.title = t;
		this.idPost = i;
		this.messaggio = messaggio;
		this.utente = l;
		this.imgname = strimg;
		this.data = date;
	
	}	
	
	public Long getIdPost() {
		return idPost;
	}
	public void setIdPost(Long idPost) {
		this.idPost = idPost;
	}
	public String getMessaggio() {
		return messaggio;
	}
	public void setMessaggio(String messaggio) {
		this.messaggio = messaggio;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getImgname() {
		return imgname;
	}

	public void setImgname(String imgname) {
		this.imgname = imgname;
	}

	public String getUtente() {
		return utente;
	}

	public void setUtente(String utente) {
		this.utente = utente;
	}
	


	


}
