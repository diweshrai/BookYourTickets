package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Adminlogin {

	@Id
	@SequenceGenerator(name="generator",sequenceName="prodidgenSeq",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="generator")	
private int adminid;	
	
	private String name;
	
	private String password;

	public int getAdminid() {
		return adminid;
	}

	public void setAdminid(int adminid) {
		this.adminid = adminid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Adminlogin(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}

	public Adminlogin() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Adminlogin [adminid=" + adminid + ", name=" + name + ", password=" + password + "]";
	}
	
	
	
	
	
	
	
	
}
