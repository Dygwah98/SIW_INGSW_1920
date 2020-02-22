package model.tables;

import java.io.Serializable;

public class Ordine implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4782578891093448924L;
	
	private Integer IdOrdine;
	private Integer IdUtente;
	private Boolean pagato;

	public Ordine(int idOrdine, int idUtente, Boolean pagato) {
		this.IdOrdine = idOrdine;
		this.IdUtente = idUtente;
		this.pagato = pagato;
	}

	
	public Ordine() {
		this.IdOrdine = null;
		this.IdUtente = null;
		this.pagato=null;
	}

	
	public Boolean getPagato() {
		return pagato;
	}


	public void setPagato(Boolean pagato) {
		this.pagato = pagato;
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