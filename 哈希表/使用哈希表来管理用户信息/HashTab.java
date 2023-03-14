package 数据结构与算法.哈希表.使用哈希表来管理用户信息;

/**
 * 创建HashTab 管理多条链表
 */
public class HashTab {
  private EmpLinkedList[] empLinkedListsArray;
  private int size;  // 表示有多少条链表

  // 构造器
  public HashTab(int size) {
    this.size = size;
    // 初始化 empLinkedListsArray
    empLinkedListsArray = new EmpLinkedList[size];
    // 这时不要忘了分别初始化每个列表
    for (int i = 0; i < size; i++) {
      empLinkedListsArray[i] = new EmpLinkedList();
    }
  }

  // 添加用户
  public void add(Emp emp) {
    // 根据用户的id，得到应该添加到哪条链表
    int empLinkedListNo = hashFun(emp.id);
    // 将emp 添加到对应的列表中
    empLinkedListsArray[empLinkedListNo].add(emp);
  }

  // 遍历所有的链表，遍历哈希表
  public void list() {
    for (int i = 0; i < size; i++) {
      empLinkedListsArray[i].list(i);
    }
  }

  // 根据输入的id，查找用户
  public void findEmpById(int id) {
    // 使用散列函数确定到那条链表查找
    int empLinkedListNo = hashFun(id);
    Emp emp = empLinkedListsArray[empLinkedListNo].findFmpById(id);
    if (emp != null) {  // 找到
      System.out.printf("在第%d条链表中找到 用户 id=%d，name=%s\n", empLinkedListNo + 1, id, emp.name);
    } else {
      System.out.println("在哈希表中没有找到该用户");
    }
  }
  // 根据输入的id，删除用户
  public void delete(int id) {
    int empLinkedListNo = hashFun(id);
    empLinkedListsArray[empLinkedListNo].delete(id);
  }

  // 编写散列函数，使用一个简单取模法
  public int hashFun(int id) {
    return id % size;
  }
}
