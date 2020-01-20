package model;

public class Prodotto {
	
	private Integer idProdotto;
	private String tipo;
	private String descrizione;
	private Integer prezzo;
	private Boolean disponibile;
	private String img;
	private Integer idOrdine;
	
	
	public Prodotto(int idProdotto, String nome, int prezzo, String descrizione, String img,int idordine, Boolean disponibile) {
		this.idProdotto = idProdotto;
		this.tipo = nome;
		this.prezzo = prezzo;
		this.descrizione = descrizione;
		this.img = img;
		this.idOrdine=idordine;
		this.disponibile = disponibile;
	}

	public Prodotto() {
		this.idProdotto = null;
		this.tipo = null;
		this.prezzo = null;
		this.descrizione = null;
		this.img = null;
		this.idOrdine = null;
		this.disponibile = null;
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

	public int getIdProdotto() {
		return idProdotto;
	}

	public void setIdProdotto(int id) {
		this.idProdotto = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(int prezzo) {
		this.prezzo = prezzo;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	

	public int getIdOrdine() {
		return idOrdine;
	}

	public void setIdOrdine(int idordine) {
		this.idOrdine = idordine;
	}
	
	
	
	
}

