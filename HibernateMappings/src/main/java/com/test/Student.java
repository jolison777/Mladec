package com.test;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name="student")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
private int id;
private String std_name;

@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
@JoinColumn(name="std_id")
private List<Address> addresses;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getStd_name() {
	return std_name;
}
public void setStd_name(String std_name) {
	this.std_name = std_name;
}
public List<Address> getAddresses() {
	return addresses;
}
public void setAddresses(List<Address> addresses) {
	this.addresses = addresses;
}

}
