DROP DATABASE IF EXISTS AIRLINE;
CREATE DATABASE AIRLINE; 
USE AIRLINE;

DROP TABLE IF EXISTS AIRCRAFTS;
CREATE TABLE AIRCRAFTS (
    AircraftName    VARCHAR(50)  PRIMARY KEY,
    NumberOfRegularSeats    INT  NOT     NULL,
    NumberOfBusinessSeats   INT     NOT  NULL
);

INSERT INTO AIRCRAFTS (AircraftName, NumberofRegularSeats, NumberOfBusinessSeats) VALUES
('Boeing 777-300ER', 4, 2),
('Boeing 787-9', 8, 2),
('Boeing 737 MAX 8', 6, 2),
('Boeing 787-8', 8, 4);

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
    SeatID  INT  PRIMARY     KEY     AUTO_INCREMENT,
    SeatNumber  VARCHAR(5),
    Aircraft    VARCHAR(50),  -- Foreign key to Aircraft table
    SeatClass   VARCHAR(20)     NOT NULL,  -- e.g., Regular, Business-Class
    FOREIGN KEY (Aircraft)   REFERENCES     AIRCRAFTS(AircraftName)
);

INSERT INTO SEATS (SeatID, SeatNumber, Aircraft, SeatClass) VALUES
(1, '1A', 'Boeing 777-300ER', 'Business'),
(2, '1B', 'Boeing 777-300ER', 'Business'),
(3, '2A', 'Boeing 777-300ER', 'Regular'),
(4, '2B', 'Boeing 777-300ER', 'Regular'),
(5, '3A', 'Boeing 777-300ER', 'Regular'),
(6, '3B', 'Boeing 777-300ER', 'Regular'),
-- Repeat similar entries for other aircraft models
(7, '1A', 'Boeing 787-9', 'Business'),
(8, '1B', 'Boeing 787-9', 'Business'),
(9, '2A', 'Boeing 787-9', 'Regular'),
(10, '2B', 'Boeing 787-9', 'Regular'),
(11, '3A', 'Boeing 787-9', 'Regular'),
(12, '3B', 'Boeing 787-9', 'Regular'),
(13, '4A', 'Boeing 787-9', 'Regular'),
(14, '4B', 'Boeing 787-9', 'Regular'),
(15, '5A', 'Boeing 787-9', 'Regular'),
(16, '5B', 'Boeing 787-9', 'Regular'),
-- Repeat similar entries for other aircraft models
(17, '1A', 'Boeing 737 MAX 8', 'Business'),
(18, '1B', 'Boeing 737 MAX 8', 'Business'),
(19, '2A', 'Boeing 737 MAX 8', 'Regular'),
(20, '2B', 'Boeing 737 MAX 8', 'Regular'),
(21, '3A', 'Boeing 737 MAX 8', 'Regular'),
(22, '3B', 'Boeing 737 MAX 8', 'Regular'),
(23, '4A', 'Boeing 737 MAX 8', 'Regular'),
(24, '4B', 'Boeing 737 MAX 8', 'Regular'),
-- Repeat similar entries for other aircraft models
(25, '1A', 'Boeing 787-8', 'Business'),
(26, '1B', 'Boeing 787-8', 'Business'),
(27, '2A', 'Boeing 787-8', 'Business'),
(28, '2B', 'Boeing 787-8', 'Business'),
(29, '3A', 'Boeing 787-8', 'Regular'),
(30, '3B', 'Boeing 787-8', 'Regular'),
(31, '4A', 'Boeing 787-8', 'Regular'),
(32, '4B', 'Boeing 787-8', 'Regular'),
(33, '5A', 'Boeing 787-8', 'Regular'),
(34, '5B', 'Boeing 787-8', 'Regular'),
(35, '6A', 'Boeing 787-8', 'Regular'),
(36, '6B', 'Boeing 787-8', 'Regular');

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