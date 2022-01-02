package com.autosell.model;

import java.util.ArrayList;
import java.util.List;

public class Seller {

	private Long id = null;
	private String name = "";
	private String surname = "";
	private String email = "";
	private String password = "";
	private Boolean sellerType = false;
	private String address = "";
	private Boolean logged = false;
	private List<Ad> adList = new ArrayList<>();

	public Seller() {
		super();
	}

	public Seller(String name, String surnameOAddress, String email, String password, Boolean sellerType) {
		super();
		if (sellerType) {
			this.address = surnameOAddress;
		} else {
			this.surname = surnameOAddress;
		}
		this.name = name;
		this.email = email;
		this.password = password;
		this.sellerType = sellerType;
	}

	public Seller(Long id, String name, String surnameOAddress, String email, String password, Boolean sellerType) {
		super();
		if (sellerType) {
			this.address = surnameOAddress;
		} else {
			this.surname = surnameOAddress;
		}
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.sellerType = sellerType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
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

	public Boolean getSellerType() {
		return sellerType;
	}

	public void setSellerType(Boolean sellerType) {
		this.sellerType = sellerType;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Boolean isLogged() {
		return logged;
	}

	public void setLogged(Boolean logged) {
		this.logged = logged;
	}

	public String getFullName() {
		return this.name + " " + this.surname;
	}

	public List<Ad> getAdList() {
		return adList;
	}

	public void setAdList(List<Ad> adList) {
		this.adList = adList;
	}
}
