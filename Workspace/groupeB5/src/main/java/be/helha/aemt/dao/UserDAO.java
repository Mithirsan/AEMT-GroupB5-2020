package be.helha.aemt.dao;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import be.helha.aemt.entities.User;
import be.helha.aemt.exception.AddDuplicateException;
import be.helha.aemt.exception.AdminDeleteException;
import be.helha.aemt.model.UserGroup;

@Stateless
@LocalBean
public class UserDAO {
	
	@PersistenceContext(unitName = "pGroupeB5JTA")
	private EntityManager em;
	
	public List<User> findAll() {
		return em.createQuery("SELECT u FROM User u").getResultList();
	}
	
	public List<User> findInvalid() {
		return em.createQuery("SELECT u FROM User u WHERE u.validAccount = 0").getResultList();
	}
	
	public void add(User user) throws AddDuplicateException {
		if(targetSelect(user)!=null)throw new AddDuplicateException();
		try {
			user.setPassword(toHexString(getSHA(user.getPassword())));
			em.persist(user);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public User targetSelect(User user) {
	Query qGet = em.createQuery("SELECT u FROM User u WHERE u.email = :userEmail");
	qGet.setParameter("userEmail", user.getEmail());
	List<User> tmp = qGet.getResultList();
	return tmp.size()== 0 ? null : tmp.get(0);
	}
	
	public void delete(User user) throws AdminDeleteException {
		if(user.getGroupName()==UserGroup.ADMIN) 
			throw new AdminDeleteException();
		em.createQuery("DELETE FROM User u WHERE u.id = " + user.getId()).executeUpdate();
	}
	
	public void update(User newUser) {
		em.merge(newUser);
	} 
	
	
	public byte[] getSHA(String input) throws NoSuchAlgorithmException{  
        MessageDigest md = MessageDigest.getInstance("SHA-256");  
        return md.digest(input.getBytes(StandardCharsets.UTF_8));  
    } 
    
    public String toHexString(byte[] hash) { 
        BigInteger number = new BigInteger(1, hash);   
        StringBuilder hexString = new StringBuilder(number.toString(16));  
        while (hexString.length() < 32)  
        {  
            hexString.insert(0, '0');  
        }  
        return hexString.toString();  
    }
}
