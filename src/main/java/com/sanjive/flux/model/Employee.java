package com.sanjive.flux.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
	@Id
	private int id;
	private String name;
	private String location;
	private String phonenumber;
	private String designation;
	
	public Employee(String name, String phonenumber, String location, String designation){
		this.designation=designation;
		this.name=name;
		this.location=location;
		this.phonenumber=phonenumber;
	}
}
