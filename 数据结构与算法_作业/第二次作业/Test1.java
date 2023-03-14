package 数据结构与算法.数据结构与算法_作业.第二次作业;

import java.util.Scanner;

/**
 * 2 设线性表存于数组a[0.. n-1]的前R个分量中，且递增有序，试写一算法，
 * 将x插入到线性表的适当位置上，以保持线性表的有序性。
 * <p>
 * <p>
 * 3.试分别以不同的存储结构实现线性表的就地逆置算法，即在原表的存储空间将线性表（a1, a2, ..., an）逆置为（an, an-1, ..., a1）。
 * 就地逆置：（a1,a2,…,an)逆置为(an,…,a2,a1)
 * <p>
 * 4. 试编写在带头结点的单链表中删除一个最小值结点的算法。
 */
public class Test1 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Linked[] obj = new Linked[6];  // 线性表存于数组
    obj[2] = new Linked(); // 在下标为2的数组中添加 线性表

    Node node1 = new Node(23, "卡卡", "32");
    Node node2 = new Node(121322, "否否", "232");
    Node node3 = new Node(1, "dadsa", "232");
    Node node4 = new Node(123, "12323", "232");

    // 添加结点
    obj[2].add(node1);
    obj[2].add(node2);
    obj[2].add(node3);
    obj[2].add(node4);

    // 遍历
    System.out.println("-------- 遍历 -------");
    obj[2].l();

    // 逆序遍历
    System.out.println("------ 逆序存储 ------");
    obj[2].r();
    System.out.println("------- 遍历 -------");
    obj[2].l();

//    boolean flag = true;
    while (true) {
      // 删除结点
      System.out.println("--------- 请输入要删除id结点的id: --------- 注: 输入-1退出删除 ");
      int i = Integer.parseInt(sc.nextLine());
      if (i == -1)   // flag = false;
        System.exit(0);
      obj[2].rm(i);

      System.out.println("------ 删除后的结果 ------");
      obj[2].l();
    }
  }
}

class Node {
  // 数据域
  Integer id = null;
  private String name = null;
  private String age = null;
  // 指针域
  private Node right = null;
  private Node left = null;

  public Node() {
  }

  public Node(Integer id, String name, String age) {
    this.id = id;
    this.name = name;
    this.age = age;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAge() {
    return age;
  }

  public void setAge(String age) {
    this.age = age;
  }

  public Node getRight() {
    return right;
  }

  public void setRight(Node right) {
    this.right = right;
  }

  public Node getLeft() {
    return left;
  }

  public void setLeft(Node left) {
    this.left = left;
  }

  // 先增对象
  public void add(Node node, boolean flag) {  // true 正序添加   false 逆序添加
    if (this.getRight() == null) {  // 要插入的内容到了尾部
      this.setRight(node);
      node.setLeft(this);
      return;
    }

    if (flag) {
      if (this.getRight().getId() > node.id) { // 向他前面插入
        node.setRight(this.getRight());
        node.setLeft(this);
        this.getRight().setLeft(node);
        this.setRight(node);
      } else this.getRight().add(node, true);
    } else {
      if (this.getRight().getId() < node.id) { // 逆序添加
        node.setRight(this.getRight());
        node.setLeft(this);
        this.getRight().setLeft(node);
        this.setRight(node);
      } else this.getRight().add(node, false);
    }
  }

  // 通过id删除结点
  public void rm(int id) {
    if (this.getRight().id == id) {  // 删除当前结点的下一个结点
      if (this.getRight().getRight() == null) { // 删除的是最后一个结点
        this.getRight().setLeft(null);
        this.setRight(null);
      } else {
        this.getRight().getRight().setLeft(this);
        this.setRight(this.getRight().getRight());
      }
      return;
    }
    this.getRight().rm(id);
  }

  // 遍历
  public void l() {
    System.out.println(this);
    if (this.getRight() != null) {
      this.getRight().l();
    }
  }

  // 逆序存储
  public Node r() {
    Node root = this;
    Node j = new Node();
    while (root != null) {
      j.add(new Node(root.getId(), root.getName(), root.getAge()), false);
      root = root.getRight();
    }
    return j;
  }


  @Override
  public String toString() {
    return "Node{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", age='" + age + '\'' +
        '}';
  }
}

class Linked {
  // 头结点
  Node root = null;

  public Linked() {
    root = new Node();
  }

  // 添加
  public void add(Node node) {
    if (root != null) root.add(node, true);
  }

  // 通过id删除结点
  public void rm(int id) {
    root.rm(id);
  }

  // 遍历
  public void l() {
    if (root.getRight() != null) root.getRight().l();
    else System.out.println("链表为空！");
  }

  // 逆序存储
  public void r() {
    root = root.getRight().r();
  }
}