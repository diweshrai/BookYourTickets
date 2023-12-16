package com.example.demo.implserv;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Moviestable;
import com.example.demo.repo.Moviestablerepo;
import com.example.demo.serv.MoviestableServ;

@Service
public class MoviesTableImpl  implements MoviestableServ{

	@Autowired
	Moviestablerepo movrepo;
	
	
	@Override
	public List<Moviestable> getallmovies() {
		List<Moviestable> lst =  movrepo.findAll();
		return lst;
	}

	@Override
	public Moviestable addMovies(Moviestable mov) {
		Moviestable mov1= movrepo.save(mov);
		
		return mov1;
	}

	@Override
	public Moviestable findbymovieid(int id) {
	Moviestable mov1 = movrepo.findById(id).get();
		return mov1;
	}

}
