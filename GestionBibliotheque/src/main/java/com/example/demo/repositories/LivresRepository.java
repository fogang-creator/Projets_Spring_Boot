package com.example.demo.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Livres;



@Repository
public interface LivresRepository extends JpaRepository<Livres, Integer> {
	
	Livres findByTitre(String titre);

	 
	
	
}
