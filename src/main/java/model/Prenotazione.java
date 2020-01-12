package model;

import java.sql.Date;
import java.util.ArrayList;

public class Prenotazione {

	private Integer IdPrenotazione;
	private java.sql.Date checkin;
	private java.sql.Date checkout;
	private Integer IdCamera;
	private Integer IdCliente;
	private Integer idordine;
	
	public Prenotazione(int idPrenotazione, Date checkin, Date checkout, int idCamera, int idCliente,int idordine) {
		super();
		IdPrenotazione = idPrenotazione;
		this.checkin = checkin;
		this.checkout = checkout;
		this.IdCamera = idCamera;
		this.IdCliente = idCliente;
		this.idordine = idordine;
	}
	
	public Prenotazione() {
		super();
		IdPrenotazione = null;
		this.checkin = null;
		this.checkout = null;
		IdCamera = null;
		IdCliente = null;
		idordine = null;
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

	public int getIdordine() {
		return idordine;
	}
	
	public void setIdordine(int idordine) {
		this.idordine = idordine;
	}
}