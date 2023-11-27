public class Aircraft {
    private String name; 
    private SeatMap seatMap; // Assuming SeatMap is a class or interface defined elsewhere

    // Constructor
    public Aircraft(String name, SeatMap seatMap) {
        this.name = name;
        this.seatMap = seatMap;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for seatMap
    public SeatMap getSeatMap() {
        return seatMap;
    }

    // Setter for seatMap
    public void setSeatMap(SeatMap seatMap) {
        this.seatMap = seatMap;
    }
}


