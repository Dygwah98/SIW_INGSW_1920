package model;

public class ProdottoAggregato extends Prodotto {

	private Integer numProdotti;
	
	public ProdottoAggregato() {
		super();
	}
	
	public ProdottoAggregato(String tipo, Integer numProdotti) {
		super();
		super.setTipo(tipo);
		this.numProdotti = numProdotti;
	}

	public Integer getNumProdotti() {
		return numProdotti;
	}

	public void setNumProdotti(Integer numProdotti) {
		this.numProdotti = numProdotti;
	}
	
}
