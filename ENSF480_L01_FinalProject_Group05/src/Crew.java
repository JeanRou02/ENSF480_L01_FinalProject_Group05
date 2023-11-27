public class Crew extends User {
    private String jobPosition; // Either a Pilot or a Flight Attendant
    private Flight flightAssignedTo; // A Flight object that the crew member is assigned to

    // Constructor
    public Crew(String name, String userName, String password, String dateOfBirth, String userType, String jobPosition) {
        super(name, userName, password, dateOfBirth, userType); // Call to User's constructor
        this.jobPosition = jobPosition;
    }

    // Getter for jobPosition
    public String getJobPosition() {
        return jobPosition;
    }

    // Setter for jobPosition
    public void setJobPosition(String jobPosition) {
        this.jobPosition = jobPosition;
    }

    // Getter for flightAssignedTo
    public Flight getFlightAssignedTo() {
        return flightAssignedTo;
    }

    // Setter for flightAssignedTo
    public void setFlightAssignedTo(Flight flightAssignedTo) {
        this.flightAssignedTo = flightAssignedTo;
    }
}



