package model;

public class Prodotto {
	
	private Integer id;
	private String nome;
	private Integer prezzo;
	private String descrizione;
	private String img;
	private Integer idordine;
	
	public Prodotto(int id, String nome, int prezzo, String descrizione, String img,int idordine) {
		this.id = id;
		this.nome = nome;
		this.prezzo = prezzo;
		this.descrizione = descrizione;
		this.img = img;
		this.idordine=idordine;
	}

	public Prodotto() {
		this.id = null;
		this.nome = null;
		this.prezzo = null;
		this.descrizione = null;
		this.img = null;
		this.idordine = null;
	}
	
	
	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	

	public int getIdordine() {
		return idordine;
	}

	public void setIdordine(int idordine) {
		this.idordine = idordine;
	}
	
	
	
	
}

