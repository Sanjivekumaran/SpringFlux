//package com.sanjive.flux.h2;
//
//import java.io.Serializable;
//import java.util.Random;
//
//import org.springframework.data.annotation.Id;
//import org.springframework.data.relational.core.mapping.Table;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//public class Employee implements Serializable {
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L;
//	
//	@Id
//	private int id;
//	
//	private String name;
//	
//	private String location;
//	
//	private String phonenumber;
//	
//	private String designation;
//	
//	public Employee(String name, String phonenumber, String location, String designation){
//		// TODO Auto-generated method stub
//		Random rand = new Random();
//
//		int random = rand.nextInt(1000);
//		this.id=random;
//		this.designation=designation;
//		this.name=name;
//		this.location=location;
//		this.phonenumber=phonenumber;
//	}
//}
