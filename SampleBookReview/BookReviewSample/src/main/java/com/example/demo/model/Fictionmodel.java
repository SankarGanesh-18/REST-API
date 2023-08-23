package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Fictional_Books")
public class Fictionmodel {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Book_id")
	private int id;
	@Column(name="BookName")
	private String bookName;
	@Column(name="Author")
	private String author;
	@Column(name="year of publication")
	private int yop;
	@Column(name="Description")
	private String descrip;
	@Column(name="Review")
	private String review;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getYop() {
		return yop;
	}
	public void setYop(int yop) {
		this.yop = yop;
	}
	public String getDescrip() {
		return descrip;
	}
	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public Fictionmodel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Fictionmodel(int id, String bookName, String author, int yop, String descrip, String review) {
		super();
		this.id = id;
		this.bookName = bookName;
		this.author = author;
		this.yop = yop;
		this.descrip = descrip;
		this.review = review;
	}
	
	
}
