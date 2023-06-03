Feature: Request examples using Star Wars API

  Scenario: Character GET test
    Given send a GET request to https://swapi.dev/api/people/1/
    Then obtain 200 status code