import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SeatMap {
    // Map representing the seats and the User occupying them. null if the seat is available.
    private Map<String, User> seats;

    public SeatMap(int numberOfSeats) {
        this.seats = new HashMap<>();
        // Initialize the seat map with seat numbers/names. Initially, all seats are unoccupied (null).
        for (int i = 1; i <= numberOfSeats; i++) {
            seats.put("Seat " + i, null); // Replace with your actual seat numbering/naming scheme
        }
    }

    // Method to check if a seat is available
    public boolean isSeatAvailable(String seatNumber) {
        return seats.get(seatNumber) == null;
    }

    // Method for a user to browse available seats
    public void browseAvailableSeats() {
        System.out.println("Available seats:");
        seats.forEach((seatNumber, user) -> {
            if (user == null) { // if seat is not occupied
                System.out.println(seatNumber);
            }
        });
    }

    // Method to assign a seat to a user
    public boolean assignSeat(String seatNumber, User user) {
        if (isSeatAvailable(seatNumber)) {
            seats.put(seatNumber, user); // Assign the user to the seat
            return true;
        } else {
            return false; // Seat was already occupied or doesn't exist
        }
    }

    // Method for admin to clear a seat assignment
    public void clearSeat(String seatNumber) {
        seats.put(seatNumber, null);
    }

    // Method to get the User object occupying a seat
    public User getUserForSeat(String seatNumber) {
        return seats.get(seatNumber);
    }

    // Method to get a read-only view of the map of seats
    public Map<String, User> getMapOfSeats() {
        return Collections.unmodifiableMap(seats);
    }
}


