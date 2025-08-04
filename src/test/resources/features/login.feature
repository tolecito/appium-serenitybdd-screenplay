Feature: Inicio de sesión en la app móvil

  Background:
    Given que el usuario abre la app

  Scenario Outline: Inicio de sesión exitoso
    When el usuario inicia sesion con las credenciales "<username>" y "<password>"
    Then deberia ver el mensaje "PRODUCTS"

    Examples:
    | username                                | password     |
    | standard_user                           | secret_sauce |
    | problem_user                            | secret_sauce |


  Scenario Outline: Inicio de sesión fallido por usuario bloqueado
    When el usuario inicia sesion con las credenciales "<username>" y "<password>"
    Then deberia ver el mensaje de error "Sorry, this user has been locked out." por usuario bloqueado

    Examples:
      | username                                | password     |
      | locked_out_user                         | secret_sauce |


  Scenario Outline: Inicio de sesión fallido por credenciales incorrectas
    When el usuario inicia sesion con las credenciales "<username>" y "<password>"
    Then deberia ver el mensaje de error "Username and password do not match any user in this service." por credenciales incorrectas

    Examples:
      | username                                | password     |
      | performance_glitch_user                 | secret_sauce |
