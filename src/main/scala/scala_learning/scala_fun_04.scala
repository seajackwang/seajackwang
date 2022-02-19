package scala_learning

/**
 * Author: laowang
 * Date: 20220213
 * Dese:函数至简原则
 */
object scala_fun_04 {
  def main(args: Array[String]): Unit = {
    //1-9条
    //return可省，一段代码时花括号可省，可推到返回值可省，无返回值等号可省
//    def f1(name:String): String ={
//      return name
//    }
//    //简化1
//    def f2(name:String):String={
//      name
//    }
//    //简化2
//    def f3(name:String):String= name
//    //简化3
//    def f4(name:String)= name
//    //简化4
//    def f5(name:String) {
//      println(name)
//    }
//    f5("laowang")

    //参数为函数: f函数名 String参数类型 =>默认用法  Unit无返回值
    def f9(f:(String)=>Unit):Unit={
      f("laowang 666")
    }

//    def f10(s:String): Unit ={
//      println(s)
//    }
//    f9(f10)

    //不定义f10,可使用匿名函数:通过lambda表达式实现
//    f9((s:String)=>{println(s)})
    //lambda简化1
//    f9((s)=>{println(s)})
    //lambda简化2
//    f9(s=>{println(s)})
    //lambda简化3
//    f9(s=>println(s))
    //lambda简化4
//    f9(println(_))
    //lambda简化5
//    f9(println)

  }

}
