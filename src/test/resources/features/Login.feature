@Login
Feature: User Story : As a user, I should be able to log in

  Acceptance Criteria:

  1-All users can log in with valid credentials (We have 3 types of users such as sales manager, store manager, truck driver).
  - Driver should land on the "Quick Launchpad" page after successful login
  - Sales Manager/ Store Manager should land on the "Dashboard" page after successful login

  2-"Invalid username or password." should be displayed for invalid (valid username-invalid password and invalid username-valid password) credentials

  3- "Please fill out this field" message should be displayed if the password or username is empty

  4-User land on the ‘Forgot Password’ page after clicking on the "Forgot your password?" link

  5-User can see "Remember Me" link exists and is clickable on the login page

  6-User should see the password in bullet signs by default

  7- Verify if the ‘Enter’ key of the keyboard is working correctly on the login page.

  8- All users can see their own usernames in the profile menu, after successful login

  Background: Users are expected to be on the login page
    Given User is on the login page

  @FLT-1778 @smoke
  Scenario Outline: Users login as "<userType>"
    When user login as "<userType>"
    Then user land on "<expectedPage>"

    Examples: Needed credentials.

      | userType      | expectedPage    |
      | Driver        | Quick Launchpad |
      | Sales Manager | Dashboard       |
      | Store Manager | Dashboard       |

  @FLT-1779
  Scenario Outline: Users enter invalid credentials
    When user enter "<invalid username>" or "<invalid password>"
    Then user should see "<message>"

    Examples: Needed credentials
      | invalid username | invalid password | message                       |
      | StoreManAger51   | UserUser123      | Invalid username or password. |
      | salesmanager101  | Useruser123      | Invalid username or password. |
      | user1            | userUser123      | Invalid username or password. |
      | SaLesManaGer101  | UserUser123      | Invalid username or password. |

  @FLT-1780
  Scenario Outline: Users enter empty credentials
    When User enter "<empty username>" or "<empty password>"
    Then User should see the "<message>" for "<empty username>" or "<empty password>"

    Examples: Needed credentials
      | empty username | empty password | message                     |
      |                | UserUser123    | Please fill out this field. |
      |                | 654651621      | Please fill out this field. |
      | User1          |                | Please fill out this field. |

  @FLT-1781
  Scenario: Users click the "Forgot your password?" link
    When User click the Forgot your password? link
    Then User land on the ‘Forgot Password’ page

  @FLT-1782
  Scenario: Users see "Remember Me" link exists and is clickable on the login page
    When User see "Remember me on this computer" link
    And User click the link
    Then User see the linkBox is marked

  @FLT-1783
  Scenario: User should see the password in bullet signs by default
    When User enter password "UserUser123"
    Then User see the password in bullet signs

  @FLT-1784
  Scenario: Verify if the ‘Enter’ key of the keyboard is working correctly on the login page.
    When User enter valid credentials
      | username | User1       |
      | password | UserUser123 |
    And User hit the "Enter" key of the keyboard
    Then User land on the Quick Launchpad page

  @FLT-1785
  Scenario Outline: Users login as "<userType>"
    When user login as "<userType>"
    Then user see their "<expectedName>" in the profile menu

    Examples: Needed credentials.
      | userType      | expectedName |
      | Driver        | John Doe     |
      | Sales Manager | John Doe     |
      | Store Manager | John Doe     |
