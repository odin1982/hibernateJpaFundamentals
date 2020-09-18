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
		user.setEmailAddress("guillermo@yahoo.com");
		user.setFirstName("Guillermo");
		user.setLastName("Ochoa");
		user.setLastUpdatedBy("guillermo");
		user.setLastUpdatedDate(LocalDateTime.now().plusDays(1));
		user.setCreatedDate(LocalDateTime.now().plusDays(2));
		
		session.save(user);
		session.getTransaction().commit();
		
		session.getTransaction().begin();
		User dbUser = (User)session.get(User.class, user.getUserId());
		dbUser.setFirstName("Joe");
		session.update(dbUser);
		session.getTransaction().commit();
		
		session.close();
	}

}
