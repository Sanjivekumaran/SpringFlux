#@tag2
#  Scenario Outline: Title of your scenario outline
#    Given I want to write a step with <name>
#    When I check for the <value> in step
#    Then I verify the <status> in step
#
#   Examples: 
#      | name  | value | status  |
#      | name1 |     5 | success |
#      | name2 |     7 | Fail    |

Feature: testing for mysql database CRUD operations
	
  Scenario: creating employee
    Given user set mysql end point
    When user calls POST on AddEmployee method 
    Then the employee should be added successfully
    
  Scenario: getting all employees
    Given user set mysql end point
    When user calls GET on GetEmployee method 
    Then the employee list should contain 1 employees
    
  Scenario: updating an employee
    Given user set mysql end point
    When user calls PUT on UpdateEmployee method 
    Then the employee should be updated successfully
    
  Scenario: deleting an employee
    Given user set mysql end point
    When user calls DELETE on DeleteAll method 
    Then the employee should be deleted successfully
    
  Scenario: non existing end point
    Given user set mysql end point
    When user calls nonExisting method 
    Then should return error response
