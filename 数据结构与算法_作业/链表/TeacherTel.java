package 数据结构与算法.数据结构与算法_作业.链表;

public class TeacherTel { // 定义链表中的数据元素类型
    // 属性定义
    private String name;  // 姓名
    private int teacherNo; // 编号
    private String telephone; // 电话

    private TeacherTel next; // 下一个老师

    // 构造方法
    public TeacherTel() {
    }

    public TeacherTel(String name, int teacherNo, String telephone) {
        this.name = name;
        this.teacherNo = teacherNo;
        this.telephone = telephone;
    }

    // 成员方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTeacherNo() {
        return teacherNo;
    }

    public void setTeacherNo(int teacherNo) {
        this.teacherNo = teacherNo;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public TeacherTel getNext() {
        return next;
    }

    public void setNext(TeacherTel node) {
        this.next = node;
    }

    @Override
    public String toString() {
        return "TeacherTel{" +
                "name='" + name + '\'' +
                ", teacherNo=" + teacherNo +
                ", telephone='" + telephone + '\'' +
                '}';
    }
}
