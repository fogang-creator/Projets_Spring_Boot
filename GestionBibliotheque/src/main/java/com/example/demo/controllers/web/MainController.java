package com.example.demo.controllers.web;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.demo.entities.*;

import com.example.demo.repositories.UserRepository;

import java.util.*;

@Controller
public class MainController {
	
	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/")
	public String home(Principal principal, Model model) {
		System.out.println("Name => " + principal.getName());
		//model.addAttribute("email", principal.getName());
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		System.out.println(user.getAuthorities());
		Collection<GrantedAuthority> roles = user.getAuthorities();
		System.out.println("Est-il admin ? : " + userHasAuthority(roles, "ROLE_ADMIN"));
		model.addAttribute("isAdmin", userHasAuthority(roles, "ROLE_ADMIN"));
		
		//récup utilisateur
		com.example.demo.entities.User user2 = userRepository.findByEmail(principal.getName());
		model.addAttribute("user", user2);
		Collection<Livres> livres = user2.getLivreEmprunt();
		model.addAttribute("livresemprunts", livres);
		for (Livres l : livres) {
			System.out.println("Auteur : " + l.getAuteur() + "\n" + "Editeur : " + l.getEditeur());
		}
		//System.out.println("Nom " + user2.getLastName());
		//System.out.println("Prénom " + user2.getFirstName());
		

		return "index";
	}
	//vérifier si l'user est un admin
	public static boolean userHasAuthority(Collection<GrantedAuthority> authorities, String authority)
	{
	    for (GrantedAuthority grantedAuthority : authorities) {
	        if (authority.equals(grantedAuthority.getAuthority())) {
	            return true;
	        }
	    }

	    return false;
	}
}
