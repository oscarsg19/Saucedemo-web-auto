# Proyecto de Automatización: Saucedemo 

# <span style="color:#AB83E1"> **📌 Guia ejercicio** 
<br>
<span style="color:#91E1B9"> 1. El framework está construido utilizando el patrón Screenplay, lo que permite una alta escalabilidad, mantenibilidad y legibilidad de las pruebas. <br>
<br>

<span style="color:#91E1B9"> 2. En el archivo Serenity.conf contiene la configuración de Serenity BDD, parámetros de ejecución e integración con WebDriver
   <span style="color:#6273E0"> src\test\resources\serenity.conf


## Descripción del Proyecto  
Este proyecto tiene como objetivo automatizar pruebas funcionales para la página web **https://www.saucedemo.com/**. Las pruebas están diseñadas para validar la correcta operación de los flujos principales de la aplicación web, garantizando la calidad y el correcto funcionamiento del sitio.  

La automatización se ha implementado utilizando las siguientes tecnologías y enfoques:  

- **Serenity BDD** para la generación de reportes detallados y manejo del patrón **Screenplay**.  
- **Screenplay** para una escritura modular y mantenible de los casos de prueba.  
- **Gradle** como herramienta de gestión de dependencias y construcción del proyecto.  
- **Cucumber** como lenguaje de soporte **Gherkin**.  
- **Java** como lenguaje de programación principal.  
- **Selenium WebDriver** para la interacción con la interfaz de usuario.  
- **CI/CD** GitHub / Jenkins

## Requisitos Previos  
- **Instalación de Java**: Asegúrate de tener instalada la versión 11 o superior de Java.  
- **Gradle**: Instalar Gradle en tu sistema o usar el wrapper incluido en el proyecto.  
- **Navegadores y WebDrivers**:  
  - Google Chrome, Mozilla Firefox, Edge o Safari (macOS).  
  - WebDriver compatible con el navegador que desees usar.  
- **Configuraciones Adicionales**: Configurar correctamente el archivo `serenity.conf` para indicar las URL del entorno, credenciales y configuración del navegador.  

## Estructura del Proyecto  
```
project-root/
|-- src/
|   |-- main/
|   |   |-- java/
|   |       |-- com.demoqa.testqa/
|   |           |-- interactions/
|   |           |-- models/
|   |           |-- questions/
|   |           |-- tasks/
|   |           |-- userinterfaces/
|   |           |-- utils/
|   |-- test/
|       |-- java/
|           |-- com.demoqa.testqa/
|               |-- runners/
|               |-- stepdefinitions/
|       |-- resources/
|           |-- features/
|-- build.gradle
|-- serenity.conf
|-- README.md
```

