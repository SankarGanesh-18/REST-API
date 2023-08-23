package com.example.demo.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Student_Table_New")
public class Student {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String studentName;
    private String departmentName;
    private String mailid;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getMailid() {
		return mailid;
	}
	public void setMailid(String mailid) {
		this.mailid = mailid;
	}
	public Student(int id, String studentName, String departmentName, String mailid) {
		super();
		this.id = id;
		this.studentName = studentName;
		this.departmentName = departmentName;
		this.mailid = mailid;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
    
}
