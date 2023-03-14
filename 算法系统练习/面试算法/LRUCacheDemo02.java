package 数据结构与算法.算法系统练习.面试算法;

import java.util.HashMap;
import java.util.Map;

/**
 * LRU缓存机制
 * LRU 是(Least Recently Used)的缩写，即最近最少使用，是一种常用的页面置换算法，
 * <p>
 * 选择最近最久未使用的数据赋予淘汰
 * <p>
 * 要求:  O(1)的时间复杂度   不能使用 LinkedHashMap 类
 */
public class LRUCacheDemo02 {
  // map 负责查找，构建一个虚拟的双向链表，他里面安装的就是一个个Node结点，作为数据载体。

  // 1. 构造一个Node结点，作为数据载体
  class Node<K, V> {
    K key;
    V value;
    Node<K, V> prev;
    Node<K, V> next;

    public Node() {
      this.prev = this.next = null;
    }

    public Node(K key, V value) {
      this.key = key;
      this.value = value;
      this.prev = this.next = null;
    }
  }

  // 2.  构建一个虚拟的双向链表。构造一个双向队列，里面安装的就是我们的Node
  class DoubleLinkedList<K, V> {
    Node<K, V> head;
    Node<K, V> tail;

    // 2.1 构造方法
    public DoubleLinkedList() {
      head = new Node<>();
      tail = new Node<>();
      head.next = tail;
      tail.prev = head;
    }

    // 2.2 添加到头
    public void addHead(Node<K, V> node) {
      node.next = head.next;
      node.prev = head;
      head.next.prev = node;
      head.next = node;
    }

    // 2.3 删除结点
    public void removeNode(Node<K, V> node) {
      node.next.prev = node.prev;
      node.prev.next = node.next;
      node.prev = null;
      node.next = null;
    }

    // 2.4 获得最后一个结点
    public Node getLast() {
      return tail.prev;
    }
  }

  private int cacheSize;

  Map<Integer, Node<Integer, Integer>> map;
  DoubleLinkedList<Integer, Integer> doubleLinkedList;

  public LRUCacheDemo02(int cacheSize) {
    this.cacheSize = cacheSize; // 坑位
    map = new HashMap<>();
    doubleLinkedList = new DoubleLinkedList<>();
  }

  public int get(int key) {
    if (!map.containsKey(key)) {
      return -1;
    }
    Node<Integer, Integer> node = map.get(key);
    doubleLinkedList.removeNode(node);
    doubleLinkedList.addHead(node);
    return node.value;
  }

  public void put(int key, int value) {
    if (map.containsKey(key)) {
      Node<Integer, Integer> node = map.get(key);
      node.value = value;
      map.put(key, node);

      doubleLinkedList.removeNode(node);
      doubleLinkedList.addHead(node);
    } else {
      if (map.size() == cacheSize) { // 坑位满了
        Node<Integer, Integer> lastNode = doubleLinkedList.getLast();
        map.remove(lastNode.key);
        doubleLinkedList.removeNode(lastNode);
      }
      // 正常新增
      Node<Integer, Integer> newNode = new Node<>(key, value);
      map.put(key, newNode);
      doubleLinkedList.addHead(newNode);
    }
  }

  public static void main(String[] args) {
    LRUCacheDemo02 lruCacheDemo = new LRUCacheDemo02(3);

    lruCacheDemo.put(1, 0);
    lruCacheDemo.put(2, 0);
    lruCacheDemo.put(3, 0);

    lruCacheDemo.get(2);
    System.out.println(lruCacheDemo.map.keySet());

    lruCacheDemo.put(4, 0);

    System.out.println(lruCacheDemo.map.keySet());

    lruCacheDemo.put(3, 0);
    System.out.println(lruCacheDemo.map.keySet());
  }
}
