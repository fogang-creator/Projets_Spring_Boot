package com.example.demo.controller.adherent;



import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.view.RedirectView;
import java.security.Principal;

import com.example.demo.entities.Livres;
import com.example.demo.entities.User;
import com.example.demo.repositories.LivresRepository;
import com.example.demo.repositories.UserRepository;
import com.example.demo.service.LivresService;

@Controller
public class EmpruntRendreController {
	
	@Autowired
	private LivresService service;


	@Autowired
	private LivresRepository livresRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	
	@GetMapping("/emprunt")
	public String listeLivres( Model model) {
		
	
		model.addAttribute("livre", livresRepository.findAll());
		return "livre_emprunt";
	}

	@GetMapping("/emprunt/{id}")
	public RedirectView emprunter( @PathVariable(name = "id") int idLivre, Principal principal) {
		RedirectView rv = new RedirectView();
		
		Livres livre = livresRepository.findById(idLivre).orElse(null);
		System.out.println("Livre emprunté : " + livre);
		User user = userRepository.findByEmail(principal.getName());
		
		Collection<Livres> livresEmprunts = user.getLivreEmprunt(); //Les livres deja empruntés
		livre.setQte_stock(livre.getQte_stock() - 1); 
		livresRepository.save(livre);
		
		livresEmprunts.add(livre); //On ajoute le elivre dans la liste
		user.setLivreEmprunt(livresEmprunts);  //La liste des livres empruntes mis à jour
		livresRepository.save(livre);

		
		//livresEmprunts.add(livre);
		//user.setLivreEmprunt(livresEmprunts);
		rv.setUrl("/doc");
		return rv;
	}
	


	@GetMapping("/rendre/{id}")
	public RedirectView rendre(@PathVariable(name = "id") int idLivre, Principal principal) {
		RedirectView rv = new RedirectView();
		
		Livres livre = livresRepository.findById(idLivre).orElse(null);
		System.out.println("Livre rendu : " + livre);
		User user = userRepository.findByEmail(principal.getName());
		
		Collection<Livres> livresEmprunts = user.getLivreEmprunt();
		livre.setQte_stock(livre.getQte_stock() + 1); 
		livresRepository.save(livre);
		
		livresEmprunts.remove(livre);
		user.setLivreEmprunt(livresEmprunts);  //La liste des livres empruntes mis à jour
		livresRepository.save(livre);
		
		//livresEmprunts.remove(livre);
		//user.setLivreEmprunt(livresEmprunts);
		rv.setUrl("/doc");
		return rv;
		
		  
	}
	
	
}
