package com.sanjive.flux;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.client.RestTemplate;

import com.sanjive.flux.h2.Employee;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import reactor.core.publisher.Mono;

public class StepDefinitions {

	@LocalServerPort
	private int port;
	
	@Autowired
	private WebTestClient webTestClient;

	private Employee addedEmployee;
	private String updateResult;
	private String deleteResult;
	private List<Employee> employees;
	private String URL;
	private String response;

	@Given("user sets URL")
	public void set_endpoint_to_be_called() {

		URL = "http://localhost:" + port + "/h2/mono";
		System.out.println(URL);
	}
	
	@When("^user calls end point with (\\w+)$")
	public void endpoint(final String body) {
		
		response = webTestClient.post().uri(URL).body(Mono.just(body), String.class).exchange().expectStatus().isOk().expectBody(String.class).returnResult()
				.getResponseBody();
	}
	
	@Then("^user receives HTTP response code 200 and (\\w+)$")
	public void check_200_output(final String string) {
		
		assertEquals(string, response);
		
	}
	
	@Given("^user set (\\w+) end point$")
	public void set_DBendpoint_to_be_called(final String DB) {
		
		URL = DB;
		System.out.println(URL);
		
	}

	@When("^user calls (GET|PUT|POST|DELETE) on (\\w+) method$")
	public void specific_endpoint_old(final String method, final String api) {
		
		URL = "/" + URL + "/" + api;
		System.out.println(URL);
		
		if (method.equals("GET")) {
			employees = webTestClient.get()
					.uri(URL).exchange().expectStatus().isOk().expectBodyList(Employee.class)
					.returnResult().getResponseBody();
		} 
		else if (method.equals("POST")) {
			Employee employee = new Employee("test1", "test", "test", "test");
			addedEmployee = webTestClient.post()
					.uri(URL).header("Content-Type", "application/json; charset=UTF-8").body(Mono.just(employee), Employee.class).exchange()
					.expectStatus().isOk().expectBody(Employee.class).returnResult().getResponseBody();
		} 
		else if (method.equals("PUT")) {
			Employee employee = new Employee(51, "test123", "test123", "test123", "test123");
			updateResult = webTestClient.put()
					.uri(URL).body(Mono.just(employee), Employee.class).exchange()
					.expectStatus().isOk().expectBody(String.class).returnResult().getResponseBody();
		} 
		else if (method.equals("DELETE")) {
			deleteResult = webTestClient.delete()
					.uri(URL).exchange().expectStatus().isOk().expectBody(String.class)
					.returnResult().getResponseBody();
		}
		
	}
	
	@Then("the employee should be added successfully")
	public void employeeShouldBeAddedSuccessfully() {
		
		Employee employee = addedEmployee;
		System.out.println(employee.getDesignation());
		
		assertEquals("test", employee.getLocation());
		
	}

	@Then("the employee should be updated successfully")
	public void employeeShouldBeUpdatedSuccessfully() {
		
		String result = updateResult;
		
		assertEquals(null, result);
		
	}

	@Then("the employee list should contain {int} employees")
	public void employeeListShouldContain(int expectedCount) {
		
		List<Employee> employeeList = employees;
		System.out.println(employeeList);
		
		assertEquals(expectedCount, employeeList.size());
		
	}

	@Then("the employee should be deleted successfully")
	public void employeeShouldBeDeletedSuccessfully() {
		
		String result = deleteResult;
		
		assertEquals("Deleted Successfully", result);
		
	}

}
