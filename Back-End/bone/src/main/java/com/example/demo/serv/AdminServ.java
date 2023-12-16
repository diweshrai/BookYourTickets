package com.example.demo.serv;

import java.util.List;

import com.example.demo.model.Adminlogin;

public interface AdminServ {
	
	
	public List<Adminlogin> getallAdmin();
	
	public Adminlogin addAdmin(Adminlogin ad);
	
	public boolean checkAdmin(String name, String pass);
	
	
	

}
