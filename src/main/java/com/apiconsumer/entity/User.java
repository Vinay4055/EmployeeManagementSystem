package com.apiconsumer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "User")
public class User {
	@Id
	@Column(name = "id")
	@NotEmpty(message = "Id is mandatory")
	@Size(min=5,max=50,message="Range of id should be between 5 to 50")
	private String id;
	@Column(name = "name", unique = true, nullable = false)
	@NotEmpty(message = "Name is mandatory")
	String name;
	@NotEmpty(message = "Password is mandatory")
	@Column(name = "password")
	String password;
}