## Directorios Principales  
- **tasks/**: Contiene las clases que representan tareas realizadas por los actores.  
- **interactions/**: Incluye interacciones personalizadas con la UI o acciones específicas.  
- **questions/**: Define preguntas para validar estados o información del sistema.  
- **ui/**: Ubicación de las clases que encapsulan localizadores de elementos.  
- **runners/**: Clases que configuran y ejecutan los tests con JUnit.  
- **stepdefinitions/**: Implementación de los pasos definidos en los escenarios de prueba.  
- **features/**: Contiene los archivos `.feature` escritos en Gherkin.  

## Configuración del Proyecto  

### build.gradle  
Ejemplo de configuración:  
```gradle
plugins {
    id 'java'
    id "net.serenity-bdd.serenity-gradle-plugin" version "4.0.30"
}

group 'org.example'
version '1.0-SNAPSHOT'

repositories {
    mavenCentral()
}

compileJava.options.encoding = "UTF-8"
compileTestJava.options.encoding = "UTF-8"

dependencies {
    testImplementation 'org.slf4j:slf4j-simple:2.0.9'
    testImplementation group: 'junit', name: 'junit', version: '4.13.2'
    implementation(group: 'net.serenity-bdd', name: 'serenity-core', version: '4.1.17') {
        exclude group: 'org.seleniumhq.selenium', module: 'selenium-devtools'
    }
    implementation group: 'net.serenity-bdd', name: 'serenity-junit', version: '4.1.17'
    implementation group: 'net.serenity-bdd', name: 'serenity-screenplay', version: '4.1.17'
    implementation group: 'net.serenity-bdd', name: 'serenity-cucumber', version: '4.1.17'
    implementation group: 'net.serenity-bdd', name: 'serenity-screenplay-rest', version: '4.1.17'
    implementation group: 'org.seleniumhq.selenium', name: 'selenium-devtools-v129', version: '4.25.0'
    implementation 'org.projectlombok:lombok:1.18.24'

    compileOnly 'org.projectlombok:lombok:1.18.8'
    annotationProcessor 'org.projectlombok:lombok:1.18.8'

    implementation group: 'com.github.javafaker', name: 'javafaker', version: '1.0.2'
    implementation group: 'com.devskiller', name: 'jfairy', version: '0.6.5'
}

test.finalizedBy(aggregate)
```

### serenity.conf  
Ejemplo de configuración básica:  
```json
 Configuración general de Serenity
serenity {

  # Nombre del proyecto, aparecerá en los reportes
project.name = "Prueba Saucedemo"

# Tomar capturas de pantalla solo en fallos
# Esto mantiene los reportes limpios y reduce consumo de espacio
take.screenshots = FOR_FAILURES

# Nivel de detalle de logs
# VERBOSE muestra información completa para depuración
logging = VERBOSE
}

# Configuración del WebDriver
webdriver {

# Navegador a usar en las pruebas
driver = chrome
}

# Opciones específicas para Chrome
chrome {

# Flags que modifican el comportamiento del navegador para automatización
switches = [
"--start-maximized",                # Abrir el navegador maximizado
"--disable-notifications",          # Bloquear notificaciones de sitios
"--disable-popup-blocking",         # Permitir pop-ups si son necesarios en tests
"--disable-extensions",             # Desactivar extensiones que puedan interferir
"--disable-infobars",               # Ocultar barras de información
"--disable-save-password-bubble",   # Evitar que Chrome ofrezca guardar contraseñas

# Deshabilitar características de seguridad/gestión de contraseñas
"--disable-features=PasswordManagerEnabled",
"--disable-features=PasswordLeakDetection",
"--disable-features=PasswordManagerOnboarding",
"--disable-features=PasswordCheck",
"--disable-features=SafetyCheck",
"--disable-features=SecurityInterstitials"
]

# Preferencias de usuario para Chrome
# Se usan para evitar interferencias en la automatización
preferences {
"credentials_enable_service" = false                # Desactivar servicio de credenciales
"profile.password_manager_enabled" = false          # Desactivar gestor de contraseñas
"profile.credentials_enable_service" = false        # Redundante, refuerza la desactivación
"password_manager_enabled" = false                  # Desactivar gestor de contraseñas
"profile.password_manager_leak_detection" = false   # Desactivar alertas de contraseñas filtradas
"autofill.profile_enabled" = false                  # Desactivar autocompletado de perfiles
"autofill.credit_card_enabled" = false              # Desactivar autocompletado de tarjetas
"autofill.enabled" = false                           # Desactivar autocompletado general
"profile.default_content_setting_values.cookies" = 2 # Bloquear cookies de terceros
}
}
```

## Ejecución de las Pruebas  

Ejecutar pruebas específicas:  
```sh
gradle clean test -Dcucumber.options="--tags @tagDeseado"
```

Generar reporte de Serenity:  
```sh
gradle aggregate
```

Abrir el reporte: El reporte estará disponible en `target/site/serenity/index.html`.  

## IMPORTANTE  
Es posible ejecutar la automatización en cualquier navegador, incluso si se requiere que sea responsive:  

Para ello, en el **runner** debe agregar la siguiente línea de código y modificar según lo requerido:  
```sh
:test --tests "co.com.saucedemo.runners.nuevacuenta.NuevaCuentaAhorrosRunner"
```

---

### **Autor**: Oscar Fernando Sanchez Gamez  
### **Versión**: 1.0  
### **Fecha**: [20/03/2026]  
