package com.microserviceuser.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(	name = "usersWatt",
		uniqueConstraints = { 
			@UniqueConstraint(columnNames = "username"),
			@UniqueConstraint(columnNames = "email") 
		})
public class User{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Size(max = 20)
	private String username;

	@NotBlank
	@Size(max = 50)
	@Email
	private String email;

	@NotBlank
	@Size(max = 120)
	private String password;
	@NotBlank
	@Size(max = 30)
	String prenom;
	@NotBlank
	@Size(max = 30)
	String nom;
	@NotBlank
	@Size(max = 15)
	String phone;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date date;



	Boolean newsletter;
	Boolean active;


	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(	name = "usersWatt_roles",
				joinColumns = @JoinColumn(name = "usersWatt_id"),
				inverseJoinColumns = @JoinColumn(name = "rolesWatt_id"))
	private Set<Role> roles = new HashSet<>();

	public User() {
	}

	public User(String username,Date date, String nom, String prenom, String phone, String email, String password, boolean active,boolean newsletter) {
		this.username = username;
		this.phone = phone;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.password = password;
		this.active = active;
		this.newsletter=newsletter;
		this.date=date;
	}

	public Boolean getNewsletter() {
		return newsletter;
	}

	public void setNewsletter(Boolean newsletter) {
		this.newsletter = newsletter;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	private User(Builder builder) {
		this.id=builder.id;
		this.prenom=builder.prenom;
		this.nom=builder.nom;
		this.username=builder.username;
		this.password=builder.password;
		this.email=builder.email;
		this.phone=builder.phone;
		this.date=builder.date;
		this.active=builder.active;
	}

	public static class Builder{
		Long id;
		String prenom;
		String nom;
		String username;
		String password;
		String email;
		String phone;
		Date date;
		Boolean active;

		public  User.Builder id(Long id){
			this.id= id;
			return this;}
		public User.Builder prenom(String prenom){
			this.prenom= prenom;
			return this;}
		public User.Builder nom(String nom){
			this.nom= nom;
			return this;}
		public User.Builder username(String username){
			this.username= username;
			return this;}
		public User.Builder password(String password){
			this.password= password;
			return this;}
		public User.Builder email(String email){
			this.email= email;
			return this;}
		public User.Builder phone(String phone){
			this.phone= phone;
			return this;}
		public User.Builder date(Date date){
			this.date= date;
			return this;}
		public User.Builder  active( Boolean active){
			this. active=  active;
			return this;}
		public User build(){
			return new User(this);}

	}

}
