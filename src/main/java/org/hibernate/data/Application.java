package org.hibernate.data;

import java.time.LocalDateTime;

import org.hibernate.Session;
import org.hibernate.data.entities.Address;
import org.hibernate.data.entities.Bank;
import org.hibernate.data.entities.User;

public class Application {
	
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			
			session.getTransaction().begin();
			Bank bank = getBankObject();
			session.save(bank);
			
			User user = getUserObject();
			user.setAddress(getAddressObject());
			session.save(user);
			
			session.getTransaction().commit();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
			HibernateUtil.getSessionFactory().close();
		}
	}
	
	
	public static Address getAddressObject() {
		Address address = new Address();
		address.setAddressLine1("Av Juarez Nte no.11");
		address.setAddressLine2("Condominio O-32");
		address.setCity("Tizayuca");
		address.setState("HG");
		address.setZipCode("43800");
		
		return address;
	}
	
	public static User getUserObject() {
		User user = new User();
		user.setFirstName("Guillermo");
		user.setLastName("Ochoa");
		user.setBirthDate(LocalDateTime.now());
		user.setEmailAddress("meme@gmail.com");
		user.setLastUpdatedBy("me");
		user.setLastUpdatedDate(LocalDateTime.now());
		user.setCreatedBy("me");
		user.setCreatedDate(LocalDateTime.now());
		
		return user;
	}
	
	public static Bank getBankObject() {
		Bank bank = new Bank();
		bank.setName("Federal Trust");
		bank.setCreatedBy("Alfredo Talavera");
		bank.setAddressType("No lo se");
		bank.setCreatedDate(LocalDateTime.now());
		bank.setIsInternational(1);
		bank.setLastUpdatedBy("Odin Araujo");
		bank.setLastUpdatedDate(LocalDateTime.now());
		bank.setAddress(getAddressObject());
		
		return bank;
	}
}
