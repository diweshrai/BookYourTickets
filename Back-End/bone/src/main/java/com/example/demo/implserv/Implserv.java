package com.example.demo.implserv;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Bonelogin;
import com.example.demo.repo.repo;
import com.example.demo.serv.Ser;

@Service
public class Implserv implements Ser {

	
	@Autowired
	repo r;
	
	
	
	@Override
	public Bonelogin adduser(Bonelogin b) {
	Bonelogin b1 = r.save(b);
		
		return b1;
	}

	@Override
	public List<Bonelogin> getusers() {
	List<Bonelogin> lst = r.findAll();
	
		return lst;
	}

	@Override
	public boolean checkuser(String uname, String upass) {
		@SuppressWarnings("unused")
		Bonelogin b11=null;
		
		b11 = r.findByNameAndPassword(uname, upass);
		
		if(b11==null) {
			return false;
		}
		
		return true;
	}

}
