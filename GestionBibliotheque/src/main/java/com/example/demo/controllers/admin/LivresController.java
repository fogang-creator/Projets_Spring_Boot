package com.example.demo.controllers.admin;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;


import com.example.demo.entities.Livres;

import com.example.demo.repositories.LivresRepository;
import com.example.demo.service.LivresService;


@Controller
@RequestMapping("/liste")
public class LivresController {
	
	@Autowired
	private LivresService service;

	
	
	@GetMapping
	public String findAll(Model model) {
		List<Livres> listLivres= service.listAll();
		model.addAttribute("listLivres", listLivres);
		
		  //System.out.println("Nombre de livre : " + listLivres.size());   
		return "liste_livre"; 
	}  

	
	@GetMapping("/new")
    public String add(Model model) {
		Livres livre= new Livres();
        model.addAttribute("livre", livre);
       
       return "new_livre";
    }
	
	
	
	 @RequestMapping(value = "/save", method = RequestMethod.POST)
	    public String saveLivres(@ModelAttribute("livre") Livres livre) {
		 try {
		        service.save(livre);

		 } catch(Exception e) {
			 System.out.println("erreur lors de la sauvegarde");
			 
		 }
	        return "redirect:/liste";
		
	    }

	    @RequestMapping("/edit/{id}")
	    public ModelAndView showEditStudentPage(@PathVariable(name = "id") int id) {
	        ModelAndView mav = new ModelAndView("edit_livre");
	        Livres livre = service.get(id);
	        System.out.println("Auteur : " + livre.getAuteur());
	        mav.addObject("livre", livre);
	        return mav;
	        
	    }
	    @RequestMapping("/delete/{id}")
	    public String deletestudent(@PathVariable(name = "id") int id) {
	        service.delete(id);
	        return "redirect:/liste";
	        
	    } 
	
}
