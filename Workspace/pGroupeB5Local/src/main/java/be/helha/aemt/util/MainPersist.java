package be.helha.aemt.util;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import be.helha.aemt.entities.Address;
import be.helha.aemt.entities.Event;
import be.helha.aemt.entities.Message;
import be.helha.aemt.entities.News;
import be.helha.aemt.entities.OverView;
import be.helha.aemt.entities.Picture;
import be.helha.aemt.model.MessageType;
import be.helha.aemt.model.SectionEconomicHELHaMons;


public class MainPersist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pGroupeB5Local");
		EntityManager em = emf.createEntityManager();		
		EntityTransaction tx = em.getTransaction();
		
		Picture p = new Picture("");
		
		tx.begin();
		em.persist(p);
		tx.commit();
		
		Event e = new Event("", "", "", SectionEconomicHELHaMons.IG, "");
		e.add(p);
		Address a = new Address("", "", "", "", "", "");
		Message m = new Message("", "", MessageType.EVENT_PROMOTE);
		OverView o = new OverView("", "", p, "");
		
		tx.begin();
		em.persist(new Address());
		em.persist(new Event());
		em.persist(new Message());
		em.persist(new OverView());
		em.persist(new News());	
		tx.commit();
		
		em.close();
		emf.close();
	}

}
