package model.tables;

import java.io.Serializable;
import java.sql.Date;

public class Pagamento implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4860917979216022128L;
	
	private Integer id_pagamento;
	private Integer importo;
	private Integer id_ordine;
	private Integer idMetodoPagamento;
	private Date data_pagamento;

	public Pagamento() {
		id_pagamento = null;
		importo = null;
		id_ordine = null;
		idMetodoPagamento = null;
		data_pagamento = null;
	}

	public Integer getid_pagamento() {
		return id_pagamento;
	}

	public void setid_pagamento(Integer id_pagamento) {
		this.id_pagamento = id_pagamento;
	}

	public Integer getImporto() {
		return importo;
	}

	public void setImporto(Integer importo) {
		this.importo = importo;
	}

	public Integer getid_ordine() {
		return id_ordine;
	}

	public void setid_ordine(Integer id_ordine) {
		this.id_ordine = id_ordine;
	}

	public Integer getIdMetodoPagamento() {
		return idMetodoPagamento;
	}

	public void setIdMetodoPagamento(Integer idMetodoPagamento) {
		this.idMetodoPagamento = idMetodoPagamento;
	}

	public Date getdata_pagamento() {
		return data_pagamento;
	}

	public void setdata_pagamento(Date data_pagamento) {
		this.data_pagamento = data_pagamento;
	}

}
