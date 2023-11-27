import java.util.ArrayList;

public class Customer extends User {
	private String email;
	private ArrayList<Ticket> tickets;
	private boolean isRegistered;
	private int creditCard;
	
	public String getEmail() {
		return this.email;
	}
	public ArrayList<Ticket> getTickets(){
		return this.tickets;
	}
	public Ticket getTicket(int index) {
		return this.tickets.get(index);
	}
	public boolean getIsRegistered() {
		return this.isRegistered;
	}
	public int getCreditCard() {
		return this.creditCard;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	public void setTickets(ArrayList<Ticket> tickets) {
		this.tickets = tickets;
	}
	public void setIsRegistered(bool isRegistered) {
		this.isRegistered = isRegistered;
	}
	public void setCreditCard(int creditCard) {
		this.creditCard = creditCard;
	}
	public void addTicket(Ticket ticket) {
		tickets.add(ticket);
	}
	
}
