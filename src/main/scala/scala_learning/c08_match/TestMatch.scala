package scala_learning.c08_match

object TestMatch {
  def main(args: Array[String]): Unit = {
    var a = 10
    var b = 20
    var op = '+'

    //模式匹配
//    val res: Any = op match {
//      case '+' => a + b
//      case '-' => a - b
//      case '*' => a * b
//      case '/' => a / b
//      case _ => "运算符不合法"
//    }
//
//    println(res)

    def Mycomputer(op:Char,a:Double,b:Double) ={
      val res: Any = op match {
        case '+' => a + b
        case '-' => a - b
        case '*' => a * b
        case '/' => a / b
        case _ => "运算符不合法"
      }
      res
    }

    //自定义计算器
    println(Mycomputer('*', 5.99, b))

    //通过模式守卫 求一个整数的绝对值
    def abs(num:Int)={
      num match {
        case i:Int if i >= 0 => i
        case j:Int if j < 0 => -j
      }
    }

    println(abs(-6))

  }

}
