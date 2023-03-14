package 数据结构与算法.算法系统练习.历年真题._2013;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 标题: 世纪末的星期
 *   曾有邪教称1999年12月31日是世纪末日。当然该谣言已经不攻自破。
 *   还有人称今后的某个世纪的12月31日，如果是星期一则会...
 *   有趣的是，任何一个世纪末的年份的12月都不可能是星期一!!
 *   于是，"谣言制造商"又修改为星期日....
 *   1999年12月31日是星期五，
 *
 *   请问: 未来那一个离我们最近的一个世纪末年(即xx99年)的12月31日正好是星期天(即星期日)
 *
 *   请回答该年份(只写这个4位整数，不要写12月31的等多余信息)
 */
public class _01世纪末的星期 {
  public static void main(String[] args) {
    date_test1();
    date_test2();
  }

  private static void date_test1() {
    Calendar calendar = Calendar.getInstance();
    for (int year = 1999; year < 10000; year+= 100) {
      calendar.set(Calendar.YEAR, year);
      calendar.set(Calendar.MONTH, 11);  // 12月
      calendar.set(Calendar.DAY_OF_MONTH, 31);
      if (calendar.get(Calendar.DAY_OF_WEEK) == 1) {
        System.out.println(year);
        break;
      }
    }
  }

  private static void date_test2() {
    int d = 20;
    while (true) {
      String dataStr = d + "99/12/31";
      String e = new SimpleDateFormat("E").format(new Date(dataStr));
      if ("周日".equals(e)) {
        System.out.println(dataStr);
        return;
      }
      d++;
    }
  }
}
