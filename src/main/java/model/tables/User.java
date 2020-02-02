package model.tables;

import java.io.Serializable;

public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2326455764241737720L;
	
	private Integer id;
	private String name;
	private String surname;
	private String datadinascita;
	private String username;
	private String password;
	private String image;
	private String email;

	public User(int id, String username, String password, String email, String name, String surname,
			String datadinascita) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.datadinascita = datadinascita;
		this.email = email;
		this.username = username;
		this.password = password;
		image = null;
	}

	public User() {
		id = null;
		this.name = null;
		this.surname = null;
		this.datadinascita = null;
		this.email = null;
		this.username = null;
		this.password = null;
		image = null;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void SetName(String name) {
		this.name = name;
	}

	public void SetSurname(String surname) {
		this.surname = surname;
	}

	public String getSurname() {
		return surname;
	}

	public String getNascita() {
		return datadinascita;
	}

	public void SetNascita(String date1) {
		this.datadinascita = date1;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
}
