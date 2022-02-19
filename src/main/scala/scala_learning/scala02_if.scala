package scala_learning

import scala.collection.immutable

object scala02_if {
  def main(args: Array[String]): Unit = {
    //循环守卫：加if判断实现
    //    for (i <- 1 to 10;if i%2 != 0){
    //      System.out.println("laowang"+i)
    //    }

    //循环步长 //to 底层是Range.inclusive(self, end)
    //    for (i <- 1 to 10 by 2){
    //      System.out.println(i)
    //    }
    //    for (j <- Range.inclusive(1,10)){
    //      System.out.println(j)
    //    }
    //循环嵌套
    //    for ( i <- 1 to 3){
    //      for ( j <- 1 to 3){
    //        println(i  + ":" + j)
    //      }
    //    }
    //循环引入变量
    //    for {
    //      i <- 1 to 5;
    //      j <- 1 to 3
    //    }{
    //      println(i  + ":" + j)
    //    }
    //循环返回值
    //val res: immutable.IndexedSeq[Int] = for (i <- 1 to 5) yield i * 2
    val res: immutable.IndexedSeq[Int] = for (i <- 1 to 5) yield {
      i * 2 - 1
    }
    println(res)

  }
}
