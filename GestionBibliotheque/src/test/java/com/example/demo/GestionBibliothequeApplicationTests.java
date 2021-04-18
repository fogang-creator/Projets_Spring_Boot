package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entities.Livres;
import com.example.demo.repositories.LivresRepository;

@SpringBootTest
class GestionBibliothequeApplicationTests {
	
	//@Autowired
	//private LivresRepository livresRepository;

	@Test
	public void contextLoads() {
		
		//Livres liv1 = new Livres("premier livre", "mastercci", "vero", "informaique", "20");
		//livresRepository.save(liv1);
	}

}
