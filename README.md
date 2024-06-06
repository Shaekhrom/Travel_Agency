# Travel_Agency
The project involves developing a modularized management system with three microservices in Java Spring Boot, connected to a database. These services include hotel, reservation, and flight management, with a frontend for user interaction.
<br>Created by @Shaekhrom (Alejandro Barbacil) for the java master course at ViewNext<br> 
<br>Database Sructure of travelAgency (MySQL)<br>
<br>CREATE TABLE Hotel (
<br> idHotel INT AUTO_INCREMENT PRIMARY KEY,
<br>     nombre VARCHAR(255),
<br>     categoria INT,
<br>     precio DECIMAL(10, 2),
<br>     disponible VARCHAR(3)
<br>);
<br> 
<br> CREATE TABLE Vuelo (
<br>     idVuelo INT AUTO_INCREMENT PRIMARY KEY,
<br>     compañia VARCHAR(255),
<br>     fechaVuelo DATE,
<br>     precio DECIMAL(10, 2),
<br>     plazasDisponibles INT
<br> );
<br> 
<br> CREATE TABLE Reserva (
<br>     idReserva INT AUTO_INCREMENT PRIMARY KEY,
<br>     nombreCliente VARCHAR(255),
<br>     dni VARCHAR(20),
<br>     idHotel INT,
<br>     idVuelo INT,
<br>     FOREIGN KEY (idHotel) REFERENCES Hotel(idHotel),
<br>     FOREIGN KEY (idVuelo) REFERENCES Vuelo(idVuelo)
<br> );
<br>
<br>INSERT INTO Hotel (nombre, categoria, precio, disponible)
<br>VALUES 
<br>('Grand Hotel', 5, 250.00, 'si'),
<br>('Sunset Resort', 4, 180.00, 'si'),
<br>('Ocean View Inn', 3, 120.00, 'si'),
<br>('Mountain Lodge', 4, 200.00, 'no'),
<br>('City Center Suites', 3, 150.00, 'si');
<br>
<br>INSERT INTO Vuelo (compañia, fechaVuelo, precio, plazasDisponibles)
<br>VALUES 
<br>('AirTravel Inc.', '2024-07-15', 300.00, 150),
<br>('SkyJet Airways', '2024-08-20', 250.00, 200),
<br>('StarLines', '2024-09-10', 200.00, 100),
<br>('WingWay Airlines', '2024-07-25', 350.00, 180),
<br>('CloudNine Flights', '2024-08-30', 280.00, 220);
