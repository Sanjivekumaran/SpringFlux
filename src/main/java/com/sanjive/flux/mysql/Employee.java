package com.sanjive.flux.mysql;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(value="EMPLOYEE")
public class Employee implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(value="ID")
	private int id;
	
	@Column(value="NAME")
	private String name;
	
	@Column(value="LOCATION")
	private String location;
	
	@Column(value="PHONENUMBER")
	private String phonenumber;
	
	@Column(value="DESIGNATION")
	private String designation;
	
	public Employee(String name, String phonenumber, String location, String designation){
		this.designation=designation;
		this.name=name;
		this.location=location;
		this.phonenumber=phonenumber;
	}
}
