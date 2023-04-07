package 数据结构与算法.算法系统练习.力扣;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组nums1 和nums2。请你找出并返回这两个正序数组的 中位数 。
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 * 示例 1：
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * 示例 2：
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 */
public class _4_寻找两个正序数组的中位数据 {
  public static void main(String[] args) {

  }

  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int m = nums1.length;
    int n = nums2.length;
    int left = (m + n + 1) / 2;
    int right = (m + n + 2) / 2;
    return (findKth(nums1, 0, nums2, 0, left) + findKth(nums1, 0, nums2, 0, right)) / 2.0;
  }

  //i: nums1的起始位置 j: nums2的起始位置
  public int findKth(int[] nums1, int i, int[] nums2, int j, int k){
    if( i >= nums1.length) return nums2[j + k - 1];//nums1为空数组
    if( j >= nums2.length) return nums1[i + k - 1];//nums2为空数组
    if(k == 1){
      return Math.min(nums1[i], nums2[j]);
    }
    int midVal1 = (i + k / 2 - 1 < nums1.length) ? nums1[i + k / 2 - 1] : Integer.MAX_VALUE;
    int midVal2 = (j + k / 2 - 1 < nums2.length) ? nums2[j + k / 2 - 1] : Integer.MAX_VALUE;
    if(midVal1 < midVal2){
      return findKth(nums1, i + k / 2, nums2, j , k - k / 2);
    }else{
      return findKth(nums1, i, nums2, j + k / 2 , k - k / 2);
    }
  }
}
