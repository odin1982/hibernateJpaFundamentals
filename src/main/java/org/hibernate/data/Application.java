package org.hibernate.data;

import java.time.LocalDateTime;

import org.hibernate.Session;
import org.hibernate.data.entities.TimeTest;

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
		
		TimeTest test = new TimeTest(LocalDateTime.now());
		session.save(test);
		session.getTransaction().commit();
		
		session.close();
	}

}
