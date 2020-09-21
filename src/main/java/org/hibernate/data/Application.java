package org.hibernate.data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.data.entities.Account;
import org.hibernate.data.entities.Address;
import org.hibernate.data.entities.Bank;
import org.hibernate.data.entities.Credential;
import org.hibernate.data.entities.Transaction;
import org.hibernate.data.entities.User;

public class Application {
	
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			
			session.getTransaction().begin();
			Account account = getAccountObject();
			account.getTransactions().add(getTransactionObject(account));
			account.getTransactions().add(getTransactionObject2(account));
			session.save(account);
			
			
			session.getTransaction().commit();
			
			Transaction dbTransaction = (Transaction)session.get(Transaction.class, account.getTransactions().get(0).getTransactionId());
			System.out.println(dbTransaction.getAccount().getName());
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
			HibernateUtil.getSessionFactory().close();
		}
	}
	
	
	public static Address getAddressObject() {
		Address address = new Address();
		address.setAddressLine1("Av Bneito Juarez Nte no.11");
		address.setAddressLine2("Rosales O-32");
		address.setCity("Ecatepec");
		address.setState("HG");
		address.setZipCode("55100");
		
		return address;
	}
	
	public static Address getAddressObject2() {
		Address address = new Address();
		address.setAddressLine1("Av San Antonio Nte no.11");
		address.setAddressLine2("Ejercito Nacional O-32");
		address.setCity("Pachuca");
		address.setState("HG");
		address.setZipCode("43820");
		
		return address;
	}
	
	public static User getUserObject() {
		User user = new User();
		user.setFirstName("Armando");
		user.setLastName("Rocha");
		user.setBirthDate(LocalDateTime.now());
		user.setEmailAddress("armando@gmail.com");
		user.setLastUpdatedBy("odin");
		user.setLastUpdatedDate(LocalDateTime.now());
		user.setCreatedBy("odin");
		user.setCreatedDate(LocalDateTime.now());
		
		return user;
	}
	
	public static Bank getBankObject() {
		Bank bank = new Bank();
		bank.setName("Banamex");
		bank.setCreatedBy("Jorge Ramirez");
		bank.setAddressType("No lo se");
		bank.setCreatedDate(LocalDateTime.now());
		bank.setIsInternational(1);
		bank.setLastUpdatedBy("Odin Araujo");
		bank.setLastUpdatedDate(LocalDateTime.now());
		bank.setAddress(getAddressObject());
		
		return bank;
	}
	
	public static Credential getCredentialObject() {
		Credential credential = new Credential();
		credential.setPassword("cuak");
		credential.setUsername("vikingo");
		
		return credential;
	}
	
	public static List<Transaction> getTransactionsList() {
		ArrayList<Transaction> listTransactions = new ArrayList<>();
		
		Transaction t = new Transaction();
		t.setAmount(23.5);
		t.setClosingBalance(56.89);
		t.setCreatedBy("odin");
		t.setCreatedDate(LocalDateTime.now());
		t.setInitialBalance(43.67);
		t.setLastUpdatedBy("amaya");
		t.setLastUpdatedDate(LocalDateTime.now());
		t.setNotes("no exiset Nota");
		t.setTitle("T-101");
		t.setTransactionType("TypeTransaction");
		
		Transaction t2 = new Transaction();
		t2.setAmount(73.5);
		t2.setClosingBalance(76.89);
		t2.setCreatedBy("odin2");
		t2.setCreatedDate(LocalDateTime.now());
		t2.setInitialBalance(73.67);
		t2.setLastUpdatedBy("amaya2");
		t2.setLastUpdatedDate(LocalDateTime.now());
		t2.setNotes("no exiset Nota 2");
		t2.setTitle("T-1012");
		t2.setTransactionType("TypeTransaction2");
		
		listTransactions.add(t);
		listTransactions.add(t2);
		
		return listTransactions;
	}
	
	public static Account getAccountObject() {
		Account a = new Account();
		a.setAccountType("accountType");
		a.setBankId(1L);
		a.setCloseDate(LocalDate.now());
		a.setCreatedBy("odin");
		a.setCreatedDate(LocalDateTime.now());
		a.setCurrentBalance(20.36);
		a.setInitialBalance(88.90);
		a.setLastUpdatedBy("amaya");
		a.setLastUpdatedDate(LocalDateTime.now());
		a.setName("nameAccount");
		a.setOpenDate(LocalDate.now());
		
		return a;
	}
	
	private static Transaction getTransactionObject(Account account) {
		Transaction t = new Transaction();
		t.setAccount(account);
		t.setAmount(23.5);
		t.setClosingBalance(56.89);
		t.setCreatedBy("odin");
		t.setCreatedDate(LocalDateTime.now());
		t.setInitialBalance(43.67);
		t.setLastUpdatedBy("amaya");
		t.setLastUpdatedDate(LocalDateTime.now());
		t.setNotes("no exiset Nota");
		t.setTitle("T-101");
		t.setTransactionType("TypeTransaction");
		
		
		return t;
	}
	
	private static Transaction getTransactionObject2(Account account) {
		Transaction t = new Transaction();
		t.setAccount(account);
		t.setAmount(99.9);
		t.setClosingBalance(99.99);
		t.setCreatedBy("sarai");
		t.setCreatedDate(LocalDateTime.now());
		t.setInitialBalance(88.88);
		t.setLastUpdatedBy("amaya");
		t.setLastUpdatedDate(LocalDateTime.now());
		t.setNotes("no exiset Nota");
		t.setTitle("T-101");
		t.setTransactionType("TypeTransaction");
		
		
		return t;
	}
	
	
}
