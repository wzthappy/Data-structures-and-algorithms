package 数据结构与算法.数据结构与算法_作业.教师电话管理系统.service;

import 数据结构与算法.数据结构与算法_作业.教师电话管理系统.pojo.Teacher;

/**
 * @author happy
 * 教师的功能 接口
 */
public interface TeacherLinkedList {
  int teacherAdd(Teacher t); // 添加教师   1 成功   0 失败
  int teacherDel(String jobNo); // 根据工号删除
  Teacher queryOnThread(String jobNo); // 根据工号查询教师
  Teacher queryHead(); // 查询链表头 所有

  void sortByAge(); // 按年龄排序
}
