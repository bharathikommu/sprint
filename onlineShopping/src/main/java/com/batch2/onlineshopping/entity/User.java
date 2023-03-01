package com.batch2.onlineshopping.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = "username"))
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
//	@Pattern(regexp="^[a-zA-Z]{6,12}$")
	private String username;
//	@Pattern(regexp="^[0-9]$")
	private String phoneNo;
//	@Pattern(regexp="^\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,3}$")
	private String emailId;
//	@Pattern(regexp = "^.(?=.{8,})(?=..[0-9])(?=.[a-z])(?=.[A-Z])(?=.[@#$%^&+=]).$")
	private String password;
	@Transient
	private String confirmPassword;
	private String role;

	
	  @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	  
	  @JoinTable(name = "User_Products", joinColumns = { @JoinColumn(name =
	  "user_id") }, inverseJoinColumns = {
	  
	  @JoinColumn(name = "product_id") }) private List<Products> products;
	  
	  public List<Products> getProducts() { return products; }
	  
	  public void setProducts(List<Products> products) { this.products = products;
	  }
	 

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
