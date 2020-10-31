@login
 Feature: As user I want to be able to login under different roles

   Background:
     Given user is on the login page

  Scenario: Login as a sales manager
   When user logs in
   Then user should see dashboard page

    @parametrized_test
  Scenario: Parametrized login
   When user logs in as a "store manager"
   Then user should see dashboard page

      @negative_login
  Scenario: Invalid password
    When user logs in with "storemanager85" username and "wrong" password
    Then user verifies that "Invalid user name or password." message is displayed