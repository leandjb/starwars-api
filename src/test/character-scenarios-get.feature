@Characters
Feature: GET Request for Star Wars API

  Scenario: As a user, i can retrieve a character on GET request
    Given have a valid Star Wars Character
    When send a GET request to https://swapi.dev/api/ URI with ID 11
    Then result should be status code 200