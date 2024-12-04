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

   