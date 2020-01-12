package model;

import java.awt.Image;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Prodotto {
	
	static private int contId = 0;
	
	private int id;
	private String nome;
	private int prezzo;
	private String descrizione;
	private String img;
	private int idordine;
	public Prodotto() {}
	
	public Prodotto(int id, String nome, int prezzo, String descrizione, String img,int idordine) {
		this.id = contId++;
		this.nome = nome;
		this.prezzo = prezzo;
		this.descrizione = descrizione;
		this.img = img;
		this.idordine=idordine;
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

	public static int getContId() {
		return contId;
	}

	public static void setContId(int contId) {
		Prodotto.contId = contId;
	}

	public int getIdordine() {
		return idordine;
	}

	public void setIdordine(int idordine) {
		this.idordine = idordine;
	}
	
	
	
	
}

