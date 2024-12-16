public interface RideInterface {
    void addVisitorToQueue(Visitor visitor);
    void removeVisitorFromQueue();
    void printQueue();
    void addVisitorToHistory(Visitor visitor);
    boolean checkVisitorFromHistory(Visitor visitor);
    int numberOfVisitors();
    void printRideHistory();
    void runOneCycle();
    void exportRideHistory(String fileName);
    void importRideHistory(String fileName);
}
