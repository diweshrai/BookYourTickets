package com.example.demo.implserv;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Adminlogin;

import com.example.demo.repo.Adminrepo;
import com.example.demo.serv.AdminServ;



@Service
public class AdminImpl  implements AdminServ{

	@Autowired
	Adminrepo ar;
	
	
	@Override
	public List<Adminlogin> getallAdmin() {
		List<Adminlogin> lst =  ar.findAll();
		return lst;
	}

	@Override
	public Adminlogin addAdmin(Adminlogin ad) {
		Adminlogin ad1 = ar.save(ad);
		return ad1;
	}

	@Override
	public boolean checkAdmin(String name, String pass) {
		@SuppressWarnings("unused")
		Adminlogin b11=null;
		
		b11 = ar.findByNameAndPassword(name, pass);
		
		
		if(b11==null) {
			return false;
		}
		
		return true;
	}

}
