package org.hibernate.data.entities;

import java.time.LocalDateTime;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author odin
 * @Entity: indica que esta clase va estar mapeada a la tabña finances_user
 * @Table(name="[nombre-tabla]") indica con que tabla va tener relacion
 * @Id: Indica que este campo sera la clave primaria
 * @GeneratedValue: Indica la forma en que se genera el autoincremento para tu llave primaria
 * @Column: Indica a que columna de la tabla hace referencia,tambien en cada insert o en cada update en ocasiones vamos 
 * a necesitar que algunas campos no sean insertado  o actualizados pra eso tenemos la propiedad
 * GenerationType.SEQUENCE =  se usa para base de datos oracle ya que
 * @Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="user_seq")
	@Sequencegenerator(name="user_seq",sequenceName="USER_ID_SEQ")
	@Column(name="USER_ID")
	private Long userId;
 */
@Entity 
@Table(name="FINANCES_USER")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="USER_ID")
	private Long userId;
	
	@Column(name="FIRST_NAME")
	private String firstName;
	
	@Basic
	@Column(name="LAST_NAME",nullable=false)
	private String lastName;
	
	//nullable=false indica que este campo no debe de ser nulo tambien se puede poner la anotacion @Basic
	@Column(name="BIRTH_DATE",nullable=false)
	private LocalDateTime birthDate;
	
	@Column(name="EMAIL_ADDRESS")
	private String emailAddress;
	
	@Column(name="LAST_UPDATED_DATE")
	private LocalDateTime lastUpdatedDate;
	
	@Column(name="LAST_UPDATED_BY")
	private String lastUpdatedBy;
	
	//updatable=false cuando se haga un update no se tomara en cuenta este campo
	@Column(name="CREATED_DATE",updatable=false)
	private LocalDateTime createdDate;
	
	//updatable=false cuando se haga un update no se tomara en cuenta este campo
	@Column(name="CREATED_BY",updatable = false)
	private String createdBy;
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public LocalDateTime getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(LocalDateTime birthDate) {
		this.birthDate = birthDate;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public LocalDateTime getLastUpdatedDate() {
		return lastUpdatedDate;
	}
	public void setLastUpdatedDate(LocalDateTime lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}
	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}
	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}
	public LocalDateTime getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
}
