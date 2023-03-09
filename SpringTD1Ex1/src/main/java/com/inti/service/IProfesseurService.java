package com.inti.service;

import java.util.List;

import com.inti.model.Professeur;

public interface IProfesseurService {

	public Professeur getProfesseur(int id);
	public List<Professeur> getListProfesseurs();
	public void saveProfesseur(Professeur prof);
	public void deleteProfesseur(Professeur prof);
	public void changerSalaire(Professeur prof, double salaire);
}
