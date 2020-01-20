package model;

public class Prodotto {
	
	private Integer idProdotto;
	private String tipo;
	private Integer prezzo;
	private String descrizione;
	private Boolean disponibile;
	private String img;
	private Integer idOrdine;
	
	public Prodotto(int idProdotto, String tipo, int prezzo, String descrizione, Boolean disponibile, String img,int idOrdine) {
		this.idProdotto = idProdotto;
		this.tipo = tipo;
		this.prezzo = prezzo;
		this.descrizione = descrizione;
		this.disponibile = disponibile;
		this.img = img;
		this.idOrdine=idOrdine;
	}

	public Prodotto() {
		this.idProdotto = null;
		this.tipo = null;
		this.prezzo = null;
		this.descrizione = null;
		this.disponibile = null;
		this.img = null;
		this.idOrdine = null;
	}

	public Integer getIdProdotto() {
		return idProdotto;
	}

	public void setIdProdotto(Integer idProdotto) {
		this.idProdotto = idProdotto;
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

	public Integer getIdOrdine() {
		return idOrdine;
	}

	public void setIdOrdine(Integer idOrdine) {
		this.idOrdine = idOrdine;
	}
	
	
	
	
	
	
	
}

