@IniciarSesion
  Feature: Inicio de sesion pagina parabank
    Yo como usuario
    quiero realizar el inicio de sesion
    para poder usar la pagina saucedemo

  Background:
    Given el usuario ingresa la url de saucedemo

  @IniciarSesion-001
  Scenario Outline: Validar usuario ingresa con credenciales exitoso
    When El cliente ingresa con credenciales
      | username   | password   |
      | <username> | <password> |
    And intenta iniciar la sesion
    Then el cliente vera en la pantalla el listado de productos <mensaje>
    Examples:
      | username      | password     | mensaje    |
      | standard_user | secret_sauce | Products   |

    @IniciarSesion-002
    Scenario Outline: Validar usuario ingresa con usuario inexistente
      When El cliente ingresa con credenciales
        | username   | password   |
        | <username> | <password> |
      And intenta iniciar la sesion
      Then el cliente vera en la pantalla el mensaje de error inicio de sesion fallido <mensaje>
      Examples:
        | username    | password       | mensaje                                                                     |
        | prueba      | secret_sauce   | Epic sadface: Username and password do not match any user in this service   |

    @IniciarSesion-003
    Scenario Outline: Validar usuario ingresa con contraseña incorrecta
      When El cliente ingresa con credenciales
        | username   | password   |
        | <username> | <password> |
      And intenta iniciar la sesion
      Then el cliente vera en la pantalla el mensaje de error inicio de sesion fallido <mensaje>
      Examples:
        | username      | password     | mensaje                                                                        |
        | standard_user    | prue123456   | Epic sadface: Username and password do not match any user in this service   |


    @IniciarSesion-004
    Scenario Outline: Validar usuario realiza cierre de sesion
      When El cliente ingresa con credenciales
        | username   | password   |
        | <username> | <password> |
      And intenta iniciar la sesion
      And el usuario cierra la sesion
      Then el cliente vera la pantalla de inicio de sesion
      Examples:
        | username      | password     |
        | standard_user | secret_sauce |