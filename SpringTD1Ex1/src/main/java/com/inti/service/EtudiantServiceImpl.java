package com.inti.service;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Service;

import com.inti.model.Etudiant;
import com.inti.util.HibernateUtil;

@Service
public class EtudiantServiceImpl implements IEtudiantService {

	private static Session s = HibernateUtil.getSessionFactory().openSession(); 
	
	public Etudiant getEtudiant(int id){
		Etudiant etu = null;
		try {
			s.beginTransaction();
			
			etu = s.get(Etudiant.class, id);
			
			s.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			s.getTransaction().rollback();
		}

		return etu;
	}
	
	public List<Etudiant> getEtudiants(){
		List<Etudiant> listeEtudiant = null;
		try {
			s.beginTransaction();
			
			listeEtudiant = s.createNativeQuery("select * from Etudiant", Etudiant.class).list();
			
			s.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			s.getTransaction().rollback();
		}
		return listeEtudiant;
	}
	
	public void saveEtudiant(Etudiant etu) {
		
		try {
			s.beginTransaction();
			s.save(etu);
			s.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			s.getTransaction().rollback();
		}

	}
	
	public void deleteEtudiant(Etudiant etu) {
		
		try {
			s.beginTransaction();
			s.delete(etu);
			s.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			s.getTransaction().rollback();
		}
	
	}
	
	public void deleteEtudiant(int id) {
		
		try {
			s.beginTransaction();
			s.delete(s.get(Etudiant.class, id));
			s.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			s.getTransaction().rollback();
		}
	
	}
}
