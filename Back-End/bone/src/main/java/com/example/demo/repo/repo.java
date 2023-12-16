package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Bonelogin;

public interface repo extends JpaRepository<Bonelogin, Integer> {

	Bonelogin findByNameAndPassword(String name , String pass);
	
}
