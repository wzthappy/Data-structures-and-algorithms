package 数据结构与算法.算法系统练习.面试算法;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 *                              LRU缓存机制
 *  LRU 是(Least Recently Used)的缩写，即最近最少使用，是一种常用的页面置换算法，
 *
 *      选择最近最久未使用的数据赋予淘汰
 *
 * 要求:  O(1)的时间复杂度
 */
public class LRUCacheDemo01<K, V> extends LinkedHashMap<Integer, Integer> {
  private int capacity; // 缓存坑位

  public LRUCacheDemo01(int capacity) {
    // capacity是数组的大小 。0.75F是一个散列值。
    //      true 表示,如果put到了相同的key 会把这个key放到最右边
    super(capacity, 0.75F, true);
    this.capacity = capacity;
  }

  @Override
  protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
    return super.size() > capacity;  // 返回true  就开始删除  最左边的值
  }

  public int get (int key) {
    Integer value = super.get(key);
    super.put(key, value);
    return value;
  }

  public void put (int key, int value) {
    super.put(key, value);
  }

  public static void main(String[] args) {
    LRUCacheDemo01<Integer, Integer> lruCacheDemo = new LRUCacheDemo01<>(3);

    lruCacheDemo.put(1, 0);
    lruCacheDemo.put(2, 0);
    lruCacheDemo.put(3, 0);

    lruCacheDemo.get(2);
    System.out.println(lruCacheDemo.keySet());

    lruCacheDemo.put(4, 0);

    System.out.println(lruCacheDemo.keySet());

    lruCacheDemo.put(3, 0);
    System.out.println(lruCacheDemo.keySet());
  }
}
