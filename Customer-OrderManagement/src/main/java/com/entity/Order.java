
package com.entity;

public class Order {
	private Long id;
	private String customerName;
	private int totalAmount;

	public Order() {

	}

	public Order(Long id, String customerName, int totalAmount) {
		this.id = id;
		this.customerName = customerName;
		this.totalAmount = totalAmount;
	}

	public Order(String customerName, int totalAmount) {
		this(null, customerName, totalAmount);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}
}
