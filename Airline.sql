DROP DATABASE IF EXISTS AIRLINE;
CREATE DATABASE AIRLINE; 
USE AIRLINE;

DROP TABLE IF EXISTS AIRCRAFTS;
CREATE TABLE AIRCRAFTS (
    AircraftID  INT     PRIMARY KEY     AUTO_INCREMENT,
    AircraftName    VARCHAR(50),
    NumberOfRegularSeats    INT  NOT     NULL,
    NumberOfBusinessSeats   INT     NOT  NULL
);

INSERT INTO AIRCRAFTS (AircraftID, AircraftName, NumberofRegularSeats, NumberOfBusinessSeats) VALUES
(1, 'Boeing 777-300ER', 138, 36),
(2, 'Boeing 787-9', 138, 36),
(3, 'Boeing 737 MAX 8', 138, 36),
(4, 'Boeing 787-8', 138, 36);

DROP TABLE IF EXISTS FLIGHTS;
CREATE TABLE FLIGHTS (
    FlightNumber    VARCHAR(10)    PRIMARY KEY,
    Destination     VARCHAR(50)     NOT  NULL,
    DepartureDateTime   DATETIME  NOT NULL,
    Aircraft VARCHAR(50)    NOT     NULL,
    FOREIGN KEY (Aircraft)  REFERENCES   AIRCRAFTS(AircraftName)
);

INSERT INTO FLIGHTS (FlightNumber, Destination, DepartureDateTime, Aircraft) VALUES
('AC100', 'Vancouver', STR_TO_DATE('2023-11-10 08:00:00', '%Y-%m-%d %H:%i:%s'), 'Boeing 777-300ER'),
('AC200', 'Edmonton', STR_TO_DATE('2023-11-11 09:00:00', '%Y-%m-%d %H:%i:%s'), 'Boeing 787-9'),
('AC300', 'Toronto', STR_TO_DATE('2023-11-12 10:00:00', '%Y-%m-%d %H:%i:%s'), 'Boeing 737 MAX 8'),
('AC400', 'Saskatchewan', STR_TO_DATE('2023-11-13 11:00:00', '%Y-%m-%d %H:%i:%s'), 'Boeing 787-8');

DROP TABLE IF EXISTS CREWS;
CREATE TABLE CREWS (
    CrewID  INT  PRIMARY     KEY     AUTO_INCREMENT,
    CrewName    VARCHAR(50)  NOT NULL,
    CrewPosition     VARCHAR(50)    NOT NULL
);

INSERT INTO CREWS (CrewID, CrewName, CrewPosition) VALUES
(1, 'Michael', 'Pilot'),
(2, 'Pam', 'Flight Attendant'),
(3, 'Dwight', 'Flight Attendant'),
(4, 'Jim', 'Flight Attendant');

DROP TABLE IF EXISTS FLIGHTCREWS;
CREATE TABLE FLIGHTCREWS (
    FlightNumber    VARCHAR(10),
    CrewID  INT,
    PRIMARY KEY (FlightNumber, CrewID),
    FOREIGN KEY (FlightNumber)   REFERENCES     FLIGHTS(FlightNumber),
    FOREIGN KEY (CrewID)    REFERENCES   CREWS(CrewID)
);

INSERT INTO FLIGHTCREWS (FlightNumber, CrewID) VALUES
('AC100', 1),
('AC100', 2),
('AC100', 3),
('AC100', 4),
('AC200', 1),
('AC200', 2),
('AC300', 3),
('AC400', 4);

DROP TABLE IF EXISTS SEATS;
CREATE TABLE SEATS (
    SeatNumber  VARCHAR(5)  PRIMARY KEY,
    User    VARCHAR(50),
    SeatClass   VARCHAR(20)     NOT NULL,  -- e.g., Regular, Business-Class
    FOREIGN KEY (User)   REFERENCES     USERS(Username)
);

