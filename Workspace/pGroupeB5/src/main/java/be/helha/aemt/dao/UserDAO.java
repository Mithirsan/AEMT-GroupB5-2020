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

import be.helha.aemt.entities.User;

@Stateless
@LocalBean
public class UserDAO {
	
	@PersistenceContext(unitName = "pGroupeB5JTA")
	private EntityManager em;
	
	public List<User> findAll() {
		return em.createQuery("SELECT u FROM User u").getResultList();
	}
	
	public void add(User user) {
		em.persist(user);
	}
	
	public void update(User newUser) {
		em.merge(newUser);
	} 
	
	public User login(String email, String password) {
		String hashWord = "";
		try {
			hashWord = toHexString(getSHA(password));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		Query qGet = em.createQuery("SELECT u FROM User u WHERE u.email = :userEmail AND u.password = :userPwd");
		qGet.setParameter("userEmail", email);
		qGet.setParameter("userPwd", hashWord);
		List<User> tmp = qGet.getResultList();
		return tmp.size()== 0 ? null : tmp.get(0);
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
