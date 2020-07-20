package com.booking.BookingTravels.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "utilisateur")
public class Utilisateur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id", unique = true, nullable = false)
	private Long userId;
	@Column(name = "fist_name")
	private String fistName;
	@Column(name = "last_name")
	private String LastName;
	@Column(name = "sexe_user")
	private String sexeUser;
	@Column(name = "birth_date")
	private Date birthDate;
	@Column(name = "login_us")
	private String login;
	@Column(name = "password_us")
	private String password;
	@Column(name = "phone_us")
	private int phone;
	@Column(name = "mail_us")
	private String mail;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long UserId) {
		userId = UserId;
	}

	public String getFistName() {
		return fistName;
	}

	public void setFistName(String fistName) {
		this.fistName = fistName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getSexeUser() {
		return sexeUser;
	}

	public void setSexeUser(String sexe) {
		this.sexeUser = sexe;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int Phone) {
		this.phone = Phone;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String Mail) {
		this.mail = Mail;
	}

}
