package com.example.demo.serv;

import java.util.List;

import com.example.demo.model.Bonelogin;

public interface Ser {

public Bonelogin adduser(Bonelogin b);

public List<Bonelogin> getusers();

public boolean checkuser(String uname, String upass);
	
	
}
