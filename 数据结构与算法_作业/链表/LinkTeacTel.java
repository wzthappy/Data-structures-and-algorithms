package 数据结构与算法.数据结构与算法_作业.链表;

public class LinkTeacTel implements TeacTelOperation { // 实现接口中所有的操作
    private TeacherTel head; // 链表的表头
    private int count; // 记录数计数器

    // 构造方法 创建一个空链表
    public LinkTeacTel() {
        head = null;
        count = 0;
        head = new TeacherTel();
    }

    @Override
    public int getConuts() { // 获取记录的条数
        return count;
    }

    @Override
    public void add(TeacherTel node) { // 在链表中添加一个教师电话信息记录，在不破坏原有容量的情况下且有序
        TeacherTel prior = head, current = head;
        if (head == null) { // 空表
            head = node;
        } else { // 非空表添加记录，寻找插入的位置
            while (current != null) { // 寻找的位置
                if (node.getTeacherNo() < current.getTeacherNo()) { // 查找node的插入位置，将node插入到current之前
                    break;
                }
                prior = current;
                current = current.getNext();
            }
            // 插入节点
            if (current == head) { // 在表头节点前插入node
                node.setNext(head);
                head = node;
            } else { // 在表中或表尾插入node
                prior.setNext(node);
                node.setNext(current);
            }
        }
        count++;
    }

    @Override
    public void listAll() { // 遍历链表中所有教师电话记录
        TeacherTel current = head.getNext();
        while (current != null) {
            System.out.println(current);
            current = current.getNext();
        }
        System.out.println("-------------- 共有记录 " + count + " 条 ------------");
    }

    @Override
    public void search(int teacherNo) { // 根据教师编号查找记录
        int flag = 0;
        TeacherTel current = head;
        while (current != null) {
            if (teacherNo == current.getTeacherNo()) {
                System.out.println("您要找找的教师信息为: " + current);
                flag = 1;
                break;
            }
            current = current.getNext();
        }
        if (flag == 0) System.out.println("输入编号无效!");
    }

    @Override
    public void search(String name) { // 根据教师姓名查找记录
        int flag = 0;
        TeacherTel current = head.getNext();
        while (current != null) {
            if (current.getName().equals(name)) {
                System.out.println("您要找找的教师信息为: " + current);
                flag = 1;
//                break;   // 因为有重名的情况
            }
            current = current.getNext();
        }
        if (flag == 0) System.out.println("查无此人!");
    }

    @Override
    public void delete(int teacherNo) { // 根据教师编号删除记录
        TeacherTel pre = null;
        TeacherTel current = head;
        pre = current;
        int flag = 0;
        while (current != null) {
            if (current.getTeacherNo() == teacherNo) {
                flag = 1;
                if (current == head) {
                    head = current.getNext();
                } else {
                    pre.setNext(current.getNext());
                }
            }
            pre = current;
            current = current.getNext();
        }

        if (flag == 0) System.out.println("查无此人");
        else System.out.println("按编号删除成功");
        count--;
    }

    @Override
    public void delete(String name) { // 根据教师姓名删除记录
        TeacherTel pre = null;
        TeacherTel current = head;
        pre = current;
        int flag = 0;
        while (current != null) {
            if (name.equals(current.getName())) {
                flag = 1;
                if (current == head) {
                    head = current.getNext();
                } else {
                    pre.setNext(current.getNext());
                }
            }
            pre = current;
            current = current.getNext();
        }

        if (flag == 0) System.out.println("查无此人");
        else System.out.println("按姓名删除成功");
        count--;
    }
}
