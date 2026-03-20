@FinalizaCompra
Feature: Inicio de sesion pagina parabank
  Yo como usuario
  quiero poder agregar productos al carrito
  para poder realizar mis compras

  Background:
    Given el usuario ingresa la url de saucedemo

  @FinalizaCompra-001
  Scenario Outline: Validar cliente pueda realizar una compra exitosa
    When El cliente ingresa con credenciales
      | username   | password   |
      | <username> | <password> |
    And intenta iniciar la sesion
    And el cliente agrega al carrito desde listado de productos <cantidad>
    And el cliente va al carrito de compras
    And el cliente realiza el Checkout
      | firstname   | lastname   | postalcode |
      | <firstname> | <lastname> | <postalcode> |
    And el cliente finaliza la compra
    Then el cliente vera en pantalla que su compra fue realizada con exito <mensaje>
    Examples:
      | username       | password      | cantidad | firstname | lastname | postalcode | mensaje                    |
      | standard_user  | secret_sauce  | 3        | Oscar     | Sanchez  | 1095050    | Thank you for your order!  |