package model.tables;

import java.io.Serializable;
import java.sql.Date;

public class Pagamento implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4860917979216022128L;
	
	private Integer idPagamento;
	private Integer importo;
	private Integer idOrdine;
	private Integer idMetodoPagamento;
	private Date dataPagamento;

	public Pagamento() {
		idPagamento = null;
		importo = null;
		idOrdine = null;
		idMetodoPagamento = null;
		dataPagamento = null;
	}

	public Integer getIdPagamento() {
		return idPagamento;
	}

	public void setIdPagamento(Integer idPagamento) {
		this.idPagamento = idPagamento;
	}

	public Integer getImporto() {
		return importo;
	}

	public void setImporto(Integer importo) {
		this.importo = importo;
	}

	public Integer getIdOrdine() {
		return idOrdine;
	}

	public void setIdOrdine(Integer idOrdine) {
		this.idOrdine = idOrdine;
	}

	public Integer getIdMetodoPagamento() {
		return idMetodoPagamento;
	}

	public void setIdMetodoPagamento(Integer idMetodoPagamento) {
		this.idMetodoPagamento = idMetodoPagamento;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

}
