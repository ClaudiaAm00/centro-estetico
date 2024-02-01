package it.corso.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name="amministrazione")
public class Amministrazione {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	@Pattern(regexp = "[a-zA-z0-9.]{1,20}", message = "Caratteri non ammessi per lo username")
	private String username;
	
	@Column
	@Pattern(regexp = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z]{6,20}", message ="Password troppo debole")
	private String password;
	
	//incapsulamento
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
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
	

}
