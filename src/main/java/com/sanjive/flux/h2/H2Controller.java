package com.sanjive.flux.h2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/h2")
public class H2Controller {

	@Autowired
	H2Service h2Service;

	@PostMapping("/mono")
	public Mono<String> getMono(@RequestBody String string) {
		return Mono.just(string);
	}

	@GetMapping("/GetEmployee")
	public Flux<Employee> getEmployee() {
		Flux<Employee> emp = h2Service.findAll();
		return emp;
	}

	@PostMapping("/AddEmployee")
	public Mono<String> addEmployee(@RequestBody Employee employee) {
		if(employee.getName()==null) {
			return Mono.just("Name missing");
		}
		else if(employee.getPhonenumber()==null) {
			return Mono.just("Phonenumber missing");
		}
		else if(employee.getLocation()==null) {
			return Mono.just("Location missing");
		}
		else if(employee.getDesignation()==null) {
			return Mono.just("Designation missing");
		}
		h2Service.save(new Employee(employee.getName(), employee.getPhonenumber(), employee.getLocation(), employee.getDesignation()));
		return Mono.just("Saved Successfully");
	}

	@PutMapping("/UpdateEmployee")
	public Mono<String> UpdateEmployee(@RequestBody Employee employee) {
		return h2Service.update(employee);

	}

	@DeleteMapping("/DeleteEmployee/{id}")
	public Mono<String> DeleteEmployee(@PathVariable int id) {
		return h2Service.delete(id);
	}
	
	@DeleteMapping("/DeleteAll")
	public Mono<String> DeleteEmployee() {
		return h2Service.deleteAll();
	}
}
