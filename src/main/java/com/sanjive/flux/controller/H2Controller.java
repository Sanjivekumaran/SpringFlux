package com.sanjive.flux.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sanjive.flux.model.Employee;
import com.sanjive.flux.repository.H2Repository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class H2Controller {
	
	@Autowired
	H2Repository h2Repository;
	
	@GetMapping("/mono")
	public Mono<String> getMono(){
		return Mono.just("String");
	}
	
	@GetMapping("/GetEmployee")
	public Flux<Employee> getEmployee(){
		return h2Repository.findAll();
	}
	
	@PostMapping("/AddEmployee")
	public Mono<Employee> addEmployee(@RequestBody Employee employee){
		return h2Repository.save(new Employee(employee.getName(),employee.getPhonenumber(), employee.getLocation(),employee.getDesignation()));
	}
	
}
