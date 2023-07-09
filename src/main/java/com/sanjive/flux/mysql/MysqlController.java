package com.sanjive.flux.mysql;

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
@RequestMapping("/mysql")
public class MysqlController {
	
	@Autowired 
	MysqlService mysqlService;
	
//	@GetMapping("/mono")
//	public Mono<String> getMono() {
//		return Mono.just("String");
//	}

	@GetMapping("/GetEmployee")
	public Flux<Employee> getEmployee() {
		Flux<Employee> emp=mysqlService.findAll();
		return emp;
	}

	@PostMapping("/AddEmployee")
	public Mono<Employee> addEmployee(@RequestBody Employee employee) {
		return mysqlService.save(new Employee(employee.getName(), employee.getPhonenumber(), employee.getLocation(),
				employee.getDesignation()));
	}
	
	@PutMapping("/UpdateEmployee")
	public Mono<String> UpdateEmployee(@RequestBody Employee employee) {
		return mysqlService.update(employee);
		
	}
	
	@DeleteMapping("/DeleteEmployee/{id}")
	public Mono<String> DeleteEmployee(@PathVariable int id) {
		return mysqlService.delete(id);
	}
}
