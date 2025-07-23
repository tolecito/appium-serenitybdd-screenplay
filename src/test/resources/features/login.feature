Feature: Inicio de sesión en la app móvil

  Scenario: Login exitoso
    Given que el usuario abre la app
    When el usuario se loguea con "standard_user" y "secret_sauce"
    Then debería ver el mensaje "PRODUCTS"
