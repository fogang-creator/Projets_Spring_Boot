package com.example.demo.controller.adherent;

import java.security.Principal;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.entities.Livres;
import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;
import com.example.demo.service.LivresService;

@Controller
public class UserConroller {
	
	@Autowired
	UserRepository userRepository;
	@Autowired
	private LivresService service;
	
	@GetMapping("/doc")
	public String findALL(Principal principal, Model model) {
			System.out.println("On est dans mes documents et Name => " + principal.getName());
			User user = userRepository.findByEmail(principal.getName());
			Collection livreUsers = user.getLivreEmprunt();
			model.addAttribute("livresEmpruntes", livreUsers);
			
			 return "livre_disponible";
		}


}
