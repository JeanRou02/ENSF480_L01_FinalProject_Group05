public class Seat {
    private Customer customer;
    private String seatClass;
    private int seatNumber;

    public Customer getCustomer() {
        return customer;
    }
    public String getSeatClass() {
        return seatClass;
    }
    public int getSeatNumber() {
        return seatNumber;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setSeatClass(String seatClass) {
        this.seatClass = seatClass;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }
    public boolean isAvailable() {
        if (customer == null) {
            return false;
        }
        return true;
    }
}
