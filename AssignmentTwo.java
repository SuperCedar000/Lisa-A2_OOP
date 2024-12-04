import java.io.File;

public class AssignmentTwo {

    public static void main(String[] args) {
        // 创建一个 Ride 实例
        Ride rollerCoaster = new Ride("Roller Coaster", 3);

        // 创建游客
        Visitor visitor1 = new Visitor("Alice Brown", 28, "VIP001", true);
        Visitor visitor2 = new Visitor("Bob Smith", 34, "VIP002", false);
        Visitor visitor3 = new Visitor("Charlie Johnson", 25, "VIP003", true);
        Visitor visitor4 = new Visitor("Diana Prince", 30, "VIP004", false);
        Visitor visitor5 = new Visitor("Ethan Clark", 40, "VIP005", true);

        // 添加游客到 Ride
        rollerCoaster.addVisitorToQueue(visitor1);
        rollerCoaster.addVisitorToQueue(visitor2);
        rollerCoaster.addVisitorToQueue(visitor3);
        rollerCoaster.addVisitorToQueue(visitor4);
        rollerCoaster.addVisitorToQueue(visitor5);

        // 运行一次游乐设施
        rollerCoaster.runOneCycle();

        // 导出游客历史记录到文件
        String filename = "ride_history.txt";
        rollerCoaster.exportRideHistory(filename);

        // 在 partSeven 方法中进行导入
        partSeven(rollerCo
