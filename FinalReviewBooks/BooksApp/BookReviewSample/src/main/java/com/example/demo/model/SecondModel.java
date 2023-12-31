package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.transaction.Transactional;

@Entity
@Transactional
@Table(name = "Nature")
public class SecondModel {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	@Column(name = "Genre")
	private String gen;
	@Column(name = "Chapters")
	private int chap;
	@Column(name = "Part")
	private int part;
	@Column(name = "PublicReview")
	private String pr;
	
	public SecondModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SecondModel(int id, String gen, int chap, int part, String pr) {
		super();
		this.id = id;
		this.gen = gen;
		this.chap = chap;
		this.part = part;
		this.pr = pr;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGen() {
		return gen;
	}

	public void setGen(String gen) {
		this.gen = gen;
	}

	public int getChap() {
		return chap;
	}

	public void setChap(int chap) {
		this.chap = chap;
	}

	public int getPart() {
		return part;
	}

	public void setPart(int part) {
		this.part = part;
	}

	public String getPr() {
		return pr;
	}

	public void setPr(String pr) {
		this.pr = pr;
	}

	
}