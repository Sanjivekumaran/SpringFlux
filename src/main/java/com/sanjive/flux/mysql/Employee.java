package com.sanjive.flux.mysql;

import java.io.Serializable;
import java.util.Random;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="employee")
public class Employee implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(value="id")
	private int id;
	
	@Column(value="name")
	private String name;
	
	@Column(value="location")
	private String location;
	
	@Column(value="phonenumber")
	private String phonenumber;
	
	@Column(value="designation")
	private String designation;
	
	public Employee(String name, String phonenumber, String location, String designation){
//		Random rand = new Random();
//
//		int random = rand.nextInt(1000);
//		this.id=random;
		this.designation=designation;
		this.name=name;
		this.location=location;
		this.phonenumber=phonenumber;
	}
}
