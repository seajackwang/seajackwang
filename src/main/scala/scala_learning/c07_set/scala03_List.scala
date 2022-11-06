package scala_learning.c07_set

import scala.collection.mutable.ListBuffer

/**
 * Author: laowang
 * Date: 20220319
 * Dese: seq集合list
 *    --有序集合，可重复
 *    --scala中list是一个对象，而在java中是接口
 *    --1不可变list集合:List
 *    --2可变list集合:ListBuffer
 */
object scala03_List {
  def main(args: Array[String]): Unit = {
    //1、不可变list集合，是抽象对象，不能实例化对象，使用apply方法创建
    val list: List[Int] = List(1, 2, 3, 4, 5, 6, 7)
//    println(list)
    //操作:访问、添加元素,不能删除修改
//    println(list(1))
    val newList: List[Int] = list.:+(100)
    val newList2: List[Int] = list.+:(99)
//    println(list)
//    println(newList)
//    println(newList2)

    //scala中，List()==> Nil表示空集合,空集合中添加元素使用 ：：
    val list2 = List(4, 5, 6, 8, 9, 10)
    val listany: List[Any] = list :: list2 //向lsit2中添加lsit
//    println(listany)
//    listany.foreach(println)
    //扁平化，使用 ：：：
    val listflat: List[Int] = list2 ::: list
//    println(listflat)
//    listflat.foreach(println)


    //2、可变list集合
//    val listBuf: ListBuffer[Int] = new ListBuffer[Int]()

    val listBuf: ListBuffer[Int] = ListBuffer(1, 2, 3, 4)
//    println(listBuf)
    //操作:访问、添加元素、删除、修改
    //访问、添加元素
//    println(listBuf(0))
//    listBuf.append(25)
//    listBuf.insert(2,66)
//    println(listBuf)
    //删除、修改
//    listBuf(0) = 11

    listBuf.remove(0) //参数是集合的下标
//    listBuf.remove(0,2)
    println(listBuf)

  }

}
