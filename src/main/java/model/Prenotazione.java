package model;

public class Prenotazione {

	private Integer IdPrenotazione;
	private String checkin;
	private String checkout;
	private Integer IdCamera;
	private Integer idordine;
	
	public Prenotazione(int idPrenotazione, String checkin, String checkout, int idCamera,int idordine) {
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
	
	public String getCheckin() {
		return checkin;
	}
	
	public void setCheckin(String checkin) {
		this.checkin = checkin;
	}
	
	public String getCheckout() {
		return checkout;
	}
	
	public void setCheckout(String  checkout) {
		this.checkout = checkout;
	}
	
	public int getIdCamera() {
		return IdCamera;
	}
	
	public void setIdCamera(int idCamera) {
		IdCamera = idCamera;
	}
	


	public int getIdordine() {
		return idordine;
	}
	
	public void setIdordine(int idordine) {
		this.idordine = idordine;
	}
}