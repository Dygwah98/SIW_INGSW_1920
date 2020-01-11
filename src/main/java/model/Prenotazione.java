package model;

import java.sql.Date;
import java.util.ArrayList;
public class Prenotazione {
	static private int contId = 0;
	private int IdPrenotazione;
	private  java.sql.Date checkin;
	private java.sql.Date checkout;
	private int IdCamera;
	private int IdCliente;
	public Prenotazione(Date checkin, Date checkout, int idCamera, int idCliente) {
		super();
		IdPrenotazione=contId++;
		this.checkin = checkin;
		this.checkout = checkout;
		IdCamera = idCamera;
		IdCliente = idCliente;
	}
	public Prenotazione() {
		super();
		IdPrenotazione = contId++;
		this.checkin = null;
		this.checkout = null;
		IdCamera =0;
		IdCliente = 0;
	}
	public int getIdPrenotazione() {
		return IdPrenotazione;
	}
	public void setIdPrenotazione(int idPrenotazione) {
		IdPrenotazione = idPrenotazione;
	}
	
	public java.sql.Date getCheckin() {
		return checkin;
	}
	public void setCheckin(java.sql.Date checkin) {
		this.checkin = checkin;
	}
	public java.sql.Date getCheckout() {
		return checkout;
	}
	public void setCheckout(java.sql.Date checkout) {
		this.checkout = checkout;
	}
	public int getIdCamera() {
		return IdCamera;
	}
	public void setIdCamera(int idCamera) {
		IdCamera = idCamera;
	}
	public int getIdCliente() {
		return IdCliente;
	}
	public void setIdCliente(int idCliente) {
		IdCliente = idCliente;
	}

	
	
}