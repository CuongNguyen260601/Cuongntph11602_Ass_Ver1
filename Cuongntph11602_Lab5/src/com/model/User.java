package com.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Users database table.
 * 
 */
@Entity
@Table(name="Users")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id",length = 11)
	private String id;

	@Column(name = "admin")
	private boolean admin;
	
	@Column(name = "email",length = 300)
	private String email;

	@Column(name = "fullName",length = 500)
	private String fullName;

	@Column(name = "passWord",length = 500)
	private String passWord;

	public User() {
	}

	
	public User(String id, boolean admin, String email, String fullName, String passWord) {
		this.id = id;
		this.admin = admin;
		this.email = email;
		this.fullName = fullName;
		this.passWord = passWord;
	}


	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean getAdmin() {
		return this.admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullName() {
		return this.fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPassWord() {
		return this.passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

}