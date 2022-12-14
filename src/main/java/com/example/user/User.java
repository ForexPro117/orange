package com.example.user;

import java.sql.Timestamp;
import java.util.UUID;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;


@Entity
@Table(name="Users")
public class User {
	
	@Id
	@GeneratedValue
	private	UUID uuid;
	@JsonIgnore
	private byte[] hash;
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@Transient
	private String password;
	private String firstName;
	private String lastName;
	private String middleName;
	private String sex;
	private String email;
	private String phone;
	@JsonFormat(pattern="dd:MM:yyyy hh:mm")
	private Timestamp dateOfbirth;
	@JsonFormat(pattern="dd:MM:yyyy hh:mm")
	private Timestamp datedOfEmployment;
	private String role;
	
	
	public UUID getUuid() {
		return uuid;
	}
	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Timestamp getDateOfbirth() {
		return dateOfbirth;
	}
	public void setDateOfbirth(Timestamp dateOfbirth) {
		this.dateOfbirth = dateOfbirth;
	}
	public Timestamp getDatedOfEmployment() {
		return datedOfEmployment;
	}
	public void setDatedOfEmployment(Timestamp datedOfEmployment) {
		this.datedOfEmployment = datedOfEmployment;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public byte[] getHash() {
		return hash;
	}
	public void setHash(byte[] hash) {
		this.hash = hash;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

	
	
	
}
