package be.helha.aemt.util;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import be.helha.aemt.entities.Address;
import be.helha.aemt.entities.Event;
import be.helha.aemt.entities.InternshipOffer;
import be.helha.aemt.entities.JobOffer;
import be.helha.aemt.entities.Message;
import be.helha.aemt.entities.News;
import be.helha.aemt.entities.Offer;
import be.helha.aemt.entities.OverView;
import be.helha.aemt.entities.Picture;
import be.helha.aemt.entities.User;
import be.helha.aemt.model.MessageType;
import be.helha.aemt.model.SectionEconomicHELHaMons;


public class MainPersist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pGroupeB5Local");
		EntityManager em = emf.createEntityManager();		
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		
		em.persist(new JobOffer());
		em.persist(new InternshipOffer());
		
		tx.commit();
		
		em.close();
		emf.close();
	}

}
