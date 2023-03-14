package 数据结构与算法.算法系统练习.练习.删除排序数组中的重复项;

/**
 * 一个有序数组nums，原地删除重复出现的元素，使每个元素只出现一次，返回删除后的数组的先长度
 *
 *    要求: 不能使用额外的数组空间，必须在原地修改输入数组并使用O(1)额外空间的条件下完成
 *      例: 输入: [0, 1, 2, 2, 3, 3, 4]
 *          输出: 5
 *
 *  重点考察: 双指针算法
 */
public class SortedArrayDuplicates {
  public static void main(String[] args) {
    System.out.println(removeDuplicates(new int[]{0, 1, 2, 2, 3, 3, 4}));
  }

  public static int removeDuplicates(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
    int i = 0;
    for (int j = 1; j < nums.length; j++) {
      if (nums[i] != nums[j]) {
        i++;
        nums[i] = nums[j];
      }
    }
    return i + 1;
  }
}
