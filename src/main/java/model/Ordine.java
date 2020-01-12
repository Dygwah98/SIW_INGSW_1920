package model;
import java.util.LinkedList;
import java.util.List;
import model.Prenotazione;
public class Ordine{
	
	private Integer IdOrdine;
	private Integer IdUtente;
	
	public Ordine(int idOrdine, int idUtente) {
		super();
		IdOrdine = idOrdine;
		IdUtente = idUtente;
	}
	public Ordine() {
		super();
		IdOrdine = null;
		IdUtente = null;
	}
	public int getIdOrdine() {
		return IdOrdine;
	}
	public void setIdOrdine(int idOrdine) {
		IdOrdine = idOrdine;
	}
	public int getIdUtente() {
		return IdUtente;
	}
	public void setIdUtente(int idUtente) {
		IdUtente = idUtente;
	}
	
	
}