package model.tables;

import java.sql.Date;

import persistence.Dao;

public class Pagamento {

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
