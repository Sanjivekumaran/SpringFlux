package com.sanjive.flux.mysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class MysqlService {
	
	@Autowired
	MysqlRepository mysqlRepository;
	
	public Flux<Employee> findAll() {
		// TODO Auto-generated method stub
		return mysqlRepository.findAll();
		
	}

	public Mono<Employee> save(Employee employee) {
		// TODO Auto-generated method stub
		return mysqlRepository.save(employee);
	}

	public Mono<String> update(Employee employee) {
		// TODO Auto-generated method stub
		return mysqlRepository.findById(employee.getId()).flatMap(emp -> {
			if (emp != null) {
				emp.setLocation(employee.getLocation());
				emp.setDesignation(employee.getDesignation());
				emp.setName(employee.getName());
				emp.setPhonenumber(employee.getPhonenumber());
				mysqlRepository.save(emp).subscribe();
				return Mono.just("Saved Successfully");
			}
			return Mono.just("No employee exist");
		});
	}

	public Mono<String> delete(int id) {
		// TODO Auto-generated method stub
		return mysqlRepository.findById(id).flatMap(emp -> {
			if (emp != null) {
				mysqlRepository.deleteById(id).subscribe();
				return Mono.just("Deleted Successfully");
			}
			return Mono.just("No employee exist");
		});

	}
}
