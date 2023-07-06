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
	H2Repository h2Repository;

	@GetMapping("/mono")
	public Mono<String> getMono() {
		return Mono.just("String");
	}

	@GetMapping("/GetEmployee")
	public Flux<Employee> getEmployee() {
		return h2Repository.findAll().log();
	}

	@PostMapping("/AddEmployee")
	public Mono<String> addEmployee(@RequestBody Employee employee) {
		h2Repository.save(new Employee(employee.getName(), employee.getPhonenumber(), employee.getLocation(),
				employee.getDesignation())).subscribe();
		return Mono.just("Saved Successfully");
	}
	
	@PutMapping("/UpdateEmployee")
	public Mono<String> UpdateEmployee(@RequestBody Employee employee) {
		h2Repository.findById(employee.getId()).flatMap(emp->{
			if(emp != null) {
				emp.setLocation(employee.getLocation());
				emp.setDesignation(employee.getDesignation());
				emp.setName(employee.getName());
				emp.setPhonenumber(employee.getPhonenumber());
				h2Repository.save(emp).subscribe();
			}
			return Mono.just("Saved Successfully");
		}).subscribe();
		return Mono.just("Saved Successfully");
		
	}
	
	@DeleteMapping("/DeleteEmployee/{id}")
	public Mono<String> DeleteEmployee(@PathVariable int id) {
		h2Repository.deleteById(id).subscribe();
		return Mono.just("Employee deleted");
	}
}
