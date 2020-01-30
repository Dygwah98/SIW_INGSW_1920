package model.tables;

import java.sql.Date;

public class MetodoPagamento {

	private Integer idMetodoPagamento;
	private Integer ccv;
	private Integer numeroCarta;
	private Integer idCliente;
	private Date dataScadenza;
	private Boolean metodoDiDefault;

	public MetodoPagamento() {
		idMetodoPagamento = null;
		ccv = null;
		numeroCarta = null;
		idCliente = null;
		dataScadenza = null;
		metodoDiDefault = null;
	}

	public Integer getIdMetodoPagamento() {
		return idMetodoPagamento;
	}

	public void setIdMetodoPagamento(Integer idMetodoPagamento) {
		this.idMetodoPagamento = idMetodoPagamento;
	}

	public Integer getCcv() {
		return ccv;
	}

	public void setCcv(Integer ccv) {
		this.ccv = ccv;
	}

	public Integer getNumeroCarta() {
		return numeroCarta;
	}

	public void setNumeroCarta(Integer numeroCarta) {
		this.numeroCarta = numeroCarta;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public Date getDataScadenza() {
		return dataScadenza;
	}

	public void setDataScadenza(Date dataScadenza) {
		this.dataScadenza = dataScadenza;
	}

	public Boolean getMetodoDiDefault() {
		return metodoDiDefault;
	}

	public void setMetodoDiDefault(Boolean metodoDiDefault) {
		this.metodoDiDefault = metodoDiDefault;
	}

}
