public class Visitor extends Person {
    private String membershipNumber;
    private boolean isVIP;

    public Visitor(String name, int age, String membershipNumber, boolean isVIP) {
        super(name, age);
        this.membershipNumber = membershipNumber;
        this.isVIP = isVIP;
    }

    public String getMembershipNumber() {
        return membershipNumber;
    }

    public boolean isVIP() {
        return isVIP;
    }

    @Override
    public void displayInfo() {
        System.out.println("Visitor: " + getName() + ", Age: " + getAge() + 
                           ", Membership: " + membershipNumber + ", VIP: " + isVIP);
    }
}
