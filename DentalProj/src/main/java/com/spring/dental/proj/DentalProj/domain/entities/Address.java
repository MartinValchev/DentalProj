package com.spring.dental.proj.DentalProj.domain.entities;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Embeddable
public class Address {

	public Address(@NotNull @Size(max = 50) String country, @NotNull @Size(max = 50) String city,
			@NotNull @Size(max = 6) String postCode, @NotNull @Size(max = 100) String addressLine1,
			@NotNull @Size(max = 100) String addressLine2) {
		super();
		this.country = country;
		this.city = city;
		this.postCode = postCode;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
	}

	@NotNull
	@Size(max = 50)
	private String country;

	@NotNull
	@Size(max = 50)
	private String city;

	@NotNull
	@Size(max = 6)
	private String postCode;

	@NotNull
	@Size(max = 100)
	private String addressLine1;

	@NotNull
	@Size(max = 100)
	private String addressLine2;

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

}
