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
import be.helha.aemt.model.UserGroup;


public class MainPersist {

	public static void main(String[] args) {
		
/*		User admin = new User("admin", "77e467eb0169e82e77f090df217a323357c6a157a98c0375e6f6dbafe029c83a", "Admin", "HELHa", "Administrateur", "", new Picture(), "", "", true, SectionEconomicHELHaMons.ALL);	
		admin.setGroupName(UserGroup.ADMIN);
		admin.setValidAccount(true); */
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pGroupeB5Local");
		EntityManager em = emf.createEntityManager();		
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
//		em.persist(admin);
		
/*		
		em.persist(new JobOffer());
		em.persist(new InternshipOffer());
		em.persist(new User());
		em.persist(new Event());
		em.persist(new Message());
		em.persist(new News());
		em.persist(new OverView());
*/
		tx.commit();
		
		em.close();
		emf.close();
	}

}
