# bcnc-technical-test
Technical test for BCNC

## Aplicación Springboot con arquitectura hexagonal

### Capas Principales:
#### Application (Servicios):
Ubicación: /src/main/java/com/bcnc/test/bcnctest/service
Esto correspondería al paquete service, donde definiríamos la implementacion de las reglas principales de negocio y los puertos de entrada y salida

#### Domain (Dominio):
Ubicación: /src/main/java/com/bcnc/test/bcnctest/domain
En esta capa se encuentran los objetos de dominio

#### Infrastructure (Infraestructura):
Ubicación: /src/main/java/com/bcnc/test/bcnctest/data y /src/main/java/com/bcnc/test/bcnctest/rest
Esta capa contiene la implementación de los detalles técnicos de la aplicación como la persistencia de datos y la comunicación con sistemas externos



## TECNOLOGÍAS UTILIZADAS

#### Spring Boot:
Framework de desarrollo de aplicaciones Java que facilita la creación de aplicaciones independientes y listas para producción con un mínimo de configuración.
#### H2 Database:
Base de datos embebida escrita en Java que se utiliza para el desarrollo, pruebas y prototipos. Es ligera y rápida de configurar.
#### Flyway:
Herramienta de migración de bases de datos que permite gestionar y versionar los cambios en la estructura de la base de datos de manera controlada y automática.
#### Hibernate:
Framework de mapeo objeto-relacional (ORM) que simplifica el acceso y la manipulación de datos almacenados en una base de datos relacional a través de objetos Java.
#### Spring Data JPA
Parte del framework Spring Data que simplifica la implementación de repositorios de datos basados en JPA (Java Persistence API). Proporciona un conjunto de abstracciones y funcionalidades para interactuar con la capa de persistencia de manera más sencilla.
#### Lombok:
Biblioteca que reduce la verbosidad del código en Java mediante la generación automática de métodos como constructores, getters y setters, lo que facilita la escritura y lectura del código.
#### OpenAPI Generator:
Herramienta que genera automáticamente código cliente y servidor a partir de una especificación OpenAPI (anteriormente conocida como Swagger). Facilita la creación de API RESTful y la generación de clientes para consumirlas.
#### MapStruct:
Framework que simplifica la implementación de mapeos entre objetos Java mediante la generación automática de código. Ayuda a evitar errores comunes y reduce la necesidad de escribir código boilerplate.
#### JaCoCo:
Herramienta de análisis de cobertura de código para Java que proporciona métricas detalladas sobre la cantidad de código que se ha ejecutado durante las pruebas unitarias, ayudando a identificar áreas no probadas y a mejorar la calidad del código.


## Ejecutar la aplicación con Maven
#### 1 - Compilar y empaquetar el proyecto:

	mvn clean install -U

#### 2 - Ejecutar la aplicación:

	java -jar target/bcnctest-0.1.3.jar

## Crear y ejecutar un contenedor Docker:
#### Construir la imagen Docker:
Ejecutaremos 

docker build -t bcnctest:tag . 

donde el tag será la versión que queramos especificar para nuestra imagen. En este ejemplo usaremos 0.1.3:

	docker build -t bcnctest:0.1.3 .
	
#### Ejecutar el contenedor Docker:
Tras crear correctamente la imagen la ejecutaremos con:

docker run -p 8080:8080 bcnctest:tag

recordando indicar el tag que hubiesemos especificado. En este caso:

	docker run -p 8080:8080 bcnctest:0.1.3


## Postman
He incluido una colección de Postman para poder probar los 5 tests propuestos en el ejercicio, más uno extra comprobando una excepcion 404 cuando no se encuentran precios.

Se encuentra en:

	/postman/BCNC technical test.postman_collection.json
