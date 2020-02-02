package model.tables;

import java.io.Serializable;

public class Room implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6306405729826829240L;
	
	private Integer Id;
	private String tipo;
	private String descrizione;
	private int maxpersone;
	private boolean occupata;
	private int prezzo;
	private String img;

	public Room(int Id, String tipo, String descrizione, int maxpersone, boolean occupata, int prezzo, String img) {
		super();
		this.Id = Id;
		this.tipo = tipo;
		this.descrizione = descrizione;
		this.maxpersone = maxpersone;
		this.occupata = occupata;
		this.prezzo = prezzo;
		this.img = img;
	}

	public Room() {
		super();
		this.Id = null;
		this.tipo = null;
		this.descrizione = null;
		this.maxpersone = 0;
		this.occupata = false;
		this.prezzo = 0;
		this.img = null;
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

	public int getMaxpersone() {
		return maxpersone;
	}

	public void setMaxpersone(int maxpersone) {
		this.maxpersone = maxpersone;
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
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

}