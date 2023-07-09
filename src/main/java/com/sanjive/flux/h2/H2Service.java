//package com.sanjive.flux.h2;
//
//import java.util.Random;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Service;
//
//import io.r2dbc.spi.Connection;
//import io.r2dbc.spi.ConnectionFactory;
//import reactor.core.publisher.Flux;
//import reactor.core.publisher.Mono;
//
//@Service
//public class H2Service {
//
////	@Autowired
////	H2Repository h2Repository;
//
//	@Qualifier(value = "h2ConnectionFactory")
//	@Autowired
//	ConnectionFactory h2ConnectionFactory;
//
//	public Flux<Employee> findAll() {
//		// TODO Auto-generated method stub
//		return Mono.from(h2ConnectionFactory.create())
//				.flatMap((c) -> Mono.from(c.beginTransaction())
//				.then(Mono.from(c.createStatement("select id,name,location,phonenumber,designation from employee").execute()))
//				.doFinally((st) -> close(c)))
//				.flatMapMany(result -> Flux.from(result.map((row, meta) -> {
//					Employee emp = new Employee(row.get("id", Integer.class), row.get("name", String.class),
//							row.get("location", String.class), row.get("designation", String.class),
//							row.get("phonenumber", String.class));
//					return emp;
//				})));
//
//	}
//
//	public Mono<Employee> save(Employee employee) {
//
//		return Mono.from(h2ConnectionFactory.create())
//				.flatMap(c -> Mono.from(c.beginTransaction())
//				.then(Mono.from(c.createStatement("insert into Employee(id,name,phonenumber,location,designation) values($1,$2,$3,$4,$5)")
//				.bind("$1", employee.getId()).bind("$2", employee.getName())
//				.bind("$3", employee.getPhonenumber()).bind("$4", employee.getLocation())
//				.bind("$5", employee.getDesignation()).returnGeneratedValues("id").execute()))
//				.map(result -> result.map((row, meta) -> new Employee(row.get("id", Integer.class), employee.getName(),
//						employee.getPhonenumber(), employee.getLocation(), employee.getDesignation())))
//				.flatMap(pub -> Mono.from(pub)).delayUntil(r -> c.commitTransaction())
//				.doFinally((st) -> c.close()));
//	}
//
//	public Mono<Employee> update(Employee employee) {
//		return Mono.from(h2ConnectionFactory.create())
//				.flatMap(c -> Mono.from(c.beginTransaction())
//				.then(Mono.from(c.createStatement("update Employee SET name = $1, location = $2, phonenumber = $3, designation = $4 where id = $5")
//				.bind("$1", employee.getName())
//				.bind("$2", employee.getLocation())
//				.bind("$3", employee.getPhonenumber())
//				.bind("$4", employee.getDesignation())
//				.bind("$5", employee.getId()).returnGeneratedValues("id").execute()))
//				.map(result -> result.map((row, meta) -> new Employee(row.get("id", Integer.class), employee.getName(),
//						employee.getPhonenumber(), employee.getLocation(), employee.getDesignation())))
//				.flatMap(pub -> Mono.from(pub)).delayUntil(r -> c.commitTransaction()).doFinally((st) -> c.close()));
//	}
//
//	public Mono<String> delete(int id) {
//		return Mono.from(h2ConnectionFactory.create())
//				.flatMap(c -> Mono.from(c.beginTransaction())
//				.then(Mono.from(c.createStatement("delete from employee where id = $1;")
//				.bind("$1", id).execute()))
//				.map(result -> result.map((row, meta) -> new String("Deleted Successfully")))
//				.flatMap(pub -> Mono.from(pub))
//				.delayUntil(r -> c.commitTransaction())
//				.doFinally((st) -> close(c)));
//	}
//
//	private <T> Mono<T> close(Connection connection) {
//		return Mono.from(connection.close()).then(Mono.empty());
//	}
//
////	public Flux<Employee> findAll() {
////		// TODO Auto-generated method stub
////		return h2Repository.findAll();
////
////	}
////
////	public Mono<Employee> save(Employee employee) {
////		return h2Repository.save(employee);
////	}
////
////	public Mono<String> update(Employee employee) {
////		// TODO Auto-generated method stub
////		return h2Repository.findById(employee.getId()).flatMap(emp -> {
////			if (emp != null) {
////				emp.setLocation(employee.getLocation());
////				emp.setDesignation(employee.getDesignation());
////				emp.setName(employee.getName());
////				emp.setPhonenumber(employee.getPhonenumber());
////				h2Repository.save(emp).subscribe();
////				return Mono.just("Saved Successfully");
////			}
////			return Mono.just("No employee exist");
////		});
////	}
////
////	public Mono<String> delete(int id) {
////		// TODO Auto-generated method stub
////		return h2Repository.findById(id).flatMap(emp -> {
////			if (emp != null) {
////				h2Repository.deleteById(id).subscribe();
////				return Mono.just("Deleted Successfully");
////			}
////			return Mono.just("No employee exist");
////		});
////
////	}
//
//}
