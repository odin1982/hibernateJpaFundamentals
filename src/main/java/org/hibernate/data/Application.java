package org.hibernate.data;

import java.time.LocalDateTime;

import org.hibernate.Session;
import org.hibernate.data.entities.User;

public class Application {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.getTransaction().begin();
		
		User user = new User();
		user.setBirthDate(LocalDateTime.now());
		user.setCreatedBy("amaya8");
		user.setCreatedDate(LocalDateTime.now());
		user.setEmailAddress("kmb385@yahoo.com");
		user.setFirstName("Generation Property Access");
		user.setLastName("Bowersox");
		user.setLastUpdatedBy("odin8");
		user.setLastUpdatedDate(LocalDateTime.now().plusDays(1));
		user.setCreatedDate(LocalDateTime.now().plusDays(2));
		
		session.save(user);
		
		session.getTransaction().commit();
		session.close();
	}

}
