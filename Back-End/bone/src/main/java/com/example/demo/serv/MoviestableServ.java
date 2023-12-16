package com.example.demo.serv;

import java.util.List;

import com.example.demo.model.Moviestable;

public interface MoviestableServ  {

public List<Moviestable> getallmovies();

public Moviestable addMovies(Moviestable mov);

public Moviestable findbymovieid(int id);
	
}
