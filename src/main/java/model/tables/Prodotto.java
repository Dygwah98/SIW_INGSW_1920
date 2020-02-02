package model.tables;

import java.io.Serializable;

public class Prodotto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8990418938865840553L;
	
	private Integer idprodotto;
	protected String tipo;
	private Integer prezzo;
	private String descrizione;
	private Boolean disponibile;
	private String img;
	private Integer idordine;

	public Prodotto(int idprodotto, String tipo, int prezzo, String descrizione, Boolean disponibile, String img,
			int idOrdine) {

		this.idprodotto = idprodotto;
		this.tipo = tipo;
		this.prezzo = prezzo;
		this.descrizione = descrizione;
		this.disponibile = disponibile;
		this.img = img;
		this.idordine = idOrdine;
	}

	public Prodotto() {
		this.idprodotto = null;
		this.tipo = null;
		this.prezzo = null;
		this.descrizione = null;
		this.disponibile = null;
		this.img = null;
		this.idordine = null;
	}

	public Integer getIdprodotto() {
		return idprodotto;
	}

	public void setIdprodotto(Integer idprodotto) {
		this.idprodotto = idprodotto;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Integer getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(Integer prezzo) {
		this.prezzo = prezzo;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Boolean getDisponibile() {
		return disponibile;
	}

	public void setDisponibile(Boolean disponibile) {
		this.disponibile = disponibile;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Integer getIdordine() {
		return idordine;
	}

	public void setIdordine(Integer idordine) {
		this.idordine = idordine;
	}

}
