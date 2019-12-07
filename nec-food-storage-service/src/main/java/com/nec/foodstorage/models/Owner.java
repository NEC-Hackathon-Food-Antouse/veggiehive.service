package com.nec.foodstorage.models;

public class Owner {
	private String ownerName;
	private String email;

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Owner(String ownerName, String email) {
		super();
		this.ownerName = ownerName;
		this.email = email;
	}

}
