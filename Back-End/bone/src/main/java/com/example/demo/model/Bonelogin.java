package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Bonelogin {

	@Id
	@SequenceGenerator(name="generator",sequenceName="prodidgenSeq",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="generator")
private int id;


private String name;

private String password;

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

public Bonelogin(String name, String password) {
	super();
	this.name = name;
	this.password = password;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

@Override
public String toString() {
	return "Bonelogin [name=" + name + ", password=" + password + "]";
}

public Bonelogin() {
	super();
	// TODO Auto-generated constructor stub
}
	



}
