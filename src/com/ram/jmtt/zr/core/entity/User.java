package com.ram.jmtt.zr.core.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "USERS")
public class User implements Serializable {

	private static final long serialVersionUID = 9205704764870112768L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable=true, unique=true)
	private String email;
	
	@Column(nullable=true)
	private String username;
	
	@Column(nullable=true)
	private Date birthDate;
	
	/**
	 * Password Hash value
	 */
	@Column(nullable=true)	
	private String pHash;
	
	@Column(nullable=true)
	private Date registered = new Date();
	

	@ManyToOne(optional = true)
	@JoinColumn(name = "PID")
	private UserImage userImage;

	public User() {}
	
	public Long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getpHash() {
		return pHash;
	}


	public void setpHash(String pHash) {
		this.pHash = pHash;
	}

	public Date getRegistered() {
		return registered;
	}

	public void setRegistered(Date registered) {
		this.registered = registered;
	}


	public UserImage getUserImage() {
		return userImage;
	}

	public void setUserImage(UserImage userImage) {
		this.userImage = userImage;
	}

/*	@Override
	public String toString() {
		return id + " - " + email;
	}
*/	
}
