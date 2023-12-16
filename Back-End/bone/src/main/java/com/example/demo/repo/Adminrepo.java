package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Adminlogin;

public interface Adminrepo extends JpaRepository< Adminlogin, Integer> {
	
	Adminlogin findByNameAndPassword(String name, String pass);

}
