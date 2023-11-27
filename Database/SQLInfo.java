import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.EventQueue;

public class SQLInfo {
    private static Connection dbConnect;
    private ResultSet results;

    private ArrayList<String[]> users = new ArrayList<String[]>();
    private ArrayList<String[]> flights = new ArrayList<String[]>();
    private ArrayList<String[]> aircrafts = new ArrayList<String[]>();
    private ArrayList<String[]> seats = new ArrayList<String[]>();

    // private static User [] users_obj;
    // private static Flight [] flights_obj;
    // private static Aircraft [] aircrafts_obj;

    // public static User[] getUsers(){
    //     return SQLInfo.users_obj;
    // }

    // public static Flight[] getFlights(){
    //     return SQLInfo.flights_obj;
    // }

    // public static Aircraft[] getAircraft(){
    //     return SQLInfo.aircrafts_obj;
    // }

    public SQLInfo() {
    
    }

    public void close() {
        try {
            if (results != null) {
                results.close();
            }
            dbConnect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createConnection() {
        try {
            dbConnect = DriverManager.getConnection("jdbc:mysql://localhost/airline", "oop", "password");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String[]> selectUsers() {
        try {
            Statement myStmt = dbConnect.createStatement();
            results = myStmt.executeQuery("SELECT * FROM USERS");

            while (results.next()) {
                String[] userData = new String[6];
                userData[0] = results.getString("Username");
                userData[1] = results.getString("Password");
                userData[2] = results.getString("Email");
                userData[3] = String.valueOf(results.getBoolean("isRegistered"));
                userData[4] = String.valueOf(results.getDate("DateofBirth"));
                userData[5] = results.getString("UserType");
                users.add(userData);
            }

            myStmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return users;
    }

    public ArrayList<String[]> selectFlights() {
        try {
            Statement myStmt = dbConnect.createStatement();
            results = myStmt.executeQuery("SELECT * FROM FLIGHTS");

            while (results.next()) {
                String[] flightData = new String[4];
                flightData[0] = results.getString("FlightNumber");
                flightData[1] = results.getString("Destination");
                java.sql.Timestamp dateOfBirth = results.getTimestamp("DateofBirth");
                flightData[2] = dateOfBirth.toString();
                flightData[3] = results.getString("Aircraft");
                flights.add(flightData);
            }
    
            myStmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return flights;
    }

    public ArrayList<String[]> selectAircrafts() {
        try {
            Statement myStmt = dbConnect.createStatement();
            results = myStmt.executeQuery("SELECT * FROM AIRCRAFTS");

            while (results.next()) {
                String[] aircraftData = new String[3];
                aircraftData[0] = results.getString("AircraftName");
                aircraftData[1] = Integer.toString(results.getInt("NumberOfRegularSeats"));
                aircraftData[2] = Integer.toString(results.getInt("NumberOfBusinessSeats"));
                aircrafts.add(aircraftData);
            }
    
            myStmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return aircrafts;
    }

    public ArrayList<String[]> selectSeats() {
        try (Statement myStmt = dbConnect.createStatement()) {
            results = myStmt.executeQuery("SELECT * FROM SEATS");

            while (results.next()) {
                String[] seatData = new String[3];
                seatData[0] = results.getString("SeatNumber");
                seatData[1] = results.getString("Aircraft");
                seatData[2] = results.getString("SeatClass");
                seats.add(seatData);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            // Handle SQL exception gracefully
        }
        return seats;
    }

    public static void main(String[] args) {
        SQLInfo sqlInfo = new SQLInfo();
        sqlInfo.createConnection();
        ArrayList<String[]> usersData = sqlInfo.selectUsers();
        ArrayList<String[]> flightsData = sqlInfo.selectFlights();
        ArrayList<String[]> aircraftsData = sqlInfo.selectAircrafts();
        ArrayList<String[]> seatsData = sqlInfo.selectSeats();

        // Retrieve and print user information  
        System.out.println("Users:");
        for (String[] userData : usersData) {
            System.out.println(Arrays.toString(userData));
        }

        // Retrieve and print flight information
        System.out.println("\nFlights:");
        for (String[] flightData : flightsData) {
            System.out.println(Arrays.toString(flightData));
        }

        // Retrieve and print aircraft information
        System.out.println("\nAircrafts:");
        for (String[] aircraftData : aircraftsData) {
            System.out.println(Arrays.toString(aircraftData));
        }

        // Retrieve and print seat information
        System.out.println("\nSeats:");
        for (String[] seatData : seatsData) {
            System.out.println(Arrays.toString(seatData));
        }
    }
}