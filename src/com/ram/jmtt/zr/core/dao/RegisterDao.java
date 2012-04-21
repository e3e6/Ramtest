package com.ram.jmtt.zr.core.dao;

import org.hibernate.Query;
import org.hibernate.Session;

import com.ram.jmtt.zr.core.util.HibernateUtil;

/**
 * 
 *Data Access class for RegisterBean
 */
public class RegisterDao {


	/**
	 * Save entity to database
	 * @param <T>
	 * @return true if saved successfully
	 */
	public static <T> T storeEnity(T entity){
		
		
		System.out.println("Begin saving");

		Session session = null;
		
	    try {
	      session = HibernateUtil.getSessionFactory().openSession();
	      session.beginTransaction();


	      session.save(entity);

	      session.getTransaction().commit();

	      
	      return entity;
	      
	    } catch (Exception e) {
	      e.printStackTrace();
	    } finally {
	      if (session != null && session.isOpen()) {
	        session.close();
	      }
	    }
	    
	    return null;	
	}
	
	
	/**
	 * Check is email already exist in database
	 * @param email
	 * @return true if email is unique, null if exited with error
	 */
	public static Boolean isEmailUnique(String email){
		
		//TODO Create

		
		Session session = null;
		
	    try {
	      session = HibernateUtil.getSessionFactory().openSession();
	      session.beginTransaction();

	      Query q = session.createQuery("SELECT o FROM User o WHERE o.email = :mail"); //TODO check this query
				q.setString("mail", email);

				int count = q.list().size();
				
	      session.getTransaction().commit();

	      
	      return (count == 0);
	      
	    } catch (Exception e) {
	      e.printStackTrace();
	    } finally {
	      if (session != null && session.isOpen()) {
	        session.close();
	      }
	    }
	    
	    return null;
	}
}