INSERT INTO SEATS (SeatNumber, User, SeatClass) VALUES
('1A', NULL, 'Business'),
('1B', NULL, 'Business'),
('1C', NULL, 'Business'),
('1D', NULL, 'Business'),
('1E', NULL, 'Business'),
('1F', NULL, 'Business'),
('2A', NULL, 'Business'),
('2B', NULL, 'Business'),
('2C', NULL, 'Business'),
('2D', NULL, 'Business'),
('2E', NULL, 'Business'),
('2F', NULL, 'Business'),
('3A', NULL, 'Business'),
('3B', NULL, 'Business'),
('3C', NULL, 'Business'),
('3D', NULL, 'Business'),
('3E', NULL, 'Business'),
('3F', NULL, 'Business'),
('4A', NULL, 'Business'),
('4B', NULL, 'Business'),
('4C', NULL, 'Business'),
('4D', NULL, 'Business'),
('4E', NULL, 'Business'),
('4F', NULL, 'Business'),
('5A', NULL, 'Regular'),
('5B', NULL, 'Regular'),
('5C', NULL, 'Regular'),
('5D', NULL, 'Regular'),
('5E', NULL, 'Regular'),
('5F', NULL, 'Regular'),
('6A', NULL, 'Regular'),
('6B', NULL, 'Regular'),
('6C', NULL, 'Regular'),
('6D', NULL, 'Regular'),
('6E', NULL, 'Regular'),
('6F', NULL, 'Regular'),
('7A', NULL, 'Regular'),
('7B', NULL, 'Regular'),
('7C', NULL, 'Regular'),
('7D', NULL, 'Regular'),
('7E', NULL, 'Regular'),
('7F', NULL, 'Regular'),
('8A', NULL, 'Regular'),
('8B', NULL, 'Regular'),
('8C', NULL, 'Regular'),
('8D', NULL, 'Regular'),
('8E', NULL, 'Regular'),
('8F', NULL, 'Regular'),
('9A', NULL, 'Regular'),
('9B', NULL, 'Regular'),
('9C', NULL, 'Regular'),
('9D', NULL, 'Regular'),
('9E', NULL, 'Regular'),
('9F', NULL, 'Regular'),
('10A', NULL, 'Regular'),
('10B', NULL, 'Regular'),
('10C', NULL, 'Regular'),
('10D', NULL, 'Regular'),
('10E', NULL, 'Regular'),
('10F', NULL, 'Regular'),
('11A', NULL, 'Regular'),
('11B', NULL, 'Regular'),
('11C', NULL, 'Regular'),
('11D', NULL, 'Regular'),
('11E', NULL, 'Regular'),
('11F', NULL, 'Regular'),
('12A', NULL, 'Regular'),
('12B', NULL, 'Regular'),
('12C', NULL, 'Regular'),
('12D', NULL, 'Regular'),
('12E', NULL, 'Regular'),
('12F', NULL, 'Regular'),
('13A', NULL, 'Regular'),
('13B', NULL, 'Regular'),
('13C', NULL, 'Regular'),
('13D', NULL, 'Regular'),
('13E', NULL, 'Regular'),
('13F', NULL, 'Regular'),
('14A', NULL, 'Regular'),
('14B', NULL, 'Regular'),
('14C', NULL, 'Regular'),
('14D', NULL, 'Regular'),
('14E', NULL, 'Regular'),
('14F', NULL, 'Regular');

DROP TABLE IF EXISTS USERS;
CREATE TABLE USERS (
    Username    VARCHAR(50)     PRIMARY KEY,
    Password    VARCHAR(50)  NOT NULL,
    Email   VARCHAR(100)    NOT NULL,
    IsRegistered    BOOLEAN  NOT NULL,
    DateOfBirth     DATE     NOT NULL,
    UserType    VARCHAR(50)     NOT NULL
);

INSERT INTO USERS (Username, Password, Email, IsRegistered, DateOfBirth, UserType) VALUES
('john_doe', 'password1', 'john.doe@email.com', true, '1990-05-15', 'Customer'),
('jane_smith', 'password2', 'jane.smith@email.com', true, '1985-08-22', 'Customer'),
('bob_jones', 'password3', 'bob.jones@email.com', false, '1978-11-10', 'Customer'),
('sara_miller', 'password4', 'sara.miller@email.com', true, '1995-03-05', 'Customer'),
('michael', 'password5', 'michael@theoffice.com', true, '1990-05-15', 'Crew'),
('pam', 'password6', 'pam@theoffice.com', true, '1985-08-22', 'Crew'),
('dwight', 'password7', 'dwight@theoffice.com', false, '1978-11-10', 'Crew'),
('jim', 'password8', 'jim@theoffice.com', true, '1995-03-05', 'Crew');

-- create user to use in java code
CREATE USER 'oop'@'localhost' IDENTIFIED BY 'password';
GRANT ALL PRIVILEGES ON *.* TO 'oop'@'localhost' WITH GRANT OPTION;