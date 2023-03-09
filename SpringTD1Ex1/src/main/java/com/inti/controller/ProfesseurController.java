package com.inti.controller;

import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.inti.model.Professeur;
import com.inti.service.IProfesseurService;
import com.inti.service.ProfesseurServiceImpl;
import com.inti.util.HibernateUtil;

@Controller
@RequestMapping("professeur")
public class ProfesseurController {
	Session s = HibernateUtil.getSessionFactory().openSession();
	
	@GetMapping("saveProf")
	public String enregistrerProf(@RequestParam("nom") String nom,
			@RequestParam("prenom") String prenom, @RequestParam("salaire") double salaire, Model m) {
		
		Professeur prof = new Professeur(nom, prenom, salaire);
		IProfesseurService ps = new ProfesseurServiceImpl();
		
		ps.saveProfesseur(prof);
		m.addAttribute("ps", ps);
		
		return "enregistrerProf";
	}
}
