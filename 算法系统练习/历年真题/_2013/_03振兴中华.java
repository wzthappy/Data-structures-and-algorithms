package 数据结构与算法.算法系统练习.历年真题._2013;

/**
 * 标题: 振兴中华
 *    小明参加了学校的趣味运动会，其中的一个项目是: 跳格子。
 *    地上画着一些格子，每个格子里写一个字，如下所示: (也可参见p1.jpg)
 *
 *  从我做起振
 *  我做起振兴
 *  做起振兴中
 *  起振兴中化
 *
 *     比赛中，先站在左上角的写着"从"字的格子里，可以横向或纵向跳到相邻的格子里，但不能跳到对角的格子或其他位置。直到跳到"化"字结束。
 *     要求跳过的路线刚好构成"从我做起振兴中华"这句话。
 *     请你帮助小明算一算他一共有多少种可能的跳跃路线呢?
 *
 *  答案是一个整数，提交这个整数
 */
public class _03振兴中华 {
  public static void main(String[] args) {
    f(0, 0);
    System.out.println(f1(0, 0));
    System.out.println(count);
  }

  private static int f1(int i, int j) {
    if (i == 3 || j == 4) return 1;
    return f1(i + 1, j) + f1(i, j + 1);
  }

  static int count = 0;
  private static void f(int i, int j) {
    if (i == 4 && j  == 3) {
      count++;
      return;
    }
    if(i < 4) {
      f(i + 1, j);
    }

    if (j < 3) {
      f(i, j + 1);
    }
  }
}
