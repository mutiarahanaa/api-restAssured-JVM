Feature: API Test

  @try
  Scenario: Trial api
    Given user access url "/api/users"
    When user grab url with id 5
    And verify the JSON response should have "data.email" with "charles.morris@reqres.in"
    And verify the JSON response should have "data.first_name" with "Charles"
    And verify status code is 200