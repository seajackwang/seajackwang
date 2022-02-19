package scala_learning

/**
 * Author: laowang
 * Date: 20220213
 * Dese:函数基本语法
 *
 * --函数和方法在Java中是一个意思；但在sala中它不一样
 * 函数和方法的区别：1定义在方法或者函数内部的叫函数，定义在类对象下的的叫方法；
 *    2方法是可以覆写 重载，函数不能
 */
object scala_fun {
  //定义一个方法
  def sayHi(name:String): String ={
    return "hello-->" + name
  }
  //方法重载
  def sayHi(age:Int): String ={
    return "hello-->" + age
  }
  //调用方法
  println(sayHi("laowang") + ",you are"+ sayHi(20))
  def main(args: Array[String]): Unit = {
    //定义一个函数
    def sayHi(name:String): String ={
      return "hello-->" + name
    }

    //调用函数
    println(sayHi("jingjing"))
  }

}
