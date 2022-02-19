package scala_learning

import scala.io.StdIn

object scala01_if {

  def main(args: Array[String]): Unit = {
    println("请输入年龄：")
    val age: Int = StdIn.readInt()
    if (age < 18) {
      println("未成年人")
    } else if (age >= 18 && age < 30) {
      println("中年人 ")
    } else {
      println("big baby")
    }
  }

}
