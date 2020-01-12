package model;

import java.sql.Date;
import java.util.ArrayList;

public class User {
	
	static private int contId = 0;
	
	private int id;
	private String name;
	private String surname;
	private String username;
	private java.sql.Date  datadinascita;
	private String password;
	private String image;
	private String email;

	public User(String username, String password,String email,String name,String surname,java.sql.Date  datadinascita) {
		super();
		id = contId++;
		this.name=name;
		this.surname=surname;
		this.datadinascita=datadinascita;
		this.email = email;
		this.username = username;
		this.password = password;
		image = null;
	}
	public User() {
		id = contId++;
		this.name="";
		this.surname="";
		this.datadinascita=null;
		this.email = "";
		this.username = "";
		this.password ="";
		image = null;
	}
	public static int getContId() {
		return contId;
	}
	public static void setContId(int contId) {
		User.contId = contId;
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
		this.name=name;
	}
	public void SetSurname(String surname) {
		this.surname=surname;
	}
	public String getSurname()
	{
		return surname;
	}
	public java.sql.Date  getNascita(){
		return datadinascita;
	}
	public void SetNascita(java.sql.Date  datadinascita) {
		this.datadinascita=datadinascita;
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
