package 数据结构与算法.链表.双向链表的实现;

public class DoubleLinkedListDemo {
  public static void main(String[] args) {
    // 测试
    System.out.println("双向列表的测试");
    // 先创建节点
    HeroNode hero2 = new HeroNode(2, "喜喜", "html");
    HeroNode hero3 = new HeroNode(3, "多多", "c/c++");
    HeroNode hero1 = new HeroNode(1, "卡卡", "java");
    HeroNode hero4 = new HeroNode(4, "羽羽", "mySQL");
    // 创建一个双向链表对象
    DoubleListedList doubleListedList = new DoubleListedList();
    doubleListedList.add(hero1);
    doubleListedList.add(hero2);
    doubleListedList.add(hero3);
    doubleListedList.add(hero4);

    doubleListedList.list();

    // 修改
    HeroNode hero5 = new HeroNode(3, "坎坎坷坷快快快", "网络");
    doubleListedList.update(hero5);
    System.out.println("修改后的列表情况");
    doubleListedList.list();

    // 删除
    doubleListedList.del(2);
    System.out.println("删除后列表的情况");
    doubleListedList.list();
  }
}
