package com.employeemanagement.backend.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.*;

import org.hibernate.validator.constraints.UniqueElements;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "first_name")
	//@NotBlank(message = "name should not be blank")
	private String firstName;
	
	@Column(name = "last_name")
	//@NotBlank(message = "name should not be blank")
	private String lastName;
	@Column(name = "dept")
	//@NotBlank(message = "dept should not be blank")
	private String dept;
	
	@Column(name="username")
	//@NotBlank(message = "username should not be blank")
	//@UniqueElements(message = "username ")
	private String username;
	
	@Column(name = "password")
	//@NotBlank(message = "password should not be blank")
	private String password;
	
	@Column(name = "gender")
	//@NotBlank(message = "gender should not be blank")
	private String gender;
	
	@Column(name = "role")
	//@NotBlank(message = "gender should not be blank")
	private String role;
	
	@Column(name = "age")
	//@NotBlank(message = "age should not be blank")
	//@Min(10)
	private int age;
	
	@Column(name = "emp_id")
	//@NotBlank(message = "name should not be blank")
	private Long emp_id;
	
	@Column(name = "date_created")
	private Date date_created;
	
	@Column(name = "last_loggedin")
	private Date last_loggedin;

	@Column(name = "active")
	private String active;
	
	
	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public Date getLast_loggedin() {
		return last_loggedin;
	}

	public void setLast_loggedin(Date last_loggedin) {
		this.last_loggedin = last_loggedin;
	}

	public Date getDate_created() {
		return date_created;
	}

	public void setDate_created(Date date_created) {
		this.date_created = date_created;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
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

	public Long getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(Long emp_id) {
		this.emp_id = emp_id;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", dept=" + dept
				+ ", username=" + username + ", password=" + password + ", gender=" + gender + ", role=" + role
				+ ", age=" + age + ", emp_id=" + emp_id + ", date_created=" + date_created + ", last_loggedin="
				+ last_loggedin + ", active=" + active + "]";
	}

	

	

	
}
