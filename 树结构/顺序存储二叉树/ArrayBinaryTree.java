package 数据结构与算法.树结构.顺序存储二叉树;

/**
 * 顺序顺序存储二叉树遍历
 */
public class ArrayBinaryTree {
  private int[] arr; // 存储数据结点的数组

  public ArrayBinaryTree(int[] arr) {
    this.arr = arr;
  }

  // 重载preOrder
  public void preOrder() {
    this.preOrder(0);
  }

  // 编写一个方法，完成顺序存储二叉树的前序遍历
  // index 表示数组的下标
  public void preOrder(int index) {
    // 如果数组为空，或者 arr.length = 0
    if (arr == null || arr.length == 0) {
      System.out.println("数组为空，不能按照二叉树的前序遍历");
      return;
    }
    // 输出当前这个元素
    System.out.println(arr[index]);
    // 向左递归遍历
    if (2 * index + 1 < arr.length) {
      preOrder(2 * index + 1);
    }
    // 向右递归遍历
    if (2 * index + 2 < arr.length) {
      preOrder(2 * index + 2);
    }
  }
}
