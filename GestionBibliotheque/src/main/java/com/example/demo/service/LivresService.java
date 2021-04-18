package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Livres;
import com.example.demo.repositories.LivresRepository;

@Service
public class LivresService {
     
	@Autowired
	private LivresRepository livresRepository;
	
	
	public List<Livres> listAll() {
		return livresRepository.findAll();
	}
	
	public  void save(Livres lit) {
		 livresRepository.save(lit);
	}

	public Livres get(int id) {
		return livresRepository.findById(id).get();
	}

	public void delete(int id) {
		livresRepository.deleteById(id);
	}
}
