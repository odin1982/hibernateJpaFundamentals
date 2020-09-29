package org.hibernate.data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.data.entities.Account;
import org.hibernate.data.entities.Address;
import org.hibernate.data.entities.Bank;
import org.hibernate.data.entities.Credential;
import org.hibernate.data.entities.Currency;
import org.hibernate.data.entities.Market;
import org.hibernate.data.entities.Transaction;
import org.hibernate.data.entities.User;

public class Application {

	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Session session = null;
		
		org.hibernate.Transaction tx = null;
		org.hibernate.Transaction tx2 = null;
		
		try {
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			
			Currency currency = new Currency();
			currency.setCountryName("United Kingdom");
			currency.setName("Pound");
			currency.setSymbol("Pound Sign");
			
			Market market = new Market();
			market.setMarketName("Londom Stock Exchange");
			market.setCurrency(currency);
			
			session.persist(market);
			tx.commit();
			
			Market dbMarket =(Market)session.get(Market.class, market.getMarketId());
			System.out.println(dbMarket.getCurrency().getName());
			
		}catch(Exception ex) {
			ex.printStackTrace();
			tx.rollback();
		}finally {
			session.close();
			sessionFactory.close();
		}
	
	}

	public static Address getAddressObject() {
		Address address = new Address();
		address.setAddressLine1("Av Acoyoacan Sur No.22");
		address.setAddressLine2("Primaveras 25");
		address.setCity("Miguel Hidalgo");
		address.setState("DF");
		address.setZipCode("43100");

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

//		List<Address> addresses = new ArrayList<>();
//		addresses.add(getAddressObject());
//		addresses.add(getAddressObject2());
//		user.setAddress(addresses);

		return user;
	}

	public static Bank getBankObject() {
		Bank bank = new Bank();
		bank.setName("Bancomer");
		bank.setCreatedBy("Rudolfino Perez");
		bank.setAddressType("Av Acoyoacan Sur No.22");
		bank.setCreatedDate(LocalDateTime.now());
		bank.setIsInternational(0);
		bank.setLastUpdatedBy("Odin Araujo " + LocalDateTime.now());
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
		t.setAmount(11.1);
		t.setClosingBalance(11.11);
		t.setCreatedBy("odin " + LocalDateTime.now());
		t.setCreatedDate(LocalDateTime.now());
		t.setInitialBalance(11.11);
		t.setLastUpdatedBy("amaya " + LocalDateTime.now());
		t.setLastUpdatedDate(LocalDateTime.now());
		t.setNotes("nota " + LocalDateTime.now());
		t.setTitle("titulo " + LocalDateTime.now());
		t.setTransactionType("transactionType" + LocalDateTime.now());

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
		a.setAccountType("Perfiles");
		a.setBankId(1L);
		a.setCloseDate(LocalDate.now());
		a.setCreatedBy("odin " + LocalDate.now());
		a.setCreatedDate(LocalDateTime.now());
		a.setCurrentBalance(11.11);
		a.setInitialBalance(11.11);
		a.setLastUpdatedBy("sarai");
		a.setLastUpdatedDate(LocalDateTime.now());
		a.setName("Perfiles Citirewards");
		a.setOpenDate(LocalDate.now());

		return a;
	}

	private static Transaction getTransactionObject(Account account) {
		Transaction t = new Transaction();
		t.setAmount(11.1);
		t.setClosingBalance(11.11);
		t.setCreatedBy("odin " + LocalDateTime.now());
		t.setCreatedDate(LocalDateTime.now());
		t.setInitialBalance(11.11);
		t.setLastUpdatedBy("amaya " + LocalDateTime.now());
		t.setLastUpdatedDate(LocalDateTime.now());
		t.setNotes("nota " + LocalDateTime.now());
		t.setTitle("titulo " + LocalDateTime.now());
		t.setTransactionType("transactionType" + LocalDateTime.now());

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
