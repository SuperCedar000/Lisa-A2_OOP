public class Visitor extends Person {
    private String membershipNumber;
    private boolean isVIP;

    public Visitor(String name, int age, String membershipNumber, boolean isVIP) {
        super(name, age);
        this.membershipNumber = membershipNumber;
        this.isVIP = isVIP;
    }
