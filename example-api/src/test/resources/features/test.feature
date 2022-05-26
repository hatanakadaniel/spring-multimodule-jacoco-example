Feature: Feature Um

  Scenario: cenario 1 da feature Um
    Given uma request para feature um com parametros
      | param1 | xpto |
      | param2 | 9.99 |
    When chamar um "GET" para "/"
    Then deve retornar 200
    And a resposta deve ser
      | param1 | param2 | param3 |
      | xpto   | 9      | param3 |