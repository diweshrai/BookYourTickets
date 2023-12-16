package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Tickettable;

public interface Ticketrepo extends JpaRepository<Tickettable, Integer>{

	
	public List<Tickettable> findByUsername(String uname); 
	
}
