package com.appsoft.springcrudproject.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity(name="Customer")
@Table(name="customer")
public class Customer {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id")
	private int  id;
	
	@NotEmpty(message="First Name is required")
	@Size(min=3 , message="First Name should be atleast 5 character")
	@Column(name="first_name")
	private String firstName;
	
	@NotEmpty(message = "Last name is required")
	@Column(name="last_name")
	private String lastName;
	@NotEmpty(message="Email is required")
	@Email(message="Please enter a valid email address")
	@Column(name="email")
	private String email;
	@NotEmpty(message = "Phone is required")
	@Column(name="phone")
	private String phone;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "\nCustomer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", phone=" + phone + "]";
	}
	
	
}
