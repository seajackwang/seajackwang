package scala_learning.c08_match

/**
 * Author: laowang
 * Date: 20220508
 * Dese: 样例类
 *      --特点：默认会帮我们创建伴生对象，以及apply、unapply、toString等常用方法
 */

case class Student(val name:String,val age:Int){}
object TestMatch05_caseClass {
  def main(args: Array[String]): Unit = {
    val std1: Student = Student("jingjing", 18)
    val res: String = std1 match {
      case Student("jingjing", 28) => "success"
      case _ => "fail"
    }
    println(res)
  }

}
