package scala_learning

/**
 * Author: laowang
 * Date: 20220220
 * Dese: 自定义函数 实现while循环功能
 */
object scala_MyWhile {
  def main(args: Array[String]): Unit = {
    //while循环使用，分析结构
//    var n = 10
//    while (n >=1){
//      println(n)
//      n -= 1
//    }

//    while(循环条件)(循环体)
    //方法1：使用柯里化实现
    def Mywhile(condition: =>Boolean)(op: =>Unit):Unit={
      if (condition){
        op
        Mywhile(condition)(op)
      }
    }
    //实现
//    var n = 10
//    Mywhile(n>=1){
//      println("MyWhile-->>"+n)
//      n -= 1
//    }

    //方法2：直接普通函数实现
    //柯里化的第一个好处：将参数列表中的一个参数拆分成多个参数列表，这样参数代码清晰明确
    def MyWhile2(condition: =>Boolean,op: => Unit):Unit={
      if (condition){
        op
        MyWhile2(condition,op)
      }
    }
    //调用
//    var n = 10
//    MyWhile2(n>=1,{
//      println("MyWhile-->>"+n)
//      n -= 1
//    })

    //方法3：使用闭包的方式实现MyWhile
    //外层函数表示循环条件
    def MyWhile3(condition: =>Boolean):(=>Unit) =>Unit={
      //内层函数表示循环体
      def ff(op: =>Unit):Unit={
        if (condition){
          op
          MyWhile3(condition)(op)
        }
      }
      ff _
    }
    //调用
    var n = 10
    MyWhile3(n>=1){
      println(n)
      n -= 1
    }
  }
}
