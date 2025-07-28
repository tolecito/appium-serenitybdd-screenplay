Feature: Inicio de sesión en la app móvil

  Scenario Outline: Login exitoso
    Given que el usuario abre la app
    When el usuario se loguea con las credenciales "<username>" y "<password>"
    Then deberia ver el mensaje "PRODUCTS"

    Examples:
    | username                                | password     |
    | standard_user                           | secret_sauce |
    | problem_user                            | secret_sauce |


  Scenario Outline: Login fallido por usuario bloqueado
    Given que el usuario abre la app
    When el usuario se loguea con las credenciales "<username>" y "<password>"
    Then deberia ver el mensaje de error "Sorry, this user has been locked out." por usuario bloqueado

    Examples:
      | username                                | password     |
      | locked_out_user                         | secret_sauce |


  Scenario Outline: Login fallido por credenciales incorrectas
    Given que el usuario abre la app
    When el usuario se loguea con las credenciales "<username>" y "<password>"
    Then deberia ver el mensaje de error "Username and password do not match any user in this service." por credenciales incorrectas

    Examples:
      | username                                | password     |
      | performance_glitch_user                 | secret_sauce |
