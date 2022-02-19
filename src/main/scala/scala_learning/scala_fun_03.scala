package scala_learning
/**
 * Author: laowang
 * Date: 20220213
 * Dese:函数参数
 */

object scala_fun_03 {
  def main(args: Array[String]): Unit = {
    //可变参数
    //注意：1参数列表中只能出现一个可变参数 2且可变参数只能放在最后
    def f(name:String,sex:String*): Unit ={
      println(name + sex)
    }
    println(f("jingjing","女"))
    println(f("jingjing","女博士"))

  }
}
