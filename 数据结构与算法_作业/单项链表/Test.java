package 数据结构与算法.数据结构与算法_作业.单项链表;

public class Test {
    public static void main(String[] args) throws Exception {
        System.out.println("请输入学生姓名: ");
        LinkList l = new LinkList(8);
        System.out.println("1班学生姓名: --------- 原始数据");
        l.display();
        System.out.println("班级人数: " + l.length());
        String s1 = "a6";
        System.out.println(s1 + "在链表中的位序号: " + l.indexOf(s1));
        String s2 = "a3";
        String s3 = "我是添加进去的";

        System.out.println("---------- 添加一个 ---------");
        l.insert(l.indexOf(s2) + 1, s3);
        l.display();

        System.out.println("---------- 删除a6 -----------");
        l.remove(l.indexOf("a6"));
        System.out.println();
        l.display();
        System.out.println();

        System.out.println("-------- 置空 --------");
        l.clear();
        l.display();
        System.out.println(" 判断是否为空 " + l.isEmpty());
    }
}
