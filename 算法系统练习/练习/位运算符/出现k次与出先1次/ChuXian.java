package 数据结构与算法.算法系统练习.练习.位运算符.出现k次与出先1次;

/**
 * 数组中只有一个数出现了1次，其他的数都出现了k次，请输出只出现了1次的数
 *
 *    k个相同的k进制数做不进位加法，结果为0
 */
public class ChuXian {
  public static void main(String[] args) {
    int[] arr = {2, 2, 2, 9, 7, 7, 7, 3 , 3, 3, 6, 6, 6, 0, 0, 0};
    int len = arr.length;
    char[][] kRadix = new char[len][];
    int k = 3;
    // 转换成进制字符数组
    int maxLen = 0;
    // 对于每个数字
    for (int i = 0; i < len; i++) {
      // 求每个数字的三进制字符串并反转，然后转为字符数组
      kRadix[i] = new StringBuilder(Integer.toString(arr[i], k)).reverse().toString().toCharArray();
      if (kRadix[i].length > maxLen) {
        maxLen = kRadix[i].length;
      }
    }
    int[] resAll = new int[maxLen];
    for (int i = 0; i < len; i++) {
      // 不进位加法
      for (int j = 0; j < maxLen; j++) {
        if (j >= kRadix[i].length) {
          resAll[j] += 0;
        } else {
          resAll[j] += kRadix[i][j] - '0';
        }
      }
    }

    int res = 0;
    for (int i = 0; i < maxLen; i++) {
      res += (resAll[i] % k) * (int)(Math.pow(k, i));  // pow(k, i)  =>  k 的 i 次方
    }
    System.out.println(res);
  }
}
