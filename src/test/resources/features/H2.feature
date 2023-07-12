Feature: the version can be retrieved
  Scenario: making call to GET 
    Given user sets URL
	  When user calls end point with <value>
	  Then user receives HTTP response code 200 and <value>
	  
	Examples:
		| value |
		| hello | 
    
  Scenario: <testCase> <expectedResult>
    Given user wants to create an employee in h2 with the following attributes
      | name   | location   | designation   | phoneNumber   |
      | <name> | <location> | <designation> | <phoneNumber> |      
    When user calls POST on AddEmployee method <testCase>
    Then the method called <testCase> should <expectedResult>
    
    Examples:
      | testCase                 | expectedResult | location  | name     | designation | phoneNumber  | 
      | WITHOUT_NAME       			 | FAIL           | Test      |          | Test        | 123456789    | 
      | WITHOUT_LOCATION     		 | FAIL           |           | Test     | Test        | 123456789    |
      | WITHOUT_DESIGNATION      | FAIL           | Test      | Test     |             | 123456789    |
      | WITHOUT_PHONENUMBER      | FAIL           | Test      | Test     | Test        |              |
      | WITH_ALL_REQUIRED_FIELDS | PASS           | Test      | Test     | Test        | 123456789    |
