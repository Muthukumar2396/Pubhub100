package com.muthu.model;

public class BookSales {
	private Integer salesId;
	private Integer qty;
	private Float totalAmount;
	private String orderDate;
	private String status;
	Book book;
	User user;

	public Integer getSalesId() {
		return salesId;
	}

	public void setSalesId(Integer salesId) {
		this.salesId = salesId;
	}

	public Integer getQty() {
		return qty;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
	}

	public Float getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Float totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String string) {
		this.orderDate = string;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "BookSales [salesId=" + salesId + ", qty=" + qty + ", totalAmount=" + totalAmount + ", orderDate="
				+ orderDate + ", status=" + status + ", book=" + book + ", user=" + user + "]";
	}
}
