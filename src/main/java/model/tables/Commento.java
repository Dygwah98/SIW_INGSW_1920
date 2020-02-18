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

	public Commento() {
		this.idcommento = null;
		this.testo = null;
		this.username_cliente = null;
		this.idpost = null;
	}

	public Commento(Integer idcommento, String testo, String username_cliente, Integer idpost) {
		super();
		this.idcommento = idcommento;
		this.testo = testo;
		this.username_cliente = username_cliente;
		this.idpost = idpost;
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
