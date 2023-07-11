Feature: the version can be retrieved
  Scenario: making call to GET 
    Given user sets URL
	  When user calls end point 
	  Then user receives HTTP response code 200 and String
	
  Scenario: creating employee
    Given user set h2 end point
    When user calls POST on AddEmployee method 
    Then the employee should be added successfully
    
  Scenario: getting all employees
    Given user set h2 end point
    When user calls GET on GetEmployee method 
    Then the employee list should contain 1 employees
    
  Scenario: updating an employee
    Given user set h2 end point
    When user calls PUT on UpdateEmployee method 
    Then the employee should be updated successfully
    
  Scenario: deleting an employee
    Given user set h2 end point
    When user calls DELETE on DeleteAll method 
    Then the employee should be deleted successfully