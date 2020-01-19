package com.seller.portal.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "auth_user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "auth_user_id")
	private int id;
	
	@NotEmpty(message = "*First Name field is mandatory")
	@Column(name = "first_name")
	private String name;
	
	@NotEmpty(message = "*last Name field is mandatory")
	@Column(name = "last_name")
	private String lastName;
	
	
	@NotEmpty(message = "*First Name field is mandatory")
	@Column(name = "email")
	@Email(message = "*Email is not valid")
	private String email;
	
	//@NotEmpty(message = "*First Name field is mandatory")
	@Length(min = 5, message = "*Password must be at least 5 characters")
	@Column(name = "password")
	private String password;
	
	@Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits")
	@Column(name = "mobile")
	private String mobile;

	@Column(name = "status")
	private String status;

	@Column(name = "shop")
	private String shop;
	
	@Column(name = "account")
	private String account;
	
	//@Pattern(regexp = "(^$|[0-9]{6})", message = "Pincode must be 6 digits")
	@Column(name = "code")
	private String code;
	
	@Column(name = "line1")
	private String line1;
	
	@Column(name = "line2")
	private String line2;
	
	@Column(name = "city")
	private String city;

	@Column(name = "document")
	private String document;
	
	//@Pattern(regexp = "(^$|[0-9]{8})", message = "Document number must be 8 digits")
	@Column(name = "docnum")
	private String docnum;
	
	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public String getDocnum() {
		return docnum;
	}

	public void setDocnum(String docnum) {
		this.docnum = docnum;
	}

	public String getAcc() {
		return acc;
	}

	public void setAcc(String acc) {
		this.acc = acc;
	}

	public String getAccno() {
		return accno;
	}

	public void setAccno(String accno) {
		this.accno = accno;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getSwift() {
		return swift;
	}

	public void setSwift(String swift) {
		this.swift = swift;
	}

	@Column(name = "acc")
	private String acc;
	
	//@Pattern(regexp = "(^$|[0-9]{15})", message = "Account number must be 15 digits")
	@Column(name = "accno")
	private String accno;
	
	@Column(name = "bank")
	private String bank;
	
	@Column(name = "swift")
	private String swift;
	


	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "auth_user_role", joinColumns = @JoinColumn(name = "auth_user_id"), inverseJoinColumns = @JoinColumn(name = "auth_role_id"))
	private Set<Role> roles;
	public String getLine1() {
		return line1;
	}

	public void setLine1(String line1) {
		this.line1 = line1;
	}

	public String getLine2() {
		return line2;
	}

	public void setLine2(String line2) {
		this.line2 = line2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getShop() {
		return shop;
	}

	public void setShop(String status) {
		this.shop = status;
	}
	
	public String getAccount() {
		return account;
	}

	public void setAccount(String status) {
		this.account = status;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	

}
