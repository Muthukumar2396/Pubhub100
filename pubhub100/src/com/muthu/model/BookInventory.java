package com.muthu.model;

public class BookInventory {
	Book book;
	private Integer qty;

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Integer getQty() {
		return qty;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
	}

	@Override
	public String toString() {
		return "BookInventory [book=" + book + ", qty=" + qty + "]";
	}
}
