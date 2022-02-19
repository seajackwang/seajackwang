package scala_learning

/**
 * Author: shuipwang
 * Desc:scala数据类型 默认有隐式转换
 * Date: 20220116
 */
object scala06_DateType {
  def main(args:Array[String]):Unit={
    val a:Byte = 10
    val b:Byte = -128

    val c:Int = a + b
    println(a +"\n"+ b+"\n" + c)
    println(b)
    println(a)

  }


}
