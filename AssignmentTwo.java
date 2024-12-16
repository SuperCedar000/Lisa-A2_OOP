public class AssignmentTwo {
    public static void main(String[] args) {
        // 运行并展示每个部分的结果
        AssignmentTwo assignment = new AssignmentTwo();
        assignment.partOne();
        assignment.partTwo();
        assignment.partThree();
        assignment.partFourA();
        assignment.partFourB();
        assignment.partFive();
        assignment.partSix();
        assignment.partSeven();
    }

    // Part 1: 类和继承
    public void partOne() {
        System.out.println("Part 1 - Classes and Inheritance");
        Employee operator = new Employee("John Doe", 30, "123 Park Lane", "Ride Operator", 40000);

        // 添加5个游客，确保这些游客对象被使用
        Visitor visitor1 = new Visitor("Boff", 25, "Address 1", "Regular", false);
        Visitor visitor2 = new Visitor("Lsiq", 30, "Address 2", "VIP", true);
        Visitor visitor3 = new Visitor("Lammy", 22, "Address 3", "Regular", false);
        Visitor visitor4 = new Visitor("Oliu", 27, "Address 4", "VIP", true);
        Visitor visitor5 = new Visitor("Pubil", 35, "Address 5", "Regular", false);

        // 确保在后续逻辑中使用这些 Visitor 对象
        Ride rollerCoaster = new Ride("Roller Coaster", 5, operator, 3);

        // 测试继承和对象创建
        System.out.println(visitor1.getName() + " is a visitor. Ride operator is " + operator.getName());
        System.out.println("Ride name: " + rollerCoaster.getRideName());
        System.out.println();
    }

    // Part 2: 抽象类和接口
    public void partTwo() {
        System.out.println("Part 2 - Abstract class and Interface");

        Ride rollerCoaster = new Ride("Roller Coaster", 10, new Employee("John", 30, "123 Main St", "Operator", 50000), 3);

        // 添加5个游客
        rollerCoaster.addVisitorToQueue(new Visitor("Boff", 25, "Address 1", "Regular", false));
        rollerCoaster.addVisitorToQueue(new Visitor("Lsiq", 30, "Address 2", "VIP", true));
        rollerCoaster.addVisitorToQueue(new Visitor("Lammy", 22, "Address 3", "Regular", false));
        rollerCoaster.addVisitorToQueue(new Visitor("Oliu", 27, "Address 4", "VIP", true));
        rollerCoaster.addVisitorToQueue(new Visitor("Pubil", 35, "Address 5", "Regular", false));

        rollerCoaster.printQueue();
        System.out.println();
    }

    // Part 3: 队列接口
    public void partThree() {
        System.out.println("Part 3 - Queue Interface");
        Ride rollerCoaster = new Ride("Roller Coaster", 10, new Employee("John", 30, "123 Main St", "Operator", 50000), 3);

        // 添加5个游客到队列
        rollerCoaster.addVisitorToQueue(new Visitor("Boff", 25, "Address 1", "Regular", false));
        rollerCoaster.addVisitorToQueue(new Visitor("Lsiq", 30, "Address 2", "VIP", true));
        rollerCoaster.addVisitorToQueue(new Visitor("Lammy", 22, "Address 3", "Regular", false));
        rollerCoaster.addVisitorToQueue(new Visitor("Oliu", 27, "Address 4", "VIP", true));
        rollerCoaster.addVisitorToQueue(new Visitor("Pubil", 35, "Address 5", "Regular", false));

        // 打印队列中的游客
        rollerCoaster.printQueue();

        // 移除一个游客
        rollerCoaster.removeVisitorFromQueue();
        rollerCoaster.printQueue();
        System.out.println();
    }

    // Part 4A: 集合类（LinkedList）
    public void partFourA() {
        System.out.println("Part 4A - Collection class (LinkedList)");
        Ride rollerCoaster = new Ride("Roller Coaster", 10, new Employee("John", 30, "123 Main St", "Operator", 50000), 3);

        // 添加5个游客到历史记录
        rollerCoaster.addVisitorToHistory(new Visitor("Boff", 25, "Address 1", "Regular", false));
        rollerCoaster.addVisitorToHistory(new Visitor("Lsiq", 30, "Address 2", "VIP", true));
        rollerCoaster.addVisitorToHistory(new Visitor("Lammy", 22, "Address 3", "Regular", false));
        rollerCoaster.addVisitorToHistory(new Visitor("Oliu", 27, "Address 4", "VIP", true));
        rollerCoaster.addVisitorToHistory(new Visitor("Pubil", 35, "Address 5", "Regular", false));

        // 打印所有游客信息
        rollerCoaster.printRideHistory();
        rollerCoaster.numberOfVisitors();

        // 确认某个特定的访客是否在历史记录中
        Visitor checkVisitor = new Visitor("Lammy", 22, "Address 3", "Regular", false);
        rollerCoaster.checkVisitorFromHistory(checkVisitor);

        System.out.println();
    }

    // Part 4B: 排序集合
    public void partFourB() {
        System.out.println("Part 4B - Sorting the collection");
        Ride rollerCoaster = new Ride("Roller Coaster", 10, new Employee("John", 30, "123 Main St", "Operator", 50000), 3);

        // 添加游客到 rideHistory，并修改游客的名字
        rollerCoaster.addVisitorToHistory(new Visitor("Boff", 25, "Address 1", "Regular", false));
        rollerCoaster.addVisitorToHistory(new Visitor("Lsiq", 30, "Address 2", "VIP", true));
        rollerCoaster.addVisitorToHistory(new Visitor("Lammy", 22, "Address 3", "Regular", false));
        rollerCoaster.addVisitorToHistory(new Visitor("Oliu", 27, "Address 4", "VIP", true));
        rollerCoaster.addVisitorToHistory(new Visitor("Pubil", 35, "Address 5", "Regular", false));

        // 打印排序前的游客
        System.out.println("Before Sorting:");
        rollerCoaster.printRideHistory();

        // 排序
        VisitorComparator comparator = new VisitorComparator();
        rollerCoaster.sortRideHistory(comparator);

        // 打印排序后的游客
        System.out.println("After Sorting:");
        rollerCoaster.printRideHistory();
        System.out.println();
    }

    // Part 5: 运行一轮乘坐
    public void partFive() {
        System.out.println("Part 5 - Run a ride cycle");
        Ride rollerCoaster = new Ride("Roller Coaster", 10, new Employee("John", 30, "123 Main St", "Operator", 50000), 3);

        // 添加10个游客到队列，名字依次修改
        rollerCoaster.addVisitorToQueue(new Visitor("Plsi", 23, "Address 6", "VIP", false));
        rollerCoaster.addVisitorToQueue(new Visitor("Ljuf", 26, "Address 7", "Regular", true));
        rollerCoaster.addVisitorToQueue(new Visitor("Rtui", 28, "Address 8", "VIP", true));
        rollerCoaster.addVisitorToQueue(new Visitor("Kity", 31, "Address 9", "Regular", false));
        rollerCoaster.addVisitorToQueue(new Visitor("Looly", 32, "Address 10", "VIP", true));
        rollerCoaster.addVisitorToQueue(new Visitor("Zeke", 29, "Address 11", "Regular", false));
        rollerCoaster.addVisitorToQueue(new Visitor("Yara", 24, "Address 12", "VIP", true));
        rollerCoaster.addVisitorToQueue(new Visitor("Ulya", 27, "Address 13", "Regular", false));
        rollerCoaster.addVisitorToQueue(new Visitor("Xeno", 34, "Address 14", "VIP", true));
        rollerCoaster.addVisitorToQueue(new Visitor("Vera", 29, "Address 15", "Regular", false));

        // 打印队列中的游客
        rollerCoaster.printQueue();

        // 执行一次乘坐
        rollerCoaster.runOneCycle();

        // 打印乘坐后的队列
        rollerCoaster.printQueue();

        // 打印历史游客
        rollerCoaster.printRideHistory();
        System.out.println();
    }

    // Part 6: 写入文件
    public void partSix() {
        System.out.println("Part 6 - Writing to a file");
        Ride rollerCoaster = new Ride("Roller Coaster", 10, new Employee("John", 30, "123 Main St", "Operator", 50000), 3);

        // 添加游客到 rideHistory，并修改游客的名字
        rollerCoaster.addVisitorToHistory(new Visitor("Boff", 25, "Address 1", "Regular", false));
        rollerCoaster.addVisitorToHistory(new Visitor("Lsiq", 30, "Address 2", "VIP", true));
        rollerCoaster.addVisitorToHistory(new Visitor("Lammy", 22, "Address 3", "Regular", false));
        rollerCoaster.addVisitorToHistory(new Visitor("Oliu", 27, "Address 4", "VIP", true));
        rollerCoaster.addVisitorToHistory(new Visitor("Pubil", 35, "Address 5", "Regular", false));

        // 导出历史记录到文件
        rollerCoaster.exportRideHistory("output.csv");
        System.out.println();
    }

    // Part 7: 从文件中读取
    public void partSeven() {
        System.out.println("Part 7 - Reading from a file");
        Ride rollerCoaster = new Ride();

        // 从文件导入历史记录
        rollerCoaster.importRideHistory("output.csv");

        // 打印导入后的历史记录
        rollerCoaster.printRideHistory();
    }
}

