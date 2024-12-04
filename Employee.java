public class Employee extends Person {
    private String role;

    public Employee(String name, int age, String role) {
        super(name, age);
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    @Override
    public void displayInfo() {
        System.out.println("Employee: " + getName() + ", Age: " + getAge() + 
                           ", Role: " + role);
    }
}
