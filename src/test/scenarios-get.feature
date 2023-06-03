@SWAPI
Feature: GET Request for Star Wars API

  Scenario: As a user, i can retrieve a character on GET request
    Given have a valid Star Wars Character
    When send a GET request to https://swapi.dev/api/ URI
    Then result should be status code 200

  Scenario: As a user, i can not retrieve a character on GET request
    Given have an invalid Star Wars Character
    When send a GET request to https://swapi.dev/api/ URI
    Then result should be status code 404

