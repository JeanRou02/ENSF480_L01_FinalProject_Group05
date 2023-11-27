public class Flight {
    private String flightNumber;
    private String destination;
    private String departure;
    private Aircraft aircraft;
    private Crew crew[];

    public Flight(String flightNumber, String destination, String departure, Aircraft aircraft) {
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.departure = departure;
        this.aircraft = aircraft;
    }

    public void browseCrews() {
        // Implementation goes here
        // This method is supposed to allow browsing through crew members, which needs further details to be implemented.
    }

    // Getters and setters for the properties
    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public Aircraft getAircraft() {
        return aircraft;
    }

    public void setAircraft(Aircraft aircraft) {
        this.aircraft = aircraft;
    }

    public Crew[] getCrew() {
        return crew;
    }

    public void setCrew(Crew[] crew) {
        this.crew = crew;
    }
}

