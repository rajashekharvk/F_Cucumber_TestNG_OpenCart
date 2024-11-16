Feature: Login Data Driven with Excel

  Scenario Outline: Login Data Driven Excel
 #This step called from the LoginSteps.java as we already implemented this step. Duplicate steps we cannot create methods
    Given the user navigates to login page 
    Then the user should be redirected to the MyAccount Page by passing email and password with excel row "<row_index>"

    Examples: 
      | row_index |
      |         1 |
      |					2	|
      |					3	|
      |					4	|
      |					5	|