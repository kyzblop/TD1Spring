package com.inti.service;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Service;

import com.inti.model.Professeur;
import com.inti.util.HibernateUtil;

@Service
public class ProfesseurServiceImpl implements IProfesseurService {

	private static Session s = HibernateUtil.getSessionFactory().openSession(); 
	
	@Override
	public Professeur getProfesseur(int id) {
		Professeur prof = null;
		try {
			s.beginTransaction();
			prof = s.get(Professeur.class, id);
			s.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			s.getTransaction().rollback();
		}
		return prof;
	}

	@Override
	public List<Professeur> getListProfesseurs() {
		List<Professeur> listProf = null;
		try {
			s.beginTransaction();
			listProf = s.createNativeQuery("select * from professeur", Professeur.class).list();
			s.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			s.getTransaction().rollback();
		}
		return listProf;
	}

	@Override
	public void saveProfesseur(Professeur prof) {
		try {
			s.beginTransaction();
			s.save(prof);
		} catch (Exception e) {
			e.printStackTrace();
			s.getTransaction().rollback();
		}

	}

	@Override
	public void deleteProfesseur(Professeur prof) {
		try {
			s.beginTransaction();
			s.delete(prof);
		} catch (Exception e) {
			e.printStackTrace();
			s.getTransaction().rollback();
		}

	}

	@Override
	public void changerSalaire(Professeur prof, double salaire) {
		try {
			s.beginTransaction();
			prof.setSalaire(salaire);
			s.update(prof);
			s.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			s.getTransaction().rollback();
		}

	}

}
