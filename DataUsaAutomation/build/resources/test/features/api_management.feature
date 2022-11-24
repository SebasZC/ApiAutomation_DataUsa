#Author: zapatasebastian001@gmail.com

  Feature: I as a user I want to consume the service

    @ConsultYear
    Scenario: consult year
      When the user consult the information by 2019
      Then the user should watch 324697795

      @GeneralConsult
      Scenario: general consult
        When the user consult the information by 2015
        Then the user going to watch the correct information