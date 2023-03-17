### Proyecto Magento(LUMA)  usando Serenity BDD

#### Tecnologías utilizadas
+ Java 8
+ Serenity BDD
+ Selenium WebDriver
+ Cucumber
+ Gradle

#### Requisitos previos
+ Java 8 o superior instalado en su máquina
+ Gradle 4.8 o superior

#### Ejecución del proyecto
+ Clona el repositorio en tu máquina local.
+ Abre una terminal y navega hasta el directorio raíz del proyecto.
+ Ejecuta el comando gradle clean test para compilar y ejecutar las pruebas.
+ Espera a que finalice la ejecución de las pruebas y verás los resultados en la consola.

#### Estructura del proyecto
* src/test/java: contiene los archivos de código fuente de las pruebas automatizadas.
+ src/test/resources: contiene los archivos de configuración y recursos utilizados en las pruebas automatizadas, como archivos de datos y archivos de propiedades.
+ src/main/java: contiene los archivos de código fuente de la aplicación a probar.
+ build.gradle: contiene la configuración de Gradle para compilar y ejecutar las pruebas.

#### Informes de prueba
Después de ejecutar las pruebas, se generará un informe HTML detallado en el directorio target/site/serenity/index.html. Este informe incluye información sobre las pruebas ejecutadas, las estadísticas de ejecución y los resultados detallados para cada escenario de prueba.
