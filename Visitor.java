public class Visitor extends Person {
    private String ticketType;
    private boolean hasMembership;

    // Default constructor
    public Visitor() {}

    // Constructor with parameters
    public Visitor(String name, int age, String address, String ticketType, boolean hasMembership) {
        super(name, age, address);
        this.ticketType = ticketType;
        this.hasMembership = hasMembership;
    }

    // Getters and setters
    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public boolean isHasMembership() {
        return hasMembership;
    }

    public void setHasMembership(boolean hasMembership) {
        this.hasMembership = hasMembership;
    }
}
