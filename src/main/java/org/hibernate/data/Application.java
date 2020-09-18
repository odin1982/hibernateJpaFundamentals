package org.hibernate.data;

import java.time.LocalDateTime;

import org.hibernate.Session;
import org.hibernate.data.entities.User;

public class Application {
	/**
	 * 
	 * @param args
	 * Se agrego un nuevo atributo a la clase User que es valid si se ejecuta o se
	 * trata de gusrdar este objeto mandara una exception como esta
	 * Caused by: java.sql.SQLSyntaxErrorException: Unknown column 'valid' in 'field list'
	 * pero es una propiedad que no tiene nada que ver con la base de datos y no necesitamos mappearla
	 * para que no courra esto necesitamos ignorar este campo y lo hacemos con @Transient
	 */
	
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.getTransaction().begin();
		
		User user = new User();
		user.setBirthDate(LocalDateTime.now());
		user.setCreatedBy("amaya8");
		user.setCreatedDate(LocalDateTime.now());
		user.setEmailAddress("guillermo@yahoo.com");
		user.setFirstName("Jesus Corona");
		user.setLastName("Corona");
		user.setLastUpdatedBy("guillermo");
		user.setLastUpdatedDate(LocalDateTime.now().plusDays(1));
		user.setCreatedDate(LocalDateTime.now().plusDays(2));
		
		session.save(user);
		session.getTransaction().commit();
		
		session.close();
	}

}
