package scala_learning

/**
 * Author: laowang
 * Date: 20220220
 * Dese:控制抽象
 *    --值调用：
 *      将函数计算的值进行传递
 *    --名调用：
 *      传递的是代码块
 */
object scala_ControlAbstract {
  def main(args: Array[String]): Unit = {
    //值调用
//    def foo(a:Int):Unit={
//      println(a)
//      println(a)
//    }
//    def f1():Int={
//      println("f....")
//      10
//    }
//    foo(f1())


    //名调用:传给a的是代码块：
      // {
      //      println("f....")
      //      10
      //    }
    def foo(a: =>Int):Unit={
      println(a)
      println(a)
    }
    def f1():Int={
      println("f....")
      10
    }
    foo(f1())

  }

}
