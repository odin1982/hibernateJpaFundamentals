package org.hibernate.data;

import java.time.LocalDateTime;

import org.hibernate.Session;
import org.hibernate.data.entities.User;

public class ApplicationUsingNullable {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.getTransaction().begin();
		
		User user = new User();
		// si no usas nullable se lanazara una exception como esta  org.hibernate.exception.ConstraintViolationException
		// cuando tienes nullable = false se lanzara la siguiente exception de hibernate
		//  org.hibernate.PropertyValueException: not-null property references a null or transient value : org.hibernate.data.entities.User.birthDate
		user.setBirthDate(null);
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
		session.close();
	}

}
