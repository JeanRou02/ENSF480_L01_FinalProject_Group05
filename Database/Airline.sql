DROP DATABASE IF EXISTS AIRLINE;
CREATE DATABASE AIRLINE; 
USE AIRLINE;

DROP TABLE IF EXISTS FLIGHTS;
CREATE TABLE FLIGHTS (
    FlightNumber VARCHAR(10) PRIMARY KEY,
    Destination VARCHAR(50) NOT NULL,
    DepartureDateTime DATETIME NOT NULL,
    Aircraft VARCHAR(10) NOT NULL,
    FOREIGN KEY (Aircraft) REFERENCES AIRCRAFTS(AircraftNam
);

DROP TABLE IF EXISTS CREWS;
CREATE TABLE CREWS (
    CrewID INT PRIMARY KEY AUTO_INCREMENT,
    CrewName VARCHAR(50) NOT NULL,
    CrewPosition VARCHAR(50) NOT NULL,
);

DROP TABLE IF EXISTS FLIGHTCREWS;
CREATE TABLE FLIGHTCREWS (
    FlightID INT,
    CrewID INT,
    PRIMARY KEY (FlightID, CrewID),
    FOREIGN KEY (FlightID) REFERENCES FLIGHTS(FlightID),
    FOREIGN KEY (CrewID) REFERENCES CREWS(CrewID),
);

DROP TABLE IF EXISTS AIRCRAFTS;
CREATE TABLE AIRCRAFTS (
    AircraftName VARCHAR(50) PRIMARY KEY,
    NumberOfSeats INT NOT NULL,
);

DROP TABLE IF EXISTS SEATS;
CREATE TABLE SEATS (
    SeatNumber VARCHAR(5) PRIMARY KEY,
    Aircraft VARCHAR(50),  -- Foreign key to Aircraft table
    SeatClass VARCHAR(20) NOT NULL,  -- e.g., Regular, Business-Class
    FOREIGN KEY (Aircraft) REFERENCES AIRCRAFTS(AircraftName)
);

DROP TABLE IF EXISTS USERS;
CREATE TABLE USERS (
    Username VARCHAR(50) PRIMARY KEY,
    Password VARCHAR(50) NOT NULL,
    Email VARCHAR(100) NOT NULL,
    IsRegistered BOOLEAN NOT NULL,
    DateOfBirth DATE NOT NULL,
    UserType VARCHAR(50) NOT NULL,
);


