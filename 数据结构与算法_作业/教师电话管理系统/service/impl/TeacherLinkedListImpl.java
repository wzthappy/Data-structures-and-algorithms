package 数据结构与算法.数据结构与算法_作业.教师电话管理系统.service.impl;

import 数据结构与算法.数据结构与算法_作业.教师电话管理系统.pojo.Teacher;
import 数据结构与算法.数据结构与算法_作业.教师电话管理系统.service.TeacherLinkedList;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author happy
 * 教师 服务实现类
 */
public class TeacherLinkedListImpl implements TeacherLinkedList {
  Teacher headTeacherNode = new Teacher();
  volatile Integer count = 0;

  @Override
  public int teacherAdd(Teacher t) {
    try {
      Teacher auxiliaryNode = headTeacherNode;
      while (auxiliaryNode != null && auxiliaryNode.getRightThread() != null) {
        auxiliaryNode = auxiliaryNode.getRightThread(); // 后移
      }
      assert auxiliaryNode != null;
      auxiliaryNode.setRightThread(t);
      t.setLeftThread(auxiliaryNode);

      headTeacherNode.setLastNode(t); // 头指向最后一个结点
      count++;
      return 1;
    } catch (Exception e) {
      e.printStackTrace();
      return 0;
    }
  }

  @Override
  public int teacherDel(String jobNo) {
    try {
      Teacher auxiliaryNode = headTeacherNode;
      if (auxiliaryNode.getRightThread() == null) {
        System.err.println("列表为空!");
        return 0;
      }
      while (auxiliaryNode.getRightThread() != null && !auxiliaryNode.getRightThread().getJobNo().equals(jobNo)) {
        auxiliaryNode = auxiliaryNode.getRightThread();
      }
      if (auxiliaryNode.getRightThread() == null) {
        System.err.println("请输入正确的教师工号!");
        return 0;
      }

      if (headTeacherNode.getLastNode().getJobNo().equals(jobNo)) {
        headTeacherNode.setLastNode(headTeacherNode.getLastNode().getLeftThread());
        if (auxiliaryNode.getRightThread().getRightThread() == null) {
          auxiliaryNode.getRightThread().setLeftThread(null);
          auxiliaryNode.setRightThread(null);
          count--;
          return 1;
        }
      }

      auxiliaryNode.getRightThread().getRightThread().setLeftThread(auxiliaryNode);
      auxiliaryNode.setRightThread(auxiliaryNode.getRightThread().getRightThread());
      count--;
      return 1;
    } catch (Exception e) {
      e.printStackTrace();
      return 0;
    }
  }

  @Override
  public Teacher queryOnThread(String jobNo) {
    Teacher auxiliaryNode = headTeacherNode;
    if (auxiliaryNode.getRightThread() == null) {
      System.err.println("链表为空!");
      return null;
    }
    while (!auxiliaryNode.getRightThread().getJobNo().equals(jobNo)) {
      auxiliaryNode = auxiliaryNode.getRightThread();
      if (auxiliaryNode == null) {
        System.err.println("没有对应工号的教师!");
        return null;
      }
    }

    return auxiliaryNode.getRightThread();
  }

  @Override
  public Teacher queryHead() {
    return headTeacherNode;
  }

  @Override
  public void sortByAge() {
    List<Integer> list = new ArrayList<>();
    Teacher auxiliaryNode = headTeacherNode;
    Teacher newauxiliaryNode = new Teacher();
    while (auxiliaryNode.getRightThread() != null) {
      auxiliaryNode = auxiliaryNode.getRightThread();
      list.add(auxiliaryNode.getAge());
    }
    list.sort(Comparator.comparingInt(i -> i));

    for (int i = 0; i < list.size(); i++) {
      Teacher auxiliaryNode11 = headTeacherNode.getRightThread();
      while (auxiliaryNode11.getAge() != list.get(i)) {
        auxiliaryNode11 = auxiliaryNode11.getRightThread();
      }

      Teacher t = new Teacher().setJobNo(auxiliaryNode11.getJobNo()).setName(auxiliaryNode11.getName())
          .setGender(auxiliaryNode11.getGender()).setAge(auxiliaryNode11.getAge())
          .setTelephoneNo(auxiliaryNode11.getTelephoneNo())
          .setPersonalInformation(auxiliaryNode11.getPersonalInformation());

      try {
        auxiliaryNode = newauxiliaryNode;
        while (auxiliaryNode != null && auxiliaryNode.getRightThread() != null) {
          auxiliaryNode = auxiliaryNode.getRightThread(); // 后移
        }
        assert auxiliaryNode != null;
        auxiliaryNode.setRightThread(t);
        t.setLeftThread(auxiliaryNode);

        headTeacherNode.setLastNode(t); // 头指向最后一个结点
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

    headTeacherNode = newauxiliaryNode;
  }
}
