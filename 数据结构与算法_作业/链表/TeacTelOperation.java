package 数据结构与算法.数据结构与算法_作业.链表;

public interface TeacTelOperation { // 此接口定义了链表的数据操作 (运算)
    int getConuts(); // 获取记录的条数
    void add(TeacherTel node); // 在链表中添加一个教师电话信息记录，在不破坏原有容量的情况下且有序
    void listAll (); // 遍历链表中所有教师电话记录
    void search(int index); // 根据教师编号查找记录
    void search(String name); // 根据教师姓名查找记录
    void delete(int index); // 根据教师编号删除记录
    void delete(String name); // 根据教师姓名删除记录
}
