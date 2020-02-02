package model.nonTables;

import model.tables.Prodotto;

public class ProdottoAggregato extends Prodotto {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1706209725356542904L;
	
	private Integer num = null;

	public ProdottoAggregato() {
		super();
	}

	public ProdottoAggregato(String tipo, Integer numProdotti) {
		super();
		super.setTipo(tipo);
		this.num = numProdotti;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer numProdotti) {
		this.num = numProdotti;
	}

}
