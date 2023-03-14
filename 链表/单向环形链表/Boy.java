package 数据结构与算法.链表.单向环形链表;

// 表示节点
public class Boy {
  private int no;  // 编号
  private Boy next;  // 指向下一个节点，默认null

  public Boy(int no) {
    this.no = no;
  }

  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
  }

  public Boy getNext() {
    return next;
  }

  public void setNext(Boy next) {
    this.next = next;
  }
}
