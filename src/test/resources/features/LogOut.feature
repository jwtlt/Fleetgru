@LogOut
Feature: User Story : As a user, I should be able to log out

  Acceptance Criteria:

  1-The user can log out and ends up on the login page.

  2-The user can not go to the home page again by clicking the step back button after successfully logging out.

  3-The user must be logged out if the user close the open tab (all tabs if there are multiple open tabs)

  Background: Users are expected to be on the homepage
    Given User is on the login page

  @FLT-1789 @smoke
  Scenario Outline: The user can log out and ends up on the login page.
    Given user login as "<userType>"
    When user click the log out button
    Then User is on the login page

    Examples: Needed credentials.

      | userType      |
      | Driver        |
      | Sales Manager |
      | Store Manager |

  @FLT-1790
  Scenario Outline: The user can not go to the home page again by clicking the step back button after successfully logging out.
    Given user login as "<userType>"
    When user click the log out button
    And user click the step back button after logging out
    Then user should not be on the homepage

    Examples: Needed credentials.

      | userType      |
      | Driver        |
      | Sales Manager |
      | Store Manager |

  @FLT-1791
  Scenario Outline: The user must be logged out if the user close the open tab (all tabs if there are multiple open tabs)
    Given user login as "<userType>"
    When user close all open tabs
    Then user logged out

    Examples: Needed credentials.

      | userType      |
      | Driver        |
      | Sales Manager |
      | Store Manager |