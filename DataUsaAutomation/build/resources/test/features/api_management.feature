#Author: zapatasebastian001@gmail.com

Feature: I as a user I want to consume the service

  @ConsultYear
  Scenario: consult year
    When the user consult the information by 2019
    Then the user should watch 324697795
    Then should display the response with code 200

  @GeneralConsult
  Scenario: general consult
    When the user consult the information by 2015
    Then the user going to watch the correct information

  @ConsultByIdYear
  Scenario Outline: consult by id year
    When the user consult the information by <year>
    Then display field data.Year and value <year> in service response

    Examples:
      | year |
      | 2015 |
      | 2016 |
      | 2017 |
      | 2018 |

  @ConsultPopulation
  Scenario: consult population
    When the user consult the population 316515021
    Then display field data.Nation and value United States in service response
    Then should display the response with code 200

  @CreateRegister
  Scenario: can't create register
    When the user send the information
      | 1058C    |
      | Colombia |
      | 2021     |
      | 2021     |
      | 54000000 |
      | Colombia |
    Then should display the response with code 404