package be.helha.aemt.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import be.helha.aemt.entities.Message;
import be.helha.aemt.entities.Picture;
import be.helha.aemt.exception.AddDuplicateException;
import be.helha.aemt.exception.IDNotFoundException;

@LocalBean
@Stateless
public class MessageDAO {

	@PersistenceContext(unitName = "pGroupeB5JTA")
	private EntityManager em;
	
	public List<Message> findAll() {
		return em.createQuery("SELECT m FROM Message m").getResultList();
	}
	
	public void add(Message message) throws AddDuplicateException {
		if(targetSelect(message)!=null)throw new AddDuplicateException();
		em.persist(message);
	
	}
	
	public Message targetSelect(Message message) {
	Query qGet = em.createQuery("SELECT m FROM Message m WHERE m.sendEmail = :mSendEmail AND m.subject = :mSubject AND m.messageType = :mMessageType");
	qGet.setParameter("mSendEmail",message.getSendEmail());
	qGet.setParameter("mSubject", message.getSujet());
	qGet.setParameter("mMessageType",message.getMessageType());
	List<Message> tmp = qGet.getResultList();
	return tmp.size()== 0 ? null : tmp.get(0);
	}
	
	public void delete(Message message) throws IDNotFoundException {
		if(targetSelect(message)==null) 
			throw new IDNotFoundException();
		em.remove(message);
	}
	
}
