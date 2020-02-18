package model.tables;

import java.io.Serializable;

public class Post implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4456569981394305366L;
	
	private String messaggio;
	private String titolo;
	private Integer idPost;
	private String img;
	private java.sql.Date data;
	private String categoria;

	public Post() {
		this.titolo = null;
		this.idPost = null;
		this.messaggio = null;
		this.img = null;
		this.data = null;
		this.categoria = null;
	}

	public Post(Integer i, String t, String messaggio, String l, String strimg, java.sql.Date data, String categoria) {
		this.titolo = t;
		this.idPost = i;
		this.messaggio = messaggio;
		this.categoria = categoria;
		this.img = strimg;
		this.data = data;

	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Integer getidPost() {
		return idPost;
	}

	public void setidPost(Integer idPost) {
		this.idPost = idPost;
	}

	public java.sql.Date getData() {
		return data;
	}

	public void setData(java.sql.Date data) {
		this.data = data;
	}

	public String getMessaggio() {
		return messaggio;
	}

	public void setMessaggio(String messaggio) {
		this.messaggio = messaggio;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

}
