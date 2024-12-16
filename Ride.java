import java.io.*;
import java.util.*;

public class Ride implements RideInterface {
    private String rideName;
    private int capacity;
    private Employee operator;
    private Queue<Visitor> visitorQueue;
    private LinkedList<Visitor> rideHistory;
    private int maxRider;
    private int numOfCycles;

    public Ride() {
        this.visitorQueue = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
        this.numOfCycles = 0;
        this.maxRider = 1;
    }

    public Ride(String rideName, int capacity, Employee operator, int maxRider) {
        this.rideName = rideName;
        this.capacity = capacity;
        this.operator = operator;
        this.visitorQueue = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
        this.numOfCycles = 0;
        this.maxRider = maxRider;
    }

    // Getter for rideName
    public String getRideName() {
        return rideName;
    }

    public void addVisitorToQueue(Visitor visitor) {
        visitorQueue.add(visitor);
        System.out.println(visitor.getName() + " has been added to the queue.");
    }

    public void removeVisitorFromQueue() {
        if (!visitorQueue.isEmpty()) {
            Visitor removedVisitor = visitorQueue.poll();
            System.out.println(removedVisitor.getName() + " has been removed from the queue.");
        } else {
            System.out.println("The queue is empty. No visitors to remove.");
        }
    }

    public void printQueue() {
        if (visitorQueue.isEmpty()) {
            System.out.println("The queue is currently empty.");
        } else {
            System.out.println("Visitors in the queue:");
            for (Visitor visitor : visitorQueue) {
                System.out.println("- " + visitor.getName());
            }
        }
    }

    public void addVisitorToHistory(Visitor visitor) {
        rideHistory.add(visitor);
        System.out.println(visitor.getName() + " has been added to the ride history.");
    }

    public boolean checkVisitorFromHistory(Visitor visitor) {
        boolean found = rideHistory.contains(visitor);
        System.out.println(found ? visitor.getName() + " is in the ride history."
                : visitor.getName() + " is not in the ride history.");
        return found;
    }

    public int numberOfVisitors() {
        int count = rideHistory.size();
        System.out.println("Number of visitors in the ride history: " + count);
        return count;
    }

    public void printRideHistory() {
        if (rideHistory.isEmpty()) {
            System.out.println("No visitors in the ride history.");
        } else {
            System.out.println("Visitors in the ride history:");
            for (Visitor visitor : rideHistory) {
                System.out.println("- " + visitor.getName() + ", Age: " + visitor.getAge());
            }
        }
    }

    public void runOneCycle() {
        if (operator == null) {
            System.out.println("The ride cannot operate without an assigned operator.");
            return;
        }

        if (visitorQueue.isEmpty()) {
            System.out.println("The queue is empty. The ride cannot run.");
            return;
        }

        System.out.println("Running the ride for one cycle...");
        int ridersThisCycle = Math.min(maxRider, visitorQueue.size());
        for (int i = 0; i < ridersThisCycle; i++) {
            Visitor visitor = visitorQueue.poll();
            addVisitorToHistory(visitor);
            System.out.println(visitor.getName() + " is taking the ride.");
        }

        numOfCycles++;
        System.out.println("Cycle completed! Total cycles run: " + numOfCycles);
    }

    // Export ride history to a CSV file
    public void exportRideHistory(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Visitor visitor : rideHistory) {
                String line = visitor.getName() + "," + visitor.getAge() + "," + visitor.getAddress() + ","
                        + visitor.getTicketType() + "," + visitor.isHasMembership();
                writer.write(line);
                writer.newLine();
            }
            System.out.println("Ride history successfully exported to " + fileName);
        } catch (IOException e) {
            System.err.println("Error while exporting ride history: " + e.getMessage());
        }
    }

    // Import ride history from a CSV file with error handling
    public void importRideHistory(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    String name = parts[0];
                    int age = Integer.parseInt(parts[1]);
                    String address = parts[2];
                    String ticketType = parts[3];
                    boolean hasMembership = Boolean.parseBoolean(parts[4]);
                    Visitor visitor = new Visitor(name, age, address, ticketType, hasMembership);
                    rideHistory.add(visitor);
                } else {
                    System.err.println("Malformed line in file: " + line);
                }
            }
            System.out.println("Ride history successfully imported from " + fileName);
        } catch (IOException e) {
            System.err.println("Error while importing ride history: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error while parsing numeric data: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("错误信息: " + e.getMessage()); // 输出通用错误信息
        }
    }

    // Sort the ride history based on a comparator (by age)
    public void sortRideHistory(Comparator<Visitor> comparator) {
        Collections.sort(rideHistory, comparator);
        System.out.println("Ride history has been sorted by age.");
    }
}
