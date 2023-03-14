package 数据结构与算法.栈.逆波兰计算器_后缀表达式.中缀表达式转后缀表达式;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InfixTurnSuffix {
  // 完成将一个中缀表达式转成后缀表达式的功能
  // 说明
  // 1. 1+((2+3)*4)-5 => 转成 1 2 3 + 4 * + 5 -
  // 2. 因为直接对str 进行操作，不方便，因此 现将 "1+((2+3)*4)-5" => 中缀的表达式对应的List
  //        即 "1+((2+3)*4)-5" => ArrayList [1, +, (, (, 2, +, 3, ), *, 4, ), -, 5]
  // 3. 将得到的中缀表达式对应的List => 后缀表达式对应的List
  //        即 ArrayList [1, +, (, (, 2, +, 3, ), *, 4, ), -, 5] => ArrayList [1 2 3 + 4 * + 5 -]

  // 方法: 将 中缀表达式转成对应的List               s = "1+((2+3)*4)-5"
  public static List<String> toInfixExpressionList(String s) {
    // 定义一个List，存放中缀表达式 对应的内容
    List<String> ls = new ArrayList<String>();
    int i = 0;  // 这个是一个指针，用于遍历 中缀表达式字符串
    String str; // 对多位数的拼接
    char c;  // 每遍历到一个字符，就放入到c
    do {
      // 如果c是一个非数字，就需要加入到ls
      if ((c = s.charAt(i)) < 48 || (c = s.charAt(i)) > 57) {
        ls.add("" + c);
        i++; // i需要后移
      } else {  // 如果是一个数，需要考虑多位数
        str = ""; // 先将str 置成""  '0'[48] -> '9'[57]
        while (i < s.length() && (c = s.charAt(i)) >= 48 && (c = s.charAt(i)) <= 57) {
          str += c;  // 拼接
          i++;
        }
        ls.add(str);
      }
    } while (i < s.length());
    return ls;
  }

  // 即 ArrayList [1, +, (, (, 2, +, 3, ), *, 4, ), -, 5] => ArrayList [1 2 3 + 4 * + 5 -]
  // 方法: 将得到的中缀表达式对应的List => 后缀表达式对应的List
  public static List<String> parseSuffixExpressionList(List<String> ls) {
    // 定义两个栈
    Stack<String> s1 = new Stack<String>();  // 符号栈
    // 说明: 因为s2这个栈，在整个转换过程中，没有pop操作，而且我们还需要逆序输出
    // 因此比较麻烦，这里我们就不用 Stack<String> 直接使用 List<String> s2
//    Stack<String> s2 = new Stack<String>();  // 存储中间结果的栈s2
    List<String> s2 = new ArrayList<String>();  // 存储中间结果的Lists2

    // 变量ls
    for (String item : ls) {
      // 如果是一个数，加入s2
      if (item.matches("\\d+")) {
        s2.add(item);
      } else if (item.equals("(")) {
        s1.push(item);
      } else if (item.equals(")")) {
        // 如果是右括号")"，则依次弹出s1栈顶的运算符，并压入s2，直到遇到左括号为止，此时将这一对括号丢弃
        while (!s1.peek().equals("(")) {
          s2.add(s1.pop());
        }
        s1.pop();  // !!! 将 ( 弹出 s1 栈，消除小括号
      } else {
        // 当item的优先级小于等于s1栈顶运算符，将s1栈顶的运算符弹出并加入到s2中，在次转到(4.1)与s1中新的栈顶运算符相比较
        // 问题: 我们缺少一个比较优先级高低的方法
        while (s1.size() != 0 && Operation.getValue(s1.peek()) >= Operation.getValue(item)) {
          s2.add(s1.pop());
        }
        // 还需要将item压入栈
        s1.push(item);
      }
    }
    // 将s1中剩余的运算符依次弹出并加入s2
    while (s1.size() != 0) {
      s2.add(s1.pop());
    }
    return s2;  // 注意因为是存放到List，因此按顺序输出就是对应的后缀表达式对应的List
  }
}
