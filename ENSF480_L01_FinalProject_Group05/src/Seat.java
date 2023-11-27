public class Seat {
    private Customer customer;
    private String seatClass;
    private String seatNumber;

    public Customer getCustomer() {
        return customer;
    }
    public String getSeatClass() {
        return seatClass;
    }
    public String getSeatNumber() {
        return seatNumber;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setSeatClass(String seatClass) {
        this.seatClass = seatClass;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }
    public boolean isAvailable() {
        if (customer == null) {
            return false;
        }
        return true;
    }
}
