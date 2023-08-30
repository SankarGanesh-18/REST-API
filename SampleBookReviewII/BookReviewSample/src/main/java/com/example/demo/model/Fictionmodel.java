package com.example.demo.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Books_Review")
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
	@Column(name="Review",columnDefinition = "TEXT")
	private String review;
	
	@OneToOne(cascade = CascadeType.ALL , fetch = FetchType.EAGER )
	@JoinColumn(name = "fk_id")
	private SecondModel sm;

	public Fictionmodel() {
		super();
		// TODO Auto-generated constructor stub
	}

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

	public SecondModel getSm() {
		return sm;
	}

	public void setSm(SecondModel sm) {
		this.sm = sm;
	}

	public Fictionmodel(int id, String bookName, String author, int yop, String descrip, String review,
			SecondModel sm) {
		super();
		this.id = id;
		this.bookName = bookName;
		this.author = author;
		this.yop = yop;
		this.descrip = descrip;
		this.review = review;
		this.sm = sm;
	}
	
}
