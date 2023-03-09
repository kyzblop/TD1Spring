package com.inti.controller;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.inti.model.Etudiant;
import com.inti.service.EtudiantServiceImpl;
import com.inti.service.IEtudiantService;
import com.inti.util.HibernateUtil;

@Controller
@RequestMapping("Etudiant")
public class EtudiantController {
	
	// injection de dépendance
	@Autowired
	IEtudiantService es;
	
	@GetMapping("save")
	public String enregistrerEtudiant(@RequestParam("nom") String nom,
			@RequestParam("prenom") String prenom, @RequestParam("tel") String tel,
			@RequestParam("mail") String mail, Model m) {
		Etudiant e = new Etudiant(nom, prenom, tel, mail);
		
		es.saveEtudiant(e);
		
		m.addAttribute("e", e);
		
		return "enregistrerEtu";
	}
	
	@GetMapping("inscription")
	public String inscriptionEtudiant() {
		return "inscription";
	}
	@PostMapping("saveEtuAvecForm")
	public String enregistrerEtu(@ModelAttribute("etuForm") Etudiant e, Model m) {
		es.saveEtudiant(e);
		m.addAttribute("e", e);
//		return "enregistrerEtu";
//		return "inscription";
		return "redirect:/Etudiant/inscription";
	}
	
	@GetMapping("delete")
	public String enregistrerEtudiant(@RequestParam("id") int id, Model m) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		Etudiant e = s.get(Etudiant.class, id);
		m.addAttribute("e", e);
		
		es.deleteEtudiant(e);
	
		return "delete";
	}
	
	@GetMapping("getEtu")
	public String getEtudiant(@RequestParam("id") int id, Model m) {
		Etudiant etu = es.getEtudiant(id);	
		m.addAttribute("etu", etu);
		return "getEtu";
	}
	
	@GetMapping("getListEtu")
	public String getEtudiants(Model m) {
		List<Etudiant> etuAll = es.getEtudiants();	
		m.addAttribute("etuAll", etuAll);
		return "getListEtu";
	}
}
