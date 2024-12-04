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
        System.out.println("Running one cycle of the ride: " + name);
        int riders = Math.min(queue.size(), maxRiders);
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
            System.out.println("- " + visitor.getName());
        }
    }

    @Override
    public void printRideHistory() {
        System.out.println("Ride history for " + name + ":");
        for (Visitor visitor : history) {
            System.out.println("- " + visitor.getName());
        }
    }
}
