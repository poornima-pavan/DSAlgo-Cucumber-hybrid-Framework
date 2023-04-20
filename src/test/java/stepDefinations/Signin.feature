@tag
Feature: Sign in
This feature allows user to sign in to DSalgo portal.

  Scenario Outline: : user enter valid and invalid username and password from Excel giving "<Sheetname>" and <Rownumber>.
    Given user is on sign in page.
    When user enters "<Sheetname>" and <Rownumber>
    Then user clicks on "<Login>" button.

    Examples: 
      | Sheetname | Rownumber |
      | Sheet1    |         0 |
      | Sheet1    |         1 |
      | Sheet1    |         2 |

  Scenario: user clicks on "<Register>" link, should land in register page
    Given user is on sign in page.
    When user clicks on "<Register>" link.
    Then user should land in register page.
