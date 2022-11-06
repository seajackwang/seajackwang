package scala_suanfa_subject

/*
scala算法宝典之NO1
DESC:链表
01、Scala数据结构和算法：链表(Linked List)、单链表与双链表、链表介绍、单向链表、双向链表、环形链表、
环形链表解决Josephu问题。
02、链表介绍
链表是有序的列表，但是它在内存中是存储如下：
链表在内存中不一定是连续分布. [链表是学习 树，森林，图的基础]
// 链表的优点 1. 插入，删除，很快, 缺点是检索速度慢. =>  树结构(AVL, 红黑树)
*/

object head_table {
  /*
   reverse方法:就地逆序法
  方法功能：对链表进行逆序
  输入参数：链表头结点
   */

  def reverse(head:LNode_0):Unit={
    if(head == null || head.next == null || head.next.next == null) return
    var pre:LNode_0 = null //前驱结点
    var cur:LNode_0 = null //后驱节点
    var next:LNode_0 = null //后继节点

    //把链表首结点变成尾结点
    cur = head.next
    next = cur.next
    cur.next = null
    pre  = cur
    cur = next
    //处理当前节点
    while(cur.next != null){
      next =cur.next
      cur.next = pre
      pre = cur
      cur = next

    }
    //链表最后一个指向倒数第二个
    cur.next = pre
    head.next = cur
  }
  def main(args: Array[String]): Unit = {
    val head = new LNode_0
    head.next=null

    var tmp:LNode_0 = null
    var cur = head
    //构造单链表
    for(i <- 1 to 7){
      tmp = new LNode_0
      tmp.data = i
      tmp.next = null
      cur.next = tmp
      cur = tmp

    }
    print("逆序前：")
    cur = head.next
    while(cur!=null){
      print(cur.data + " ")
      cur = cur.next
    }
    reverse(head)
    println("")
    print("就地逆序法逆序后：")
    cur = head.next
    while(cur!=null){
      print(cur.data + " ")
      cur = cur.next
    }

  }

}
class LNode_0{
  var data:Int = _ //数据域 _可表示任何类型的空值
  var next:LNode_0 = _ //引用下一个结点
}
//case class Node[E](var next: Node[E], var data: E) {
//}
//type def struct LNode {
//int date;//数据域
//struct LNode *next;//指向下一个节点的指针，即指针域
//}LNode;

