Feature: Seleccion de productos en la app móvil

  Background:
    Given el usuario inicia sesion con las credenciales "standard_user" y "secret_sauce"

  @SeleccionarProductos
  Scenario Outline: Seleccionar un producto y verificar su precio
    When navega hacia el producto "<NombreProducto>" y se da click en el
    Then deberia ver el nombre del producto "<NombreProducto>"
    And deberia ver que el precio del producto es "<Precio>"

    Examples:
        | NombreProducto            | Precio |
        #| Sauce Labs Backpack       | $29.99 |
        #| Sauce Labs Bike Light     | $9.99  |
        #| Sauce Labs Bolt T-Shirt   | $15.99 |
        | Sauce Labs Fleece Jacket  | $49.99 |
        | Sauce Labs Onesie         | $7.99  |