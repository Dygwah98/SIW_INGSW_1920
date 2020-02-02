package model.tables;

import java.io.Serializable;
import java.sql.Date;

public class Prenotazione implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -703983560624016042L;
	
	private Integer IdPrenotazione;
	private Date checkin;
	private Date checkout;
	private Integer IdCamera;
	private Integer idordine;

	public Prenotazione(int idPrenotazione, Date checkin, Date checkout, int idCamera, int idordine) {
		super();
		IdPrenotazione = idPrenotazione;
		this.checkin = checkin;
		this.checkout = checkout;
		this.IdCamera = idCamera;
		this.idordine = idordine;
	}

	public Prenotazione() {
		super();
		IdPrenotazione = null;
		this.checkin = null;
		this.checkout = null;
		IdCamera = null;
		idordine = null;
	}

	public int getIdprenotazione() {
		return IdPrenotazione;
	}

	public void setIdprenotazione(int idPrenotazione) {
		IdPrenotazione = idPrenotazione;
	}

	public Date getCheckin() {
		return checkin;
	}

	public void setCheckin(Date checkin) {
		this.checkin = checkin;
	}

	public Date getCheckout() {
		return checkout;
	}

	public void setCheckout(Date checkout) {
		this.checkout = checkout;
	}

	public int getIdcamera() {
		return IdCamera;
	}

	public void setIdcamera(int Idcamera) {
		IdCamera = Idcamera;
	}

	public int getIdordine() {
		return idordine;
	}

	public void setIdordine(int idordine) {
		this.idordine = idordine;
	}
}