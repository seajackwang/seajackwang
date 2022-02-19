package scala_learning
/**
 * Author: laowang
 * Date: 20220213
 * Dese:函数返回形式
 */

object scala_fun_02 {
  def main(args: Array[String]): Unit = {
    //01 无参无返回值
    def f1(): Unit ={
      println("无参无返回值")
    }
    f1()
    //02 无参有返回值
    def f2(): String={
      println("无参有返回值")
      return "jingjing"
    }

    println(f2())
    //03 有参无返回值
    def f3(name:String): Unit ={
      println(name)
    }
    println(f3("laowang"))
    //04 有参有返回值
    def f4(name:String): Int ={
      println(name)
      return 28
    }
    println(f4("laowang"))
    //05 多参无返回值
    def f5(name:String,age:Int): Unit ={
      println("you " + name + age)
    }
    println(f5("laowang",18))
    //06 多参有返回值
    def f6(name1:String,name2:String): String ={
      println("恭喜两位中了1000万！")
      return name1 + "和" + name2
    }
    println(f6("laowang","laozhang"))
  }

}
