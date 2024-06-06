# Travel Agency Reserva Application

Este es un proyecto de ejemplo de una aplicación de agencia de viajes para gestionar reservas. La aplicación está construida usando Spring Boot y proporciona una API REST para insertar reservas y listar reservas por nombre de hotel.

## Tabla de Contenidos

- [Instalacion](#instalacion)
- [Uso](#uso)
- [Estructura del Proyecto](#estructura-del-proyecto)
- [Ejecutando Pruebas](#ejecutando-pruebas)
- [Tecnologias Utilizadas](#tecnologias-utilizadas)
- [Autores](#autores)
- [Licencia](#licencia)

## Instalacion

Para instalar y ejecutar este proyecto localmente, sigue estos pasos:

1.Clona el repositorio:
   
    ``` 
    git clone https://github.com/Shaekhrom/Travel_Agency.git
    ```
2.Navega al directorio del proyecto:
    
    ```
    cd travel-agency-reserva
    ```
3.Asegúrate de tener [Maven](https://maven.apache.org/install.html) instalado y ejecuta el siguiente comando para construir el proyecto:
  
    ```
    mvn clean install
    ```

## Uso

Para ejecutar la aplicación, utiliza el siguiente comando o click derecho en la clase principal y run as Spring Boot App:

```
mvn spring-boot:run
```

La aplicación estará disponible en `http://localhost:8080`.

### Endpoints

- **Insertar Reserva**
    - **URL**: `/insertarReserva`
    - **Método**: `POST`
    - **Cuerpo de la Solicitud**:
      ```json
      {
          "nombreCliente": "Juan Perez",
          "dni": "12345678A",
          "idHotel": 2,
          "idVuelo": 5,
          "numPersonas": 2
      }
      ```

- **Listar Reservas por Nombre de Hotel**
    - **URL**: `/reserva/{nombreHotel}`
    - **Método**: `GET`

## Estructura del Proyecto

```
src
├── main
│   ├── java
│   │   └── com
│   │       └── curso
│   │           ├── config
│   │           │   └── SecurityConfig.java
│   │           │   └── WebConfig.java
│   │           ├── controller
│   │           │   └── ReservaController.java
│   │           ├── dao
│   │           │   └── ReservaDAO.java
│   │           ├── model
│   │           │   └── Reserva.java
│   │           ├── service
│   │           │   └── ReservaService.java
│   │           └── inicio
│   │               └── TravelAgencyReservaApplication.java
│   └── resources
│       └── application.properties
└── test
    ├── java
    │   └── com
    │       └── curso
    │           ├── controller
    │           │   └── ReservaControllerTest.java
    │           └── inicio
    │               └── TravelAgencyReservaApplicationTests.java
    └── resources
        └── application-test.properties
```

## Ejecutando Pruebas

Para ejecutar las pruebas unitarias del proyecto, utiliza el siguiente comando o click derecho y pulsar en run rest con jUnit 5:

```
mvn test
```

### Pruebas Unitarias

Las pruebas unitarias se encuentran en `src/test/java/com/curso/controller/ReservaControllerTest.java`. Utilizan `Mockito` para simular las dependencias y `MockMvc` para realizar peticiones HTTP simuladas.

## Tecnologias Utilizadas

- Java 11
- Spring Boot
- Spring MVC
- Mockito
- JUnit 5
- Maven

## Autores

- **Alejandro Barbacil Castro** - *Desarrollador Principal*

## Licencia

Este proyecto no está licenciado bajo ninguna licencia.
