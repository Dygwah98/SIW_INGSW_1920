package model.nonTables;

import model.tables.Ordine;

public class OrdineConPrezzo extends Ordine {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8736494044872571134L;
	
	private Integer price;

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}
}
