package model.tables;

public class Ordine {

	private Integer IdOrdine;
	private Integer IdUtente;

	public Ordine(int idOrdine, int idUtente) {
		this.IdOrdine = idOrdine;
		this.IdUtente = idUtente;
	}

	public Ordine() {
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