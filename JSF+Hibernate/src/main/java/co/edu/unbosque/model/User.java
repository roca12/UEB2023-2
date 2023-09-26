package co.edu.unbosque.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usertable")
public class User {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	@Column (name="username",nullable=false)
	private String username;
	@Column (name="passkey",nullable=false)
	private String passkey;
	
	public User() {
		
	}

	public User(String username, String passkey) {
		this.username = username;
		this.passkey = passkey;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPasskey() {
		return passkey;
	}

	public void setPasskey(String passkey) {
		this.passkey = passkey;
	}
	
	
	
	
	
}
