@AgregarAlCarrito
Feature: Inicio de sesion pagina parabank
  Yo como usuario
  quiero poder agregar productos al carrito
  para poder agregar productos al carrito de compras

  Background:
    Given el usuario ingresa la url de saucedemo

  @AgregarAlCarrito-001
  Scenario Outline: Validar cliente agrega al carrito desde listado de productos
    When El cliente ingresa con credenciales
      | username   | password   |
      | <username> | <password> |
    And intenta iniciar la sesion
    And el cliente agrega al carrito desde listado de productos <cantidad>
    Then el cliente vera en el carrito el numero de productos agregados <cantidad>
    Examples:
      | username       | password      | cantidad |
      | standard_user  | secret_sauce  | 3        |

  @AgregarAlCarrito-002
  Scenario Outline: Validar cliente agrega al carrito desde detalle de producto
    When El cliente ingresa con credenciales
      | username   | password   |
      | <username> | <password> |
    And intenta iniciar la sesion
    And el cliente agrega al carrito desde el detalle del producto
    Then el cliente vera en el carrito el numero de productos agregados <cantidad>
    Examples:
      | username       | password      | cantidad |
      | standard_user  | secret_sauce  | 1        |

  @AgregarAlCarrito-003
  Scenario Outline: Validar cliente elimina productos al carrito desde detalle de producto
    When El cliente ingresa con credenciales
      | username   | password   |
      | <username> | <password> |
    And intenta iniciar la sesion
    And el cliente agrega al carrito desde el detalle del producto
    And el cliente va al carrito de compras
    And el cliente borra el producto del carrito
    Then el cliente no vera el producto en el carrito
    Examples:
      | username       | password      |
      | standard_user  | secret_sauce  |

