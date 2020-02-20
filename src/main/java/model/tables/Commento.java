package model.tables;

import java.io.Serializable;

public class Commento implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8990418938865840553L;
	
	private Integer idcommento;
	protected String testo;
	private String username_cliente;
	private Integer idpost;
	private String img_utente;

	public Commento() {
		this.idcommento = null;
		this.testo = null;
		this.username_cliente = null;
		this.idpost = null;
		this.img_utente = null;
	}

	public Commento(Integer idcommento, String testo, String username_cliente, Integer idpost, String img_utente) {
		super();
		this.idcommento = idcommento;
		this.testo = testo;
		this.username_cliente = username_cliente;
		this.idpost = idpost;
		this.img_utente = img_utente;
	}

	public String getImg_utente() {
		return img_utente;
	}

	public void setImg_utente(String img_utente) {
		this.img_utente = img_utente;
	}

	public Integer getIdpost() {
		return idpost;
	}

	public void setIdpost(Integer idpost) {
		this.idpost = idpost;
	}

	public Integer getIdcommento() {
		return idcommento;
	}

	public void setIdcommento(Integer idcommento) {
		this.idcommento = idcommento;
	}

	public String getTesto() {
		return testo;
	}

	public void setTesto(String testo) {
		this.testo = testo;
	}

	public String getUsername_cliente() {
		return username_cliente;
	}

	public void setUsername_cliente(String username_cliente) {
		this.username_cliente = username_cliente;
	}

	

}
