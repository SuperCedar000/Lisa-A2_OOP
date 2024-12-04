public class Employee extends Person {
    private String role;

    public Employee(String name, int age, String role) {
        super(name, age);
        this.role = role;
    }
