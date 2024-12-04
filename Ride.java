import java.io.*;
import java.util.*;

public class Ride implements RideInterface {
    private String name;
    private int maxRiders;
    private Queue<Visitor> queue;
    private List<Visitor> history;

    public Ride(String name, int maxRiders) {
        this.name = name;
        this.maxRiders = maxRiders;
        this.queue = new LinkedList<>();
        this.history = new ArrayList<>();
    }

    @Override
    public void addVisitorToQueue(Visitor visitor) {
        queue.add(visitor);
        System.out.println(visitor.getName() + " added to the queue.");
    }

    @Override
    public void runOneCycle() {
        if (queue.isEmpty()) {
            System.out.println("No visitors in the queue. Cannot run the ride.");
            return;
        }

        int riders = Math.min(queue.size(), maxRiders);
        System.out.println("Running ride for " + riders + " visitors...");
        for (int i = 0; i < riders; i++) {
            Visitor visitor = queue.poll(); // 从队列中移除
            history.add(visitor);          // 添加到历史记录
            System.out.println(visitor.getName() + " enjoyed the ride.");
        }
    }

    @Override
    public void printQueue() {
        System.out.println("Current queue for " + name + ":");
        for (Visitor visitor : queue) {
            visitor.displayInfo();
        }
    }

    @Override
    public void printRideHistory() {
        System.out.println("Ride history for " + name + ":");
        for (Visitor visitor : history) {
            visitor.displayInfo();
        }
    }

    @Override
    public void exportRideHistory(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Visitor visitor : history) {
                writer.write(visitor.getName() + "," + visitor.getAge() + "," + visitor.getMembershipNumber() + "," + visitor.isVIP());
                writer.newLine();
            }
            System.out.println("History has been successfully exported to " + filename);
        } catch (IOException e) {
            System.err.println("Error exporting ride history: " + e.getMessage());
        }
    }

    @Override
    public void importRideHistory(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String name = data[0];
                int age = Integer.parseInt(data[1]);
                String membershipNumber = data[2];
                boolean isVIP = Boolean.parseBoolean(data[3]);

                Visitor visitor = new Visitor(name, age, membershipNumber, isVIP);
                history.add(visitor);
            }
            System.out.println("History has been successfully imported from " + filename);
        } catch (IOException e) {
            System.err.println("Error importing ride history: " + e.getMessage());
        }
    }

    @Override
    public int numberOfVisitors() {
        return history.size();
    }
}
