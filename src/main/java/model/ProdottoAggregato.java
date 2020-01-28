package model;

public class ProdottoAggregato extends Prodotto implements Comparable<ProdottoAggregato> {

	private Integer num=null;
	
	public ProdottoAggregato() {
		super();
	}
	
	public ProdottoAggregato(String tipo, Integer numProdotti) {
		super();
		super.setTipo(tipo);
		this.num= numProdotti;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer numProdotti) {
		this.num = numProdotti;
	}

	@Override
	public int compareTo(ProdottoAggregato o) {
		return this.tipo.compareTo(o.tipo);
	}
	
}
