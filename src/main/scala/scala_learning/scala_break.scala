package scala_learning

import scala.util.control.Breaks._

object scala_break {
  def main(args: Array[String]): Unit = {
    //break跳出循环
//    Breaks.breakable(
//      for (i <- 1 to 5){
//        if(i==3){
//          Breaks.break()
//        }
//        println(i)
//      }
//    )
    breakable(
      for (i <- 1 to 5){
        if(i==3){
          break()
        }
        println(i)
      }
    )

    println("循环外代码")
  }

}
