package com.inti.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.inti.model.Etudiant;

@Service // on peut mettre aussi @Component, ici c'est un composant de type service
public interface IEtudiantService {

	public Etudiant getEtudiant(int id);
	public List<Etudiant> getEtudiants();
	public void saveEtudiant(Etudiant etu);
	public void deleteEtudiant(Etudiant etu);
	
}
