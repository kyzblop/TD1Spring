package com.inti.controller;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.inti.model.Professeur;
import com.inti.service.IProfesseurService;
import com.inti.service.ProfesseurServiceImpl;

@Controller
@RequestMapping("Professeur")
public class ProfesseurController {
	
	
	@Autowired
	IProfesseurService ps;
	
//	@GetMapping("saveProf")
//	public String enregistrerProf(@RequestParam("nom") String nom,
//			@RequestParam("prenom") String prenom, @RequestParam("salaire") double salaire, Model m) {
//		
//		Professeur prof = new Professeur(nom, prenom, salaire);
//		IProfesseurService ps = new ProfesseurServiceImpl();
//		
//		ps.saveProfesseur(prof);
//		m.addAttribute("ps", ps);
//		
//		return "enregistrerProf";
//	}
	
	@GetMapping("inscription")
	public String inscriptionProf() {
		return "inscriptionP";
	}
	
	@PostMapping("saveProf")
	public String enregistrerProf(@ModelAttribute("profForm") Professeur p, Model m) {
		
		ps.saveProfesseur(p);
		m.addAttribute("p", p);
		return "redirect:/Professeur/inscription";
	}
	
	
	
}
