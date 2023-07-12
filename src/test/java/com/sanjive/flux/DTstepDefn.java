package com.sanjive.flux;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.sanjive.flux.h2.Employee;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import reactor.core.publisher.Mono;

public class DTstepDefn {

	@Autowired
	private WebTestClient webTestClient;

	private Employee addedEmployee;
	private String updateResult;
	private String deleteResult;
	private List<Employee> employees;
	private Employee employee;
	private String URL;
	private String response;

	@Given("^user wants to create an employee in (h2|mysql) with the following attributes$")
	public void haveBooksInTheStoreByMap(final String DB, DataTable table) {
		URL = DB;
		List<Map<String, String>> rows = table.asMaps(String.class, String.class);

		for (Map<String, String> columns : rows) {
//	        System.out.println(columns.get("name")+" "+columns.get("location"));
			employee = new Employee(columns.get("name"), columns.get("phoneNumber"), columns.get("location"),
					columns.get("designation"));
		}
		
	}

	@When("^user calls (GET|PUT|POST|DELETE) on (\\w+) method (\\w+)$")
	public void specific_endpoint(final String method, final String api, final String testCase) {

		URL = "/" + URL + "/" + api;
		System.out.println(URL);
		System.out.println(testCase);
		if (method.equals("GET")) {
			employees = webTestClient.get().uri(URL).exchange().expectStatus().isOk().expectBodyList(Employee.class)
					.returnResult().getResponseBody();
		} else if (method.equals("POST")) {
			response = webTestClient.post().uri(URL).body(Mono.just(employee), Employee.class).exchange().expectStatus()
					.isOk().expectBody(String.class).returnResult().getResponseBody();
		} else if (method.equals("PUT")) {
			Employee employee = new Employee(51, "test123", "test123", "test123", "test123");
			updateResult = webTestClient.put().uri(URL).body(Mono.just(employee), Employee.class).exchange()
					.expectStatus().isOk().expectBody(String.class).returnResult().getResponseBody();
		}
	}

	@Then("^the method called (\\w+) should (\\w+)$")
	public void test_then(final String testCase, final String result) {
		if (testCase.contains("WITHOUT")) {
			assertEquals("FAIL", result);
			assertTrue(response.contains("missing"));
		} else {
			assertEquals("PASS", result);
			assertEquals("Saved Successfully", response);
		}
	}
}
