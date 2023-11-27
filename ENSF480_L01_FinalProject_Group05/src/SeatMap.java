public class SeatMap {
    private Seat[] seats;

    public SeatMap() {
        seats = new Seat[29 * 6]; // 29 rows, 6 seats per row
        initializeSeats();
    }

    private void initializeSeats() {
        int seatIndex = 0;
        for (int row = 1; row <= 29; row++) {
            for (char column = 'A'; column <= 'F'; column++) {
                seats[seatIndex] = new Seat();
                seats[seatIndex].setSeatNumber(row + String.valueOf(column));
                if (row <= 4) {
                    seats[seatIndex].setSeatClass("Business");
                } else {
                    seats[seatIndex].setSeatClass("Regular");
                }
                seatIndex++;
            }
        }
    }

    public boolean addCustomerToSeat(String seatNumber, Customer customer) {
        for (Seat seat : seats) {
            if (seat.getSeatNumber().equals(seatNumber)) {
                if (seat.isAvailable()) {
                    seat.setCustomer(customer);
                    return true; // Customer added successfully
                } else {
                    return false; // Seat is already occupied
                }
            }
        }
        return false; // Seat number not found
    }

    public Seat[] getSeats() {
        return seats;
    }

    public boolean removeCustomerFromSeat(String seatNumber) {
        for (Seat seat : seats) {
            if (seat.getSeatNumber().equals(seatNumber)) {
                if (!seat.isAvailable()) {
                    seat.setCustomer(null);
                    return true; // Customer removed successfully
                } else {
                    return false; // Seat is already empty
                }
            }
        }
        return false; // Seat number not found
    }

    public boolean removeCustomer(Customer customer) {
        for (Seat seat : seats) {
            if (seat.getCustomer() != null && seat.getCustomer().equals(customer)) {
                seat.setCustomer(null);
                return true; // Customer removed successfully
            }
        }
        return false; // Customer not found in any seat
    }
}



