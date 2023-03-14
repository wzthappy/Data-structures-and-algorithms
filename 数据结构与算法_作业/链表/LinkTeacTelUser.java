package 数据结构与算法.数据结构与算法_作业.链表;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LinkTeacTelUser {
    public static void main(String[] args) throws IOException {
        // 创建链表结构
        TeacTelOperation linkTeacTel = new LinkTeacTel();

        // 输入流
        InputStreamReader inp = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(inp);
        while (true) {
            System.out.print("********** 教师电话管理系统 ***********\n");
            System.out.print("1. 增加记录\n");
            System.out.print("2. 显示所有教师信息\n");
            System.out.print("3. 根据教师编号查找\n");
            System.out.print("4. 获取教师电话信息个数\n");
            System.out.print("5. 根据教师编号删除记录\n");
            System.out.print("6. 增加姓名查找记录\n");
            System.out.print("7. 根据教师姓名删除记录\n");
            System.out.print("0. 退出\n");
            System.out.print("请输入您的选择编号: ");
            int choice = Integer.parseInt(br.readLine());
            switch (choice) {
                case 0:
                    System.exit(0);
                case 1:
                    System.out.print("请输入教师编号: ");
                    int teacNum = Integer.parseInt(br.readLine());
                    System.out.print("请输入教师姓名: ");
                    String teacName = br.readLine();
                    System.out.print("请输入教师的电话号码: ");
                    String teacTelphone = br.readLine();
                    TeacherTel teacnode = new TeacherTel(teacName, teacNum, teacTelphone);
                    linkTeacTel.add(teacnode);
                    System.out.println();
                    break;
                case 2:
                    linkTeacTel.listAll();
                    System.out.println();
                    break;
                case 3:
                    System.out.print("请输入教师编号: ");
                    int teacherNo = Integer.parseInt(br.readLine());
                    linkTeacTel.search(teacherNo);
                    System.out.println();
                    break;
                case 4:
                    System.out.print("教师电话记录个数为: " + linkTeacTel.getConuts() + "\n");
                    break;
                case 5:
                    System.out.print("请输入删除记录的教师编号: ");
                    int teacherId = Integer.parseInt(br.readLine());
                    linkTeacTel.delete(teacherId);
                    System.out.println();
                    break;
                case 6:
                    System.out.print("请输入要查询记录的教师姓名: ");
                    String name1 = br.readLine();
                    linkTeacTel.search(name1);
                    System.out.println();
                    break;
                case 7:
                    System.out.print("请输入要删除的教师姓名: ");
                    String name2 = br.readLine();
                    linkTeacTel.delete(name2);
                    System.out.println();
                    break;
            }
        }

//
//        // 创建结点
//        TeacherTel node1 = new TeacherTel("高毅", 23, "1223434");
//        TeacherTel node2 = new TeacherTel("阿飞", 12, "21321443");
//        TeacherTel node3 = new TeacherTel("杰哈德付款", 43, "1443534");
//        TeacherTel node4 = new TeacherTel("发生纠纷", 1, "134563");
//        // 添加结点
//        root.add(node1);
//        root.add(node2);
//        root.add(node3);
//        root.add(node4);
//        // 打印所有结点
//        System.out.println("------------- 打印所有结点 -----------");
//        root.listAll();
//        root.getConuts();
//
//        // 根据编号删除节点
//        System.out.println("\n------------ 删除23号结点 ------------");
//        root.delete(23);
//        root.listAll();
//        root.getConuts();
//
//        // 根据姓名查找
//        System.out.println("\n------------ 查找姓名为杰哈德付款的结点 ------------");
//        root.search("杰哈德付款");
    }
}
