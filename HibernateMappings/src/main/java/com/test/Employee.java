package com.test;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String e_name;
	private String e_company;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="address")
	private Address address;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getE_name() {
		return e_name;
	}
	public void setE_name(String e_name) {
		this.e_name = e_name;
	}
	public String getE_company() {
		return e_company;
	}
	public void setE_company(String e_company) {
		this.e_company = e_company;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address adr) {
		this.address = adr;
	}
	
	  
	
	

}
