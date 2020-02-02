package model.tables;

import java.io.Serializable;

public class Newsletter implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8298791923116591400L;
	
	private Integer id;
	private String email;

	public Newsletter(int id, String email) {
		super();
		this.id = id;
		this.email = email;
	}

	public Newsletter() {
		super();
		this.id = null;
		this.email = null;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}