package com.muthu.model;

public class BookRatings {
	User user;
	Book book;
	private Integer ratings;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Integer getRatings() {
		return ratings;
	}

	public void setRatings(Integer ratings) {
		this.ratings = ratings;
	}

	@Override
	public String toString() {
		return "BookRatings [user=" + user + ", book=" + book + ", ratings=" + ratings + "]";
	}
}
