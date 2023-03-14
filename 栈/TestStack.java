package 数据结构与算法.栈;

import java.util.Stack;

// 演示栈Stack的基本使用
public class TestStack {
  public static void main(String[] args) {
    Stack<String> stack = new Stack<>();
    // 入栈
    stack.add("jack");
    stack.add("tom");
    stack.add("smitn");
    // 出栈
    while (stack.size() > 0) {
      System.out.println(stack.pop());  // pop就是将栈顶的数据取出
    }
  }
}
