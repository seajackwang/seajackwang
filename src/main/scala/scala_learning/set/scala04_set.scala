package scala_learning.set

import scala.collection.mutable

/**
 * Author: laowang
 * Date: 20220319
 * Dese: set集合
 *      --无序集合，不可重复
 */
object scala04_set {
  def main(args: Array[String]): Unit = {
    //不可变set集合创建
    val set: Set[Int] = Set(1, 2, 3, 7, 12)
//    println(set)

    //操作:因为它是无序的,所以不可通过下标访问，而且添加符合不需要：+或者+：，直接+
//    set.foreach(println)
    //添加
    val newSet: Set[Int] = set.+(55)
//    println(newSet)

    //可变set集合创建
    val muSet: mutable.Set[Int] = mutable.Set(13, 4, 5, 9, 10)

    //操作
    muSet.add(23) //返回的是Boolean
    println(muSet)
    println(muSet.size)
    muSet.remove(23) //参数是要删的数据值，返回的是Boolean
    println(muSet)

  }
}
