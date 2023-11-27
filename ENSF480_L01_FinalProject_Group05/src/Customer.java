import java.util.ArrayList;

public class Customer extends User {
    private String email;
    private ArrayList<Ticket> tickets; // Assuming Ticket is a class defined elsewhere
    private boolean isRegistered;
    private int creditCard;

    // Constructor
    public Customer(String name, String userName, String password, String dateOfBirth, String userType, String email, ArrayList<Ticket> tickets, boolean isRegistered, int creditCard) {
        super(name, userName, password, dateOfBirth, userType);
        this.email = email;
        this.tickets = tickets;
        this.isRegistered = isRegistered;
        this.creditCard = creditCard;
    }

    // Getters and setters for the new fields in Customer

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(ArrayList<Ticket> tickets) {
        this.tickets = tickets;
    }

    public boolean isRegistered() {
        return isRegistered;
    }

    public void setRegistered(boolean registered) {
        isRegistered = registered;
    }

    public int getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(int creditCard) {
        this.creditCard = creditCard;
    }
}

