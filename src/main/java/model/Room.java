package model;

import java.sql.Date;
import java.util.ArrayList;

public class Room{
	
	private Integer Id;
	private String tipo;
	private String descrizione;
	private Integer MaxPersoneStanza;
	private boolean occupata;
	private Integer prezzo;
	private String Img;
	
	public Room(int Id,String tipo, String descrizione, int maxPersoneStanza, boolean occupata, int prezzo,String Img) {
		super();
		this.Id=Id;
		this.tipo = tipo;
		this.descrizione = descrizione;
		MaxPersoneStanza = maxPersoneStanza;
		this.occupata = occupata;
		this.prezzo = prezzo;
		this.setImg(Img);
	}
	
	public Room() {
		super();
		this.Id=null;
		this.tipo = null;
		this.descrizione = null;
		MaxPersoneStanza = null;
		this.occupata = false;
		this.prezzo = null;
		this.Img = null;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String getDescrizione() {
		return descrizione;
	}
	
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	public int getMaxPersoneStanza() {
		return MaxPersoneStanza;
	}
	
	public void setMaxPersoneStanza(int maxPersoneStanza) {
		MaxPersoneStanza = maxPersoneStanza;
	}
	
	public boolean isOccupata() {
		return occupata;
	}
	
	public void setOccupata(boolean occupata) {
		this.occupata = occupata;
	}
	
	public int getPrezzo() {
		return prezzo;
	}
	
	public void setPrezzo(int prezzo) {
		this.prezzo = prezzo;
	}
	
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}
	
	public String getImg() {
		return Img;
	}
	
	public void setImg(String img) {
		Img = img;
	}
	
}