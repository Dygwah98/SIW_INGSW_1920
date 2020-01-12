package model;
import java.util.LinkedList;
import java.util.List;
import model.Prenotazione;
public class Ordine{
	static private int contId = 0;
	private int IdOrdine;
	private List<Prenotazione> prenotazioni=new LinkedList();
	private List<Prodotto> prodotti=new LinkedList();
	private int IdUtente;
	public Ordine(int idOrdine, List<Prenotazione> prenotazioni, List<Prodotto> prodotti, int idUtente) {
		super();
		IdOrdine = contId++;;
		this.prenotazioni = prenotazioni;
		this.prodotti = prodotti;
		IdUtente = idUtente;
	}
	public Ordine() {
		super();
		IdOrdine = contId++;;
		this.prenotazioni = null;
		this.prodotti =null;
		IdUtente =0;
	}
	public int getIdOrdine() {
		return IdOrdine;
	}
	public void setIdOrdine(int idOrdine) {
		IdOrdine = idOrdine;
	}
	public List<Prenotazione> getPrenotazioni() {
		return prenotazioni;
	}
	public void setPrenotazioni(List<Prenotazione> prenotazioni) {
		this.prenotazioni = prenotazioni;
	}
	public List<Prodotto> getProdotti() {
		return prodotti;
	}
	public void setProdotti(List<Prodotto> prodotti) {
		this.prodotti = prodotti;
	}
	public int getIdUtente() {
		return IdUtente;
	}
	public void setIdUtente(int idUtente) {
		IdUtente = idUtente;
	}
	
	
}