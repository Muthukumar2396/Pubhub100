package com.muthu.model;

public class Book {
	private Integer id;
	private String title;
	private String author;
	private String publishDate;
	private String content;
	private double price;
	private String status;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(String string) {
		this.publishDate = string;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", publishDate=" + publishDate
				+ ", content=" + content + ", price=" + price + ", status=" + status + "]";
	}
}
