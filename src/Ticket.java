public class Ticket {
    private Flight flight;
    private Customer customer;
    private boolean hasInsurance;

    // Constructor
    public Ticket(Flight flight, Customer customer, boolean hasInsurance) {
        this.flight = flight;
        this.customer = customer;
        this.hasInsurance = hasInsurance;
    }

    // Getters and setters
    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public boolean hasInsurance() {
        return hasInsurance;
    }

    public void setHasInsurance(boolean hasInsurance) {
        this.hasInsurance = hasInsurance;
    }
}

