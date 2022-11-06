package scala_learning.c07_set

import scala.collection.{immutable, mutable}

/**
 * Author: laowang
 * Date: 20220319
 * Dese: 队列和并行
 *
 */
object scala_TestQue {
  def main(args: Array[String]): Unit = {
    //队列Que,先进先出，后进后出。（一进一出，一个循环）
    val que: mutable.Queue[String] = new mutable.Queue[String]()
    que.enqueue("a","bb","jj")
    println(que.dequeue())
    println(que.dequeue())
    println(que.dequeue())

    //并行：利用cpu多核提供效率 方法par
    val res1: immutable.IndexedSeq[String] = (0 to 20).map { case _ => Thread.currentThread.getName }
    val res2 = (0 to 20).par.map { case _ => Thread.currentThread.getName }
    println(res2)
    println(res2.distinct)
  }

}
