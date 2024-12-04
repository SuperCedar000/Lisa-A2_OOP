
public interface RideInterface {
    void addVisitorToQueue(Visitor visitor); // 添加游客到队列
    void runOneCycle();                      // 运行一次游乐设施
    void printQueue();                       // 打印当前队列
    void printRideHistory();                 // 打印历史记录
    void exportRideHistory(String filename);  // 导出历史记录到文件
    void importRideHistory(String filename);  // 从文件导入历史记录
    int numberOfVisitors();                  // 返回历史记录中的游客数量
}
